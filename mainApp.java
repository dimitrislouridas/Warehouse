//--------------------------
// authors:
//         author1:Dimitris Louridas (p3200281)
//         author2:Xristos Giapitzakis(p3200034)
//--------------------------

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class mainApp{
    public static void main(String[] args) throws IOException{
       ReadFile readFile=new ReadFile();
       ReadOrders readOrders=new ReadOrders();
       ReadSales readSales=new ReadSales();
       try{
        readFile.readFileAndCreateObjects();
        readOrders.readFileAndCreateOrders();
        readSales.readFileAndCreateSales();
       }catch (IOException e) {
    // Handle the exception for ReadFileAndCreateOrders()
        e.printStackTrace();
         }

       ArrayList<Product> products=readFile.getProducts();
       ArrayList<Order>orders=readOrders.getOrders();
       ArrayList<Sale>sales=readSales.getSales();
       
       
        

        //main
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 0:
                    displayDeviceOverview(scanner, products,sales,orders);
                    break;
                case 1:
                    displayOrderOverview(scanner,orders,sales);
                    break;
                case 2:
                    displaySalesOverview(scanner,sales);
                    break;
                case 3:
                     Writer writer = new Writer();
                     System.out.println("Exiting the program...");
                     try{
                        writer.createFileWithSales(sales);
                        writer.createFileWithOrders(orders);
                     }catch (IOException e) {
    // Handle the exception
                         e.printStackTrace();
                         }

                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private static void displayMenu() {
        System.out.println("--- Main Menu ---");
        System.out.println("0. Device Overview");
        System.out.println("1. Order Overview");
        System.out.println("2. Sales Overview");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }
   //display device overview and then doing does what is requested
    private static void displayDeviceOverview(Scanner scanner, ArrayList<Product> products, ArrayList<Sale> sales, ArrayList<Order> orders) {
        System.out.println("--- Device Overview ---");
        System.out.println("Categories: ");
        System.out.println("1. Audio and Video");
        System.out.println("2. Gaming");
        System.out.println("3. Home Appliances");
        boolean validChoice = false;
        int categoryChoice;
    
        while (!validChoice) {
            System.out.print("Enter the category number: ");
            categoryChoice = scanner.nextInt();
            scanner.nextLine();
    
            switch (categoryChoice) {
                case 1:
                    System.out.println("--- Product Choices ---");
                    System.out.println("1. Televisions");
                    System.out.println("2. DVD");
                    System.out.println("3. Cameras");
    
                    boolean validProductChoiceAV = false;
                    while (!validProductChoiceAV) {
                        System.out.print("Enter the product category number: ");
                        int productChoiceAV = scanner.nextInt();
                        scanner.nextLine();
    
                        switch (productChoiceAV) {
                            case 1:
                                System.out.println("---Televisions---");
                                for (Product product : products) {
                                    if (product instanceof Televisions) {
                                        System.out.println("Model: " + product.getName_model());
                                        System.out.println("Code: "+product.getCode());
                                        System.out.println("Stock: "+product.getStock());
                                        System.out.println("-----------------");
                                    }
                                }
                                validChoice = true;
                                validProductChoiceAV = true;
                                break;
    
                            case 2:
                                System.out.println("---DVD---");
                                for (Product product : products) {
                                    if (product instanceof DVD) {
                                        System.out.println("Model: " + product.getName_model());
                                        System.out.println("Code: "+product.getCode());
                                        System.out.println("Stock: "+product.getStock());
                                        System.out.println("-----------------");
                                    }
                                }
                                validChoice = true;
                                validProductChoiceAV = true;
                                break;
    
                            case 3:
                                System.out.println("---Cameras---");
                                for (Product product : products) {
                                    if (product instanceof Cameras) {
                                        System.out.println("Model: " + product.getName_model());
                                        System.out.println("Code: "+product.getCode());
                                        System.out.println("Stock: "+product.getStock());
                                        System.out.println("-----------------");
                                    }
                                }
                                validChoice = true;
                                validProductChoiceAV = true;
                                break;
    
                            default:
                                System.out.println("Invalid product category choice.");
                                break;
                        }
                    }
                    break;
    
                case 2:
                    System.out.println("--- Product Choices ---");
                    System.out.println("1. Gaming Consoles");
    
                    boolean validProductChoiceGaming = false;
                    while (!validProductChoiceGaming) {
                        System.out.print("Enter the product category number: ");
                        int productChoiceGaming = scanner.nextInt();
                        scanner.nextLine();
    
                        switch (productChoiceGaming) {
                            case 1:
                                System.out.println("---Consoles---");
                                for (Product product : products) {
                                    if (product instanceof Consoles) {
                                        System.out.println("Model: " + product.getName_model());
                                        System.out.println("Code: "+product.getCode());
                                        System.out.println("Stock: "+product.getStock());
                                        System.out.println("-----------------");
                                    }
                                }
                                validChoice = true;
                                validProductChoiceGaming = true;
                                break;
    
                            default:
                                System.out.println("Invalid product category choice");
                                break;
                        }
                    }
                    break;
    
                case 3:
                    System.out.println("--- Product Choices ---");
                    System.out.println("1. Washing Machines");
                    System.out.println("2. Refrigerators");
    
                    boolean validProductChoiceHomeAppliances = false;
                    while (!validProductChoiceHomeAppliances) {
                        System.out.print("Enter the product category number: ");
                        int productChoiceHomeAppliances = scanner.nextInt();
                        scanner.nextLine();
    
                        switch (productChoiceHomeAppliances) {
                            case 1:
                                System.out.println("---Washing Machines---");
                                for (Product product : products) {
                                    if (product instanceof WashingMachines) {
                                        System.out.println("Model: " + product.getName_model());
                                        System.out.println("Code: "+product.getCode());
                                        System.out.println("Stock: "+product.getStock());
                                        System.out.println("-----------------");
                                    }
                                }
                                validChoice = true;
                                validProductChoiceHomeAppliances = true;
                                break;
    
                            case 2:
                                System.out.println("---Refrigerators---");
                                for (Product product : products) {
                                    if (product instanceof Refrigerators) {
                                        System.out.println("Model: " + product.getName_model());
                                        System.out.println("Code: "+product.getCode());
                                        System.out.println("Stock: "+product.getStock());
                                        System.out.println("-----------------");
                                    }
                                }
                                validChoice = true;
                                validProductChoiceHomeAppliances = true;
                                break;
    
                            default:
                                System.out.println("Invalid product category choice");
                                break;
                        }
                    }
                    break;
    
                default:
                    System.out.println("Invalid category choice. Please try again");
                    break;
            }
        }
    
        boolean validProductChoice = false;
while (!validProductChoice) {
    System.out.println("If you want to see more details about any specific product, please enter the code of the product you wish: ");
    String modelChoice = scanner.nextLine();

    for (Product product : products) {
        if (product.getCode().equalsIgnoreCase(modelChoice)) {
            System.out.println(product);

            System.out.println("Add to cart:");
            System.out.println("1. Yes");
            System.out.println("2. No");

            int buyChoice = 0;
            boolean validBuyChoice = false;
            while (!validBuyChoice) {
                System.out.print("Enter your choice: ");
                buyChoice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (buyChoice == 1 || buyChoice == 2) {
                    validBuyChoice = true;
                } else {
                    System.out.println("Invalid input. Please enter 1 for 'Yes' or 2 for 'No'.");
                }
            }

            if (buyChoice == 1) {
                if (product.getStock() == 0) {
                    OrderProcedure(product, scanner, orders);
                } else {
                    SaleProcedure(product, scanner, sales);
                }
            }

            validProductChoice = true;
            break;
        }
    }

    if (!validProductChoice) {
        System.out.println("Invalid model choice. Please try again.");
    }
  }
}


   //Sale procedure
    private static void  SaleProcedure(Product product ,Scanner scanner,ArrayList<Sale> sales){
        System.out.println("We have the product in our store and we can proceed with the sale: ");
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        // Create Sale object
        Sale sale = new Sale(product, customerName, phoneNumber, LocalDate.now(),product.finalPrice());
        sales.add(sale);
        System.out.println("The sale is completed!");
        
        
    }
    //Order procedure
    private static void OrderProcedure(Product product, Scanner scanner, ArrayList<Order> orders) {
        System.out.println("We don't have the product in our store, but we can place an order for the product:");
        System.out.println("Enter order details:");
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
    
        // Set the order date as the current system date
        LocalDate orderDate = LocalDate.now();
    
        // Get the expected arrival date from the user
        LocalDate expectedDate = null;
        boolean validDate = false;
        while (!validDate) {
            System.out.print("Enter expected arrival date (dd-MM-yyyy): ");
            String expectedDateStr = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            try {
                expectedDate = LocalDate.parse(expectedDateStr, formatter);
                if (expectedDate.isBefore(orderDate)) {
                    System.out.println("Invalid date. Expected arrival date should be the same or later than the current date.");
                } else {
                    validDate = true;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in the format dd-MM-yyyy.");
            }
        }
    
        // Create the order object
        Order order = new Order(product, customerName, phoneNumber, orderDate, expectedDate, product.finalPrice());
        orders.add(order);
        System.out.println("The order is completed!");
    }
    
    //display orders etc...
    private static void displayOrderOverview(Scanner scanner, ArrayList<Order> orders, ArrayList<Sale> sales) {
        if (orders.isEmpty()) {
            System.out.println("Sorry, your order list is empty!");
        } else {
            System.out.println("--- Orders ---");
            int counter = 0;
            for (Order order : orders) {
                counter++;
                System.out.println("Order " + counter + ":");
                System.out.println("Unique order code: " + order.getOrderCode());
                System.out.println("Customer name: " + order.getCustomerName());
                System.out.println("Product: " + order.getProductsName());
                System.out.println("Order Status: " + order.getOrderStatus());
                System.out.println("-----------------");
            }
            System.out.println("If you want to see the details of a specific order, enter the code of the order you wish:");
            int codeOr = scanner.nextInt();
            scanner.nextLine();
            boolean validCode = false;
            for (Order order : orders) {
                if (order.getOrderCode() == codeOr) {
                    validCode = true;
                    System.out.println(order);
                    System.out.println("Order arrival and sale:");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
    
                    int choice = 0;
                    boolean validChoice = false;
                    while (!validChoice) {
                        System.out.print("Enter your choice: ");
                        choice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
    
                        if (choice == 1 || choice == 2) {
                            validChoice = true;
                            if (choice == 1) {
                                if (order.getOrderStatus().equalsIgnoreCase("Executed")) {
                                    System.out.println("The order has already been executed and cannot be sold again.");
                                } else {
                                    System.out.println("Now your order will be sold...");
                                    order.getProduct().setStock(1);//doing that we  ensure that the stock will never be negative
                                    Sale sale = new Sale(order.getProduct(), order.getCustomerName(),
                                            order.getPhoneNumber(), LocalDate.now(), order.getFinalCost());
                                    sales.add(sale);
                                    System.out.println("The sale is completed");
                                    order.setExpectedArrivalDate(LocalDate.now());
                                    order.setOrderStatus();
                                }
                            } else {
                                System.out.println("Sale canceled by user.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter 1 for 'Yes' or 2 for 'No'.");
                        }
                    }
                    break;
                }
            }
    
            if (!validCode) {
                System.out.println("Invalid order code. Please try again.");
            }
        }
    }

    private static void displaySalesOverview(Scanner scanner,ArrayList<Sale> sales){
        if(sales.isEmpty()){
            System.out.println("Sorry, the sales list is empty!");
        }
        else{
            System.out.println("---  Sales ---");
            int counter=0;
            for(Sale sale:sales){
             counter++;
             System.out.println("Sale "+counter+" :");

             System.out.println(sale);
             System.out.println("-----------------");

            }
        }
    }
}