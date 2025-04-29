//--------------------------
// authors:
//         author1:Dimitris Louridas (p3200281)
//         author2:Xristos Giapitzakis(p3200034)
//--------------------------

public class HomeDevices extends Product {
    // Constructor
    private static double discountPercentage = 0.20;
    public HomeDevices(){
         super("", 0, "", 0, "", 0.0);
    }

    public HomeDevices(String name_model, int stock, String code, int year, String constructor, double price) {
        super(name_model, stock, code, year, constructor, price);
        // 20% discount percentage for Home Devices
    }

    // Implementation of Product's abstract method
    @Override
    public double getDiscount() {
        return discountPercentage;
    }

    
}