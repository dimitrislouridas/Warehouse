//--------------------------
// authors:
//         author1:Dimitris Louridas (p3200281)
//         author2:Xristos Giapitzakis(p3200034)
//--------------------------
public class WashingMachines extends HomeDevices {
    private String energyClass;
    private int capacity;
    private int revolutions;

    // Constructor
    public WashingMachines(){
         super("", 0, "", 0, "", 0.0);
    }
    public WashingMachines(String name_model, int stock, String code, int year, String constructor, double price, String energyClass, int capacity, int revolutions) {
        super(name_model, stock, code, year, constructor, price);
        this.energyClass = energyClass;
        this.capacity = capacity;
        this.revolutions = revolutions;
    }

    // Getter for energyClass
    public String getEnergyClass() {
        return energyClass;
    }

    // Setter for energyClass
    public void setEnergyClass(String energyClass) {
        this.energyClass = energyClass;
    }

    // Getter for capacity
    public int getCapacity() {
        return capacity;
    }

    // Setter for capacity
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Getter for revolutions
    public int getRevolutions() {
        return revolutions;
    }

    // Setter for revolutions
    public void setRevolutions(int revolutions) {
        this.revolutions = revolutions;
    }

    // toString method
    @Override
    public String toString() {
        return "Washing Machine:\n" +
                super.toString() +"\n"+
                "Energy Class: " + energyClass + "\n" +
                "Capacity: " + capacity + " kg" + "\n" +
                "Revolutions: " + revolutions + " RPM" + "\n" +
                "--------------------";
    }
}