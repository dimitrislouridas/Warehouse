//--------------------------
// authors:
//         author1:Dimitris Louridas (p3200281)
//         author2:Xristos Giapitzakis(p3200034)
//--------------------------

import java.time.LocalDate;


public class Order {
    //variables
    
    private static int counter = 8756;
    private int orderCode;
    private Product product;
    private String customerName;
    private String phoneNumber;
    private LocalDate orderDate;
    private LocalDate expectedArrivalDate;
    private double finalCost;
    private String orderStatus;
    

    //constructor
    public Order(){
        generateOrderCode();
        
    }
    public Order(Product product, String customerName, String phoneNumber, LocalDate orderDate, LocalDate expectedArrivalDate, double finalCost) {
        this.orderCode = generateOrderCode();
        this.product = product;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.orderDate = orderDate;
        this.expectedArrivalDate = expectedArrivalDate;
        this.finalCost = product.finalPrice();
        this.orderStatus = setOrderStatus();
        
    }
    //setters/getters
    public void setOrderCode(int orderCode){
        this.orderCode=orderCode;
    }
    private static int generateOrderCode() {
        return ++counter;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public Product getProduct() {
        return product;
    }
    
    public String getProductsName(){
       return product.getName_model();
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

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getExpectedArrivalDate() {
        return expectedArrivalDate;
    }

    public void setExpectedArrivalDate(LocalDate expectedArrivalDate) {
        this.expectedArrivalDate = expectedArrivalDate;
    }

    public double getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(double finalCost) {
        this.finalCost = finalCost;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
    //method for calculating order's status
    public String setOrderStatus() {
        if (orderDate.equals(expectedArrivalDate)) {
            this.orderStatus = "Executed";
        } else {
            this.orderStatus = "Pending";
        }
        return orderStatus;
    }

    //toString
    @Override
    public String toString() {
        return "--------------------" +"\n" +
                "Order Details:\n" +
                "Order Code: " + orderCode + "\n" +
                "Product: " + product.getName_model() + "\n" +
                "Customer Name: " + customerName + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Order Date: " + orderDate + "\n" +
                "Expected Arrival Date: " + expectedArrivalDate + "\n" +
                "Price $: "+product.getPrice()+ "\n"+
                "Discount: "+product.getDiscount()*100 +"%"+"\n"+
                "The amount you win is $: "+ product.WinningAmmount()+"\n"+
                "Final Price $: "+getFinalCost()+"\n"+
                "Order Status: " + orderStatus +"\n"+
                "--------------------";
    }
}