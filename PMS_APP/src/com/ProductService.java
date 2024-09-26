package com;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService {

    private List<Product> products = new ArrayList<>();
    private static final String FILE_NAME = "product.ser";

    public ProductService() {
        loadProducts();
    }

    public void addProduct(Product product) {
        products.add(product);
        saveProducts();
    }

    public void deleteProduct(int pid) {
        products.removeIf(product -> product.getPid() == pid);
        saveProducts();
    }

    public void updateProduct(int pid, String pname, double price) {
        Optional<Product> productOpt = products.stream()
                                                .filter(product -> product.getPid() == pid)
                                                .findFirst();
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            product.setPname(pname);
            product.setPrice(price);
            saveProducts();
        }
    }

    public List<Product> retrieveProducts() {
        return products;
    }

    private void saveProducts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
    private void loadProducts() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                products = (List<Product>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
