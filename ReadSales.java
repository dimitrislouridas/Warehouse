//--------------------------
// authors:
//         author1:Dimitris Louridas (p3200281)
//         author2:Xristos Giapitzakis(p3200034)
//--------------------------
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.*;

public class ReadSales {
    public ArrayList<Sale> sales = new ArrayList<Sale>();

    public void readFileAndCreateSales() throws IOException {
        BufferedReader reader = null;
        Product product = null;
        String line;
        System.out.println("\n >>>>>>> Adding Objects (Sales) from File to List ...");

        try {
            reader = new BufferedReader(new FileReader(new File("Sales.txt")));
            line = reader.readLine();
            while (line != null) {
                if (line.trim().equalsIgnoreCase("SALES_LIST")) {
                    line = reader.readLine();
                }
                if (line.trim().equalsIgnoreCase("{")) {
                    line = reader.readLine();
                }
                if (line.trim().startsWith("SALE")) {
                    line = reader.readLine();
                   Sale sale=new Sale();

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
                            } else if (line.trim().startsWith("NUMBER")) {
                                String orderNumberString = line.substring(line.indexOf("NUMBER") + 7).trim();
                                sale.setSaleCode(Integer.parseInt(orderNumberString));
                            } else if (line.trim().startsWith("NAME")) {
                                String name=line.substring(line.indexOf("NAME")+5).trim();
                                sale.setCustomerName(name);
                            } else if (line.trim().startsWith("DATE")) {
                                String dateString = line.substring(line.indexOf("DATE") + 5).trim();
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                                LocalDate date = LocalDate.parse(dateString, formatter);
                               sale.setSaleDate(date);
                            }else if (line.trim().startsWith("PHONE")) {
                                String phoneNumberString = line.substring(line.indexOf("PHONE") + 6).trim();
                               sale.setPhoneNumber(phoneNumberString);
                            } 
                            else if (line.trim().startsWith("PRICE")) {
                                double price = Double.parseDouble(line.substring(line.indexOf("PRICE") + 5).trim());
                                product.setPrice(price);
                                sale.setProduct(product);
                                sale.setFinalCost();
                            } 

                            line = reader.readLine();
                        }

                        if (line != null && line.trim().equals("}")) {
                            sale.setProduct(product);
                            sales.add(sale);
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
        if (sales.isEmpty()) {
            System.out.println("No sales available.");
        } else {
            for (Sale sale : sales) {
                System.out.println(sale.toString());
            }
        }
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }

    public static void main(String[] args) {
        try {
            ReadSales readSales = new ReadSales();
            readSales.readFileAndCreateSales();
            ArrayList<Sale> sales = readSales.getSales();

            System.out.println("Sales:");
            if (sales.isEmpty()) {
                System.out.println("No sales available.");
            } else {
                for (Sale sale : sales) {
                    System.out.println(sale);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}