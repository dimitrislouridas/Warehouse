//--------------------------
// authors:
//         author1:Dimitris Louridas (p3200281)
//         author2:Xristos Giapitzakis(p3200034)
//--------------------------

public class Consoles extends GamingDevices {
    public static final String TYPE_PS5 = "PS5";
    public static final String TYPE_PS4 = "PS4";
    public static final String TYPE_XBOX_SERIES_X = "Xbox Series X";

    private String type;
    private String processor;
    private String graphics;
    private String sound;
    private int harddiskcapacity;

    // Constructor
    public Consoles(){
         super("", 0, "", 0, "", 0.0);
    }    
    public Consoles(String name_model, int stock, String code, int year, String constructor, double price, String type, String processor, String graphics, String sound, int harddiskcapacity) {
        super(name_model, stock, code, year, constructor, price);
        validateType(type);
        this.type = type;
        this.processor = processor;
        this.graphics = graphics;
        this.sound = sound;
        this.harddiskcapacity = harddiskcapacity;
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

    // Getter for processor
    public String getProcessor() {
        return processor;
    }

    // Setter for processor
    public void setProcessor(String processor) {
        this.processor = processor;
    }

    // Getter for graphics
    public String getGraphics() {
        return graphics;
    }

    // Setter for graphics
    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    // Getter for sound
    public String getSound() {
        return sound;
    }

    // Setter for sound
    public void setSound(String sound) {
        this.sound = sound;
    }

    // Getter for harddiskcapacity
    public int getHarddiskcapacity() {
        return harddiskcapacity;
    }

    // Setter for harddiskcapacity
    public void setHarddiskcapacity(int harddiskcapacity) {
        this.harddiskcapacity = harddiskcapacity;
    }

    // Validate the type value
    private void validateType(String type) {
        if (!type.equals(TYPE_PS5) && !type.equals(TYPE_PS4) && !type.equals(TYPE_XBOX_SERIES_X)) {
            throw new IllegalArgumentException("Invalid console type");
        }
    }

    // toString method
    @Override
    public String toString() {
        return "Consoles:\n" +
                super.toString() +"\n"+
                "Type: " + type + "\n" +
                "Processor: " + processor + "\n" +
                "Graphics: " + graphics + "\n" +
                "Sound: " + sound + "\n" +
                "Hard Disk Capacity: " + harddiskcapacity + " GB"+"\n" +
                "--------------------";
    }
}



    

