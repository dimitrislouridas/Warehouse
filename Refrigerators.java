//--------------------------
// authors:
//         author1:Dimitris Louridas (p3200281)
//         author2:Xristos Giapitzakis(p3200034)
//--------------------------

public class Refrigerators extends HomeDevices {
    public static final String TYPE_SINGLE_DOOR = "Single Door";
    public static final String TYPE_DOUBLE_DOOR = "Double Door";
    public static final String TYPE_WARDROBE = "Wardrobe";
      //variables 
    private String type;
    private String energy;
    private int maintenanceCapacity;
    private int freezingCapacity;

    // Constructor
    public Refrigerators(){
         super("", 0, "", 0, "", 0.0);
    }
    public Refrigerators(String name_model,int  stock,String code, int year, String constructor,double price, String type,String energy, int maintenanceCapacity, int freezingCapacity){
        super(name_model, stock, code, year, constructor, price);
        validateType(type);
        this.type = type;
        this.energy = energy;
        this.maintenanceCapacity = maintenanceCapacity;
        this.freezingCapacity = freezingCapacity;
    }

    // Getter for type
    public String getType() {
        return type;
    }

    // Setter for type
    public void setType(String type) {
        validateType(type);
        this.type = type;
    }

    // Getter for energy
    public String getEnergy() {
        return energy;
    }

    // Setter for energy
    public void setEnergy(String energy) {
        this.energy = energy;
    }

    // Getter for maintenanceCapacity
    public int getMaintenanceCapacity() {
        return maintenanceCapacity;
    }

    // Setter for maintenanceCapacity
    public void setMaintenanceCapacity(int maintenanceCapacity) {
        this.maintenanceCapacity = maintenanceCapacity;
    }

    // Getter for freezingCapacity
    public int getFreezingCapacity() {
        return freezingCapacity;
    }

    // Setter for freezingCapacity
    public void setFreezingCapacity(int freezingCapacity) {
        this.freezingCapacity = freezingCapacity;
    }

    // Validate the type value
    private void validateType(String type) {
        if (!type.equals(TYPE_SINGLE_DOOR) && !type.equals(TYPE_DOUBLE_DOOR) && !type.equals(TYPE_WARDROBE)) {
            throw new IllegalArgumentException("Invalid refrigerator type");
        }
    }

    // toString method
    @Override
    public String toString() {
        return "Refrigerators:\n" +
                super.toString() +"\n"+
                "Type: " + type + "\n" +
                "Energy: " + energy + "\n" +
                "Maintenance Capacity: " + maintenanceCapacity + "\n" +
                "Freezing Capacity: " + freezingCapacity + "\n" +
                "--------------------";
    }
}
