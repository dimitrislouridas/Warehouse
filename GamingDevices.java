//--------------------------
// authors:
//         author1:Dimitris Louridas (p3200281)
//         author2:Xristos Giapitzakis(p3200034)
//--------------------------
public class GamingDevices extends Product {
    //constructor 
    private static double discountPercentage = 0.10;
    public GamingDevices(){
         super("", 0, "", 0, "", 0.0);
    }
    public GamingDevices(String name_model,int stock,String code,int year,String constructor,double price){

        super(name_model, stock, code,year, constructor,price);

    }
    //implementation of Product's abstract method
    @Override
    public double getDiscount(){
       

        return  discountPercentage;
    }

}
