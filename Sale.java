//--------------------------
// authors:
//         author1:Dimitris Louridas (p3200281)
//         author2:Xristos Giapitzakis(p3200034)
//--------------------------

import java.time.LocalDate;


public class Sale  {
    //variables
    private static int counter = 4532;
    private int salesCode;
    private Product product;
    private String customerName;
    private String phoneNumber;
    private LocalDate saleDate;
    private double finalCost;
    
    //constructor
    public Sale(){
        generateSalesCode();
        
    }
    public Sale(Product product, String customerName, String phoneNumber, LocalDate saleDate, double finalCost) {
        this.salesCode = generateSalesCode();
        this.product = product;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.saleDate = saleDate;
        this.finalCost = product.finalPrice();
        product.updateStock(); //a products method where every time a sale object is created the stock=-1.The stock will never be -1 etc.Because a sale is made only if stock>=1 in main
    }
    //setters/getters
    private static int generateSalesCode() {
        return ++counter;
    }

    public int getSalesCode() {
        return salesCode;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }
    public void setFinalCost(){
        this.finalCost=product.finalPrice();
    }
    public void setSaleCode(int salesCode){
        this.salesCode=salesCode;
    }

    
   
    //toString method

    @Override
    public String toString() {
        return  "--------------------"+"\n"+
                "Sale Details:\n" +
                "Sales Code: " + salesCode + "\n" +
                "Product: " + product.getName_model() + "\n" +
                "Customer Name: " + customerName + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Sale Date: " + saleDate + "\n" +
                "Price: $ "+product.getPrice()+"\n"+
                "Discount: $ "+product.getDiscount()*100+"%"+"\n"+
                "The amount you win is $: "+ product.WinningAmmount()+"\n"+
                "Final Cost: $" +finalCost+"\n"
                +"--------------------";
    }
}