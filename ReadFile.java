//--------------------------
// authors:
//         author1:Dimitris Louridas (p3200281)
//         author2:Xristos Giapitzakis(p3200034)
//--------------------------
import java.util.*;
import java.io.*;
import java.time.LocalDate;

public class ReadFile {
    public ArrayList<Product> products = new ArrayList<Product>();
    

    public void readFileAndCreateObjects()throws IOException {
        BufferedReader reader = null;
        Product product = null;
        String line;
        System.out.println("\n >>>>>>> Adding Objects (Items) from File to List ...");

        try {
            reader = new BufferedReader(new FileReader(new File("Available_Products.txt")));
            line = reader.readLine();
            while (line != null) {
                if (line.trim().equalsIgnoreCase("ITEM_LIST")) {
                    line = reader.readLine();
                }
                if (line.trim().equalsIgnoreCase("{")) {
                    line = reader.readLine();
                }
                if (line.trim().startsWith("ITEM")) {
                    line = reader.readLine();

                    if (line.trim().equalsIgnoreCase("{")) {
                        line = reader.readLine();

                        if (line.startsWith("ITEM_TYPE")) {

                            if (line.trim().substring(10).trim().equals("tv")) {
                                product=tvCreation(reader, line);
                                products.add(product);
                            } else if (line.trim().substring(10).trim().equals("camera")) {
                                product=cameraCreation(reader,line);
                                products.add(product);
                            } else if (line.trim().substring(10).trim().equals("dvd")) {
                                product=dvdCreation(reader,line);
                                products.add(product);
                            } else if (line.trim().substring(10).trim().equals("console")) {
                                product=consoleCreation(reader,line);
                                products.add(product);
                            } else if (line.trim().substring(10).trim().equals("refrigerator")) {
                                product=refrigeratorCreation(reader,line);
                                products.add(product);
                            } else if (line.trim().substring(10).trim().equals("washing_machine")) {
                                product=washingmachineCreation(reader,line);
                                products.add(product);
                            }
                        }
                    }

                }line = reader.readLine();
                
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading line: " + e.getMessage());
        }
    }

    public static Product tvCreation(BufferedReader reader, String line)throws IOException {
        Televisions television = new Televisions(); // Create a Televisions object
        try {
            line = reader.readLine();
            // Set the common attributes of the Product class
            if (line.trim().startsWith("NAME_MODEL")) {
                television.setName_model(line.substring(11).trim());
                line = reader.readLine();
            }
            if (line.startsWith("STOCK")) {
                television.setStock(Integer.parseInt(line.substring(6).trim()));
                line = reader.readLine();
            }
            if (line.startsWith("CODE")) {
                television.setCode(line.substring(5).trim());
                line = reader.readLine();
            }
            if (line.startsWith("YEAR")) {
                television.setYear(Integer.parseInt(line.substring(5).trim()));
                line = reader.readLine();
            }
            if (line.startsWith("CONSTRUCTOR")) {
                television.setConstructor(line.substring(12).trim());
                line = reader.readLine();
            }
            if (line.startsWith("PRICE")) {
                television.setPrice(Double.parseDouble(line.substring(6).trim()));
                line = reader.readLine();
            }

            // Set the specific attributes of the Televisions class
            if (line.startsWith("TYPE")) {
                television.setType(line.substring(5).trim());
                line = reader.readLine();
            }
            if (line.startsWith("DIMENSION")) {
                television.setDimension(Integer.parseInt(line.substring(10).trim()));
                line = reader.readLine();
            }
            if (line.startsWith("ANALYSIS")) {
                television.setAnalysis(line.substring(9).trim());
                line = reader.readLine();
            }
            if (line.startsWith("PORTS")) {
                television.setPorts(line.substring(6).trim());
                line = reader.readLine();
            }
            if (line.trim().equals("}")) {
               //do nothing 
            }
        } catch (IOException e) {
            System.out.println("Error reading line: " + e.getMessage());
        }
        return television;
    }

    public static Product cameraCreation(BufferedReader reader, String line
    )throws IOException{
        Cameras camera = new Cameras(); // Create a Cameras object
        try {
            line = reader.readLine();
            // Set the common attributes of the Product class
            if (line.trim().startsWith("NAME_MODEL")) {
                camera.setName_model(line.substring(11).trim());
                line = reader.readLine();
            }
            if (line.startsWith("STOCK")) {
                camera.setStock(Integer.parseInt(line.substring(6).trim()));
                line = reader.readLine();
            }
            if (line.startsWith("CODE")) {
                camera.setCode(line.substring(5).trim());
                line = reader.readLine();
            }
            if (line.startsWith("YEAR")) {
                camera.setYear(Integer.parseInt(line.substring(5).trim()));
                line = reader.readLine();
            }
            if (line.startsWith("CONSTRUCTOR")) {
                camera.setConstructor(line.substring(12).trim());
                line = reader.readLine();
            }
            if (line.startsWith("PRICE")) {
                camera.setPrice(Double.parseDouble(line.substring(6).trim()));
                line = reader.readLine();
            }

            // Set the specific attributes of the Cameras class
            if (line.startsWith("TYPE")) {
                camera.setType(line.substring(5).trim());
                line = reader.readLine();
            }
            if (line.startsWith("SIZE")) {
                camera.setSize(line.substring(5).trim());
                line = reader.readLine();
            }
            if (line.startsWith("OPTICALZOOM")) {
                camera.setOpticalZoom(Double.parseDouble(line.substring(12).trim()));
                line = reader.readLine();
            }
            if (line.startsWith("DIGITALZOOM")) {
                camera.setDigitalZoom(Double.parseDouble(line.substring(12).trim()));
                line = reader.readLine();
            }
            if (line.startsWith("MEGAPIXELS")) {
                camera.setMegapixels(Integer.parseInt(line.substring(11).trim()));
                line = reader.readLine();
            }
            if (line.trim().equals("}")) {
              //do nothing
            }
        } catch (IOException e) {
            System.out.println("Error reading line: " + e.getMessage());
        }
        return camera;
    }

    public static Product dvdCreation(BufferedReader reader, String line)throws IOException {
        DVD dvd = new DVD(); // Create a DVD object
    try {
        line = reader.readLine();
        // Set the common attributes of the Product class
        if (line.trim().startsWith("NAME_MODEL")) {
            dvd.setName_model(line.substring(11).trim());
            line = reader.readLine();
        }
        if (line.startsWith("STOCK")) {
            dvd.setStock(Integer.parseInt(line.substring(6).trim()));
            line = reader.readLine();
        }
        if (line.startsWith("CODE")) {
            dvd.setCode(line.substring(5).trim());
            line = reader.readLine();
        }
        if (line.startsWith("YEAR")) {
            dvd.setYear(Integer.parseInt(line.substring(5).trim()));
            line = reader.readLine();
        }
        if (line.startsWith("CONSTRUCTOR")) {
            dvd.setConstructor(line.substring(12).trim());
            line = reader.readLine();
        }
        if (line.startsWith("PRICE")) {
            dvd.setPrice(Double.parseDouble(line.substring(6).trim()));
            line = reader.readLine();
        }

        // Set the specific attributes of the DVD class
        if (line.startsWith("TYPE")) {
            dvd.setType(line.substring(5).trim());
            line = reader.readLine();
        }
        if (line.startsWith("ANALYSIS")) {
            dvd.setAnalysis(line.substring(9).trim());
            line = reader.readLine();
        }
        if (line.startsWith("FORMAT")) {
            dvd.setReproductionFormat(line.substring(7).trim());
            line = reader.readLine();
        }
        if (line.trim().equals("}")) {
            //do nothing 
        }
    } catch (IOException e) {
        System.out.println("Error reading line: " + e.getMessage());
    }
    return dvd;
}

public static Product consoleCreation(BufferedReader reader, String line)throws IOException {
    Consoles console = new Consoles(); // Create a Consoles object
    try {
        line = reader.readLine();
        // Set the common attributes of the Product class
        if (line.trim().startsWith("NAME_MODEL")) {
            console.setName_model(line.substring(11).trim());
            line = reader.readLine();
        }
        if (line.startsWith("STOCK")) {
            console.setStock(Integer.parseInt(line.substring(6).trim()));
            line = reader.readLine();
        }
        if (line.startsWith("CODE")) {
            console.setCode(line.substring(5).trim());
            line = reader.readLine();
        }
        if (line.startsWith("YEAR")) {
            console.setYear(Integer.parseInt(line.substring(5).trim()));
            line = reader.readLine();
        }
        if (line.startsWith("CONSTRUCTOR")) {
            console.setConstructor(line.substring(12).trim());
            line = reader.readLine();
        }
        if (line.startsWith("PRICE")) {
            console.setPrice(Double.parseDouble(line.substring(6).trim()));
            line = reader.readLine();
        }

        // Set the specific attributes of the Consoles class
        if (line.startsWith("TYPE")) {
            console.setType(line.substring(5).trim());
            line = reader.readLine();
        }
        if (line.startsWith("PROCESSOR")) {
            console.setProcessor(line.substring(10).trim());
            line = reader.readLine();
        }
        if (line.startsWith("GRAPHICS")) {
            console.setGraphics(line.substring(9).trim());
            line = reader.readLine();
        }
        if (line.startsWith("AUDIO")) {
            console.setSound(line.substring(6).trim());
            line = reader.readLine();
        }
        if (line.startsWith("STORAGE")) {
            console.setHarddiskcapacity(Integer.parseInt(line.substring(8).trim()));
            line = reader.readLine();
        }
        if (line.trim().equals("}")) {
            //do nothing
        }
    } catch (IOException e) {
        System.out.println("Error reading line: " + e.getMessage());
    }
    return console;
}

public static Product refrigeratorCreation(BufferedReader reader, String line)throws IOException {
    Refrigerators refrigerator = new Refrigerators(); // Create a Refrigerators object
    try {
        line = reader.readLine();
        // Set the common attributes of the Product class
        if (line.trim().startsWith("NAME_MODEL")) {
            refrigerator.setName_model(line.substring(11).trim());
            line = reader.readLine();
        }
        if (line.startsWith("STOCK")) {
            refrigerator.setStock(Integer.parseInt(line.substring(6).trim()));
            line = reader.readLine();
        }
        if (line.startsWith("CODE")) {
            refrigerator.setCode(line.substring(5).trim());
            line = reader.readLine();
        }
        if (line.startsWith("YEAR")) {
            refrigerator.setYear(Integer.parseInt(line.substring(5).trim()));
            line = reader.readLine();
        }
        if (line.startsWith("CONSTRUCTOR")) {
            refrigerator.setConstructor(line.substring(12).trim());
            line = reader.readLine();
        }
        if (line.startsWith("PRICE")) {
            refrigerator.setPrice(Double.parseDouble(line.substring(6).trim()));
            line = reader.readLine();
        }

        // Set the specific attributes of the Refrigerators class
        if (line.startsWith("TYPE")) {
            refrigerator.setType(line.substring(5).trim());
            line = reader.readLine();
        }
        if (line.startsWith("ENERGY_RATING")) {
            refrigerator.setEnergy(line.substring(14).trim());
            line = reader.readLine();
        }
        if (line.startsWith("CAPACITY")) {
            refrigerator.setMaintenanceCapacity(Integer.parseInt(line.substring(9).trim()));
            line = reader.readLine();
        }
        if (line.startsWith("FREEZING")) {
            refrigerator.setFreezingCapacity(Integer.parseInt(line.substring(9).trim()));
            line = reader.readLine();
        }
        if (line.trim().equals("}")) {
            //do nothing 
        }
    } catch (IOException e) {
        System.out.println("Error reading line: " + e.getMessage());
    }
    return refrigerator;
}

public static Product washingmachineCreation(BufferedReader reader, String line)throws IOException {
    WashingMachines washingMachine = new WashingMachines(); // Create a WashingMachines object
    try {
        line = reader.readLine();
        // Set the common attributes of the Product class
        if (line.trim().startsWith("NAME_MODEL")) {
            washingMachine.setName_model(line.substring(11).trim());
            line = reader.readLine();
        }
        if (line.startsWith("STOCK")) {
            washingMachine.setStock(Integer.parseInt(line.substring(6).trim()));
            line = reader.readLine();
        }
        if (line.startsWith("CODE")) {
            washingMachine.setCode(line.substring(5).trim());
            line = reader.readLine();
        }
        if (line.startsWith("YEAR")) {
            washingMachine.setYear(Integer.parseInt(line.substring(5).trim()));
            line = reader.readLine();
        }
        if (line.startsWith("CONSTRUCTOR")) {
            washingMachine.setConstructor(line.substring(12).trim());
            line = reader.readLine();
        }
        if (line.startsWith("PRICE")) {
            washingMachine.setPrice(Double.parseDouble(line.substring(6).trim()));
            line = reader.readLine();
        }

        // Set the specific attributes of the WashingMachines class
        if (line.startsWith("ENERGY_RATING")) {
            washingMachine.setEnergyClass(line.substring(14).trim());
            line = reader.readLine();
        }
        if (line.startsWith("CAPACITY")) {
            washingMachine.setCapacity(Integer.parseInt(line.substring(9).trim()));
            line = reader.readLine();
        }
        if (line.startsWith("SPIN_SPEED")) {
            washingMachine.setRevolutions(Integer.parseInt(line.substring(11).trim()));
            line = reader.readLine();
        }
        if (line.trim().equals("}")) {
            //do nothing
           
        }
    } catch (IOException e) {
        System.out.println("Error reading line: " + e.getMessage());
    }
    return washingMachine;
}

 
 
  public void printList() {
    System.out.println("\n>>>>>> Printing List...\n");
    if (products.isEmpty()) {
        System.out.println("No products available.");
    } else {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }
}

// Getter method for the products list
    public ArrayList<Product> getProducts() {
        return products;
    }


  
//testing

public static void main(String[] args) {
        ReadFile fileReader = new ReadFile();
        try{
        fileReader.readFileAndCreateObjects();
       
        }catch (IOException e) {
          // Handle the exception or display an error message
          e.printStackTrace();
        }
        // Print the list of products and orders
        System.out.println("Products:");
        for (Product product : fileReader.products) {
            System.out.println(product);
        }

       
    }
}

