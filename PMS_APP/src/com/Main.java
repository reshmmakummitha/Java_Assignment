package com;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ProductService productService = new ProductService();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1: Add Product");
            System.out.println("2: Retrieve Products");
            System.out.println("3: Delete Product");
            System.out.println("4: Update Product");
            System.out.println("5: Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter PID: ");
                    int pid = scanner.nextInt();
                    scanner.nextLine();  

                    System.out.print("Enter Product Name: ");
                    String pname = scanner.nextLine();

                    System.out.print("Enter Product Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();  

                    Product product = new Product(pid, pname, price);
                    productService.addProduct(product);
                    break;

                case 2:
                    List<Product> products = productService.retrieveProducts();
                    products.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter PID of Product to delete: ");
                    int deletePid = scanner.nextInt();
                    productService.deleteProduct(deletePid);
                    break;

                case 4:
                    System.out.print("Enter PID of Product to update: ");
                    int updatePid = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    System.out.print("Enter new Product Name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter new Product Price: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline

                    productService.updateProduct(updatePid, newName, newPrice);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
