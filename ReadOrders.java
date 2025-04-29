//--------------------------
// authors:
//         author1:Dimitris Louridas (p3200281)
//         author2:Xristos Giapitzakis(p3200034)
//--------------------------

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.*;

public class ReadOrders {
    public ArrayList<Order> orders = new ArrayList<Order>();

    public void readFileAndCreateOrders() throws IOException {
        BufferedReader reader = null;
        Product product = null;
        String line;
        System.out.println("\n >>>>>>> Adding Objects (Orders) from File to List ...");

        try {
            reader = new BufferedReader(new FileReader(new File("Orders.txt")));
            line = reader.readLine();
            while (line != null) {
                if (line.trim().equalsIgnoreCase("ORDER_LIST")) {
                    line = reader.readLine();
                }
                if (line.trim().equalsIgnoreCase("{")) {
                    line = reader.readLine();
                }
                if (line.trim().startsWith("ORDER")) {
                    line = reader.readLine();
                    Order order = new Order();

                    if (line.trim().equalsIgnoreCase("{")) {
                        line = reader.readLine();

                        if (line.trim().startsWith("ITEM_TYPE")) {
                            String type = line.trim().substring(10).trim();
                            if (type.equalsIgnoreCase("tv")) {
                                product = new Televisions();
                            } else if (type.equalsIgnoreCase("camera")) {
                                product = new Cameras();
                            } else if (type.equalsIgnoreCase("dvd")) {
                                product = new DVD();
                            } else if (type.equalsIgnoreCase("refrigerator")) {
                                product = new Refrigerators();
                            } else if (type.equalsIgnoreCase("console")) {
                                product = new Consoles();
                            } else if (type.equalsIgnoreCase("washing_machine")) {
                                product = new WashingMachines();
                            } else {
                                System.out.println("Invalid item type ::: Error");
                                break;
                            }
                            line = reader.readLine();
                        }

                        while (line != null && !line.trim().equals("}")) {
                            if (line.trim().startsWith("MODEL")) {
                                String model=line.substring(line.indexOf("MODEL")+6).trim();
                                product.setName_model(model);
                            } else if (line.trim().startsWith("MANUFACTURER")) {
                                product.setConstructor(line.substring(line.indexOf("MODEL")+12).trim());
                            } else if (line.trim().startsWith("ORDER_NUMBER")) {
                                String orderNumberString = line.substring(line.indexOf("ORDER_NUMBER") + 13).trim();
                                order.setOrderCode(Integer.parseInt(orderNumberString));
                            } else if (line.trim().startsWith("NAME")) {
                                String name=line.substring(line.indexOf("NAME")+5).trim();
                                order.setCustomerName(name);
                            } else if (line.trim().startsWith("ORDER_DATE")) {
                                String dateString = line.substring(line.indexOf("ORDER_DATE") + 11).trim();
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                                LocalDate orderDate = LocalDate.parse(dateString, formatter);
                                order.setOrderDate(orderDate);
                            } else if (line.trim().startsWith("DELIVERY_DATE")) {
                                String dateString = line.substring(line.indexOf("DELIVERY_DATE") + 14).trim();
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                                LocalDate deliveryDate = LocalDate.parse(dateString, formatter);
                                order.setExpectedArrivalDate(deliveryDate);
                            } else if (line.trim().startsWith("PHONE")) {
                                String phoneNumberString = line.substring(line.indexOf("PHONE") + 6).trim();
                                order.setPhoneNumber(phoneNumberString);
                            } 
                            else if (line.trim().startsWith("PRICE")) {
                                double price = Double.parseDouble(line.substring(line.indexOf("PRICE") + 5).trim());
                                product.setPrice(price);
                                double finalCost = product.finalPrice();
                                order.setFinalCost(finalCost);
                            } else if (line.trim().startsWith("STATUS")) {
                                order.setOrderStatus();
                            }

                            line = reader.readLine();
                        }

                        if (line != null && line.trim().equals("}")) {
                            order.setProduct(product);
                            orders.add(order);
                        }
                    }
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading line: " + e.getMessage());
        }
    }

    public void printList() {
        System.out.println("\n>>>>>> Printing List...\n");
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
        } else {
            for (Order order : orders) {
                System.out.println(order.toString());
            }
        }
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
//testing
    public static void main(String[] args) {
        try {
            ReadOrders readOrders = new ReadOrders();
            readOrders.readFileAndCreateOrders();
            ArrayList<Order> orders = readOrders.getOrders();

            System.out.println("Orders:");
            if (orders.isEmpty()) {
                System.out.println("No orders available.");
            } else {
                for (Order order : orders) {
                    System.out.println(order);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





