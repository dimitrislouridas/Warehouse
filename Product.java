//--------------------------
// authors:
//         author1:Dimitris Louridas (p3200281)
//         author2:Xristos Giapitzakis(p3200034)
//--------------------------
import java.text.DecimalFormat;

abstract public class Product {
    // variables
    private String name_model;
    private int stock;
    private String code;
    private int year;
    private String constructor;
    private double price;

    // constructor
    public Product(String name_model, int stock, String code, int year, String constructor, double price) {
        this.name_model = name_model;
        this.stock = stock;
        this.code = code;
        this.year = year;
        this.constructor = constructor;
        this.price = price;
    }

    // setters/getters
    public String getName_model() {
        return name_model;
    }

    public void setName_model(String name_model) {
        this.name_model = name_model;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getConstructor() {
        return constructor;
    }

    public void setConstructor(String constructor) {
        this.constructor = constructor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // abstract method for calculating discount
    public abstract double getDiscount();

    // calculate final price
    public double finalPrice() {
        return getPrice() - calculateDiscount();
    }

    public double calculateDiscount() {
        return getPrice() * getDiscount();
    }

    public String WinningAmmount() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(calculateDiscount());
    }

    public void updateStock() {
        stock -= 1;
    }

    // to string
    public String toString() {
        return "--------------------" + "\n" +
                "Product Details:\n" +
                "Model: " + name_model + "\n" +
                "Stock: " + stock + "\n" +
                "Code: " + code + "\n" +
                "Year: " + year + "\n" +
                "Manufacturer: " + constructor + "\n" +
                "Price: $" + price + "\n" +
                "Discount: " + getDiscount() * 100 + " %\n" +
                "The amount you win is $: " + WinningAmmount() + "\n" +
                "Final Price after discount: $" + finalPrice();
    }
}