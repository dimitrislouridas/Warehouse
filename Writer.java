//--------------------------
// authors:
//         author1:Dimitris Louridas (p3200281)
//         author2:Xristos Giapitzakis(p3200034)
//--------------------------
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Writer {
    public ArrayList<Order> orders;
    public ArrayList<Sale>sales;

   

    public void createFileWithOrders(ArrayList<Order> orders)throws IOException {
        System.out.println(" >>>>>>> Write data(Orders) from ARRAYLIST to FILE...");
        FileWriter writer = null;
      

        try {
           writer = new FileWriter(new File("Orders.txt")); // Append mode: true
            writer.write("ORDER_LIST" + "\n" + "{" + "\n");

            for (Order order : orders) {
                writer.write("\tORDER" + "\n");
                writer.write("\t{" + "\n");

                Product product = order.getProduct();
                if (product instanceof Televisions) {
                    writer.write("\t\tITEM_TYPE tv" + "\n");
                } else if (product instanceof Cameras) {
                    writer.write("\t\tITEM_TYPE camera" + "\n");
                } else if (product instanceof DVD) {
                    writer.write("\t\tITEM_TYPE dvd" + "\n");
                } else if (product instanceof Refrigerators) {
                    writer.write("\t\tITEM_TYPE refrigerator" + "\n");
                } else if (product instanceof Consoles) {
                    writer.write("\t\tITEM_TYPE console" + "\n");
                } else if (product instanceof WashingMachines) {
                    writer.write("\t\tITEM_TYPE washing_machine" + "\n");
                } else {
                    System.out.println("Invalid product type");
                    continue;
                }

                writer.write("\t\tMODEL " + product.getName_model() + "\n");
                writer.write("\t\tMANUFACTURER " + product.getConstructor() + "\n");
                writer.write("\t\tORDER_NUMBER " + order.getOrderCode() + "\n");
                writer.write("\t\tNAME " + order.getCustomerName() + "\n");
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                String formattedOrderDate = order.getOrderDate().format(dateFormatter);

                writer.write("\t\tORDER_DATE " + formattedOrderDate + "\n");


                String formattedDeliveryDate = order.getExpectedArrivalDate().format(dateFormatter);

                writer.write("\t\tDELIVERY_DATE " + formattedDeliveryDate + "\n");
                writer.write("\t\tPRICE " + product.getPrice() + "\n");
                writer.write("\t\tPHONE " + order.getPhoneNumber() + "\n");
                writer.write("\t\tSTATUS " + order.setOrderStatus() + "\n");

                writer.write("\t}" + "\n");
            }

            writer.write("}");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing file: " + e.getMessage());
            }
        }
    }

     public void createFileWithSales(ArrayList<Sale> sales)throws IOException {
        System.out.println(" >>>>>>> Write data(Sales) from ARRAYLIST to FILE...");
        FileWriter writer = null;

        try {
            writer = new FileWriter(new File("Sales.txt")); // Append mode: true
            writer.write("SALES_LIST" + "\n" + "{" + "\n");

            for (Sale sale : sales) {
                writer.write("\tSALE" + "\n");
                writer.write("\t{" + "\n");

                Product product = sale.getProduct();
                if (product instanceof Televisions) {
                    writer.write("\t\tITEM_TYPE tv" + "\n");
                } else if (product instanceof Cameras) {
                    writer.write("\t\tITEM_TYPE camera" + "\n");
                } else if (product instanceof DVD) {
                    writer.write("\t\tITEM_TYPE dvd" + "\n");
                } else if (product instanceof Refrigerators) {
                    writer.write("\t\tITEM_TYPE refrigerator" + "\n");
                } else if (product instanceof Consoles) {
                    writer.write("\t\tITEM_TYPE console" + "\n");
                } else if (product instanceof WashingMachines) {
                    writer.write("\t\tITEM_TYPE washing_machine" + "\n");
                } else {
                    System.out.println("Invalid product type");
                    continue;
                }

                writer.write("\t\tMODEL " + product.getName_model() + "\n");
                writer.write("\t\tMANUFACTURER " + product.getConstructor() + "\n");
                writer.write("\t\tNUMBER " + sale.getSalesCode()+ "\n");
                writer.write("\t\tNAME " + sale.getCustomerName() + "\n");
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String formattedSaleDate = sale.getSaleDate().format(dateFormatter);

                writer.write("\t\tDATE " + formattedSaleDate+"\n");
                writer.write("\t\tPHONE " + sale.getPhoneNumber() + "\n");
                writer.write("\t\tPRICE " + product.getPrice() + "\n");

                writer.write("\t}" + "\n");
            }

            writer.write("}");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing file: " + e.getMessage());
            }
        }
    }
}
