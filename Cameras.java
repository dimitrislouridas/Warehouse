//--------------------------
// authors:
//         author1:Dimitris Louridas (p3200281)
//         author2:Xristos Giapitzakis(p3200034)
//--------------------------

public class Cameras extends ImageAndSoundDevice {
    public static final String TYPE_COMPACT = "Compact";
    public static final String TYPE_DSLR = "DSLR";
    public static final String TYPE_ACTION_CAMERA = "Action Camera";

    // Variables
    private String type;
    private String size;
    private double opticalZoom;
    private double digitalZoom;
    private int megapixels;

    // Constructor
    public Cameras(){
         super("", 0, "", 0, "", 0.0);
    }
    
    public Cameras(String name_model, int stock, String code, int year, String constructor, double price, String type, String size, double opticalZoom, double digitalZoom, int megapixels) {
        super(name_model, stock, code, year, constructor, price);
        this.digitalZoom = digitalZoom;
        this.opticalZoom = opticalZoom;
        this.size = size;
        this.megapixels = megapixels;
        validateType(type);
        this.type = type;
    }
   public void setType(String type){
    this.type=type;
    validateType(type);
   }
    // Getter for type
    public String getType() {
        return type;
    }

    // Setter for size
    public void setSize(String size) {
        this.size = size;
    }

    // Getter for size
    public String getSize() {
        return size;
    }

    // Setter for opticalZoom
    public void setOpticalZoom(double opticalZoom) {
        this.opticalZoom = opticalZoom;
    }

    // Getter for opticalZoom
    public double getOpticalZoom() {
        return opticalZoom;
    }

    // Setter for digitalZoom
    public void setDigitalZoom(double digitalZoom) {
        this.digitalZoom = digitalZoom;
    }

    // Getter for digitalZoom
    public double getDigitalZoom() {
        return digitalZoom;
    }

    // Setter for megapixels
    public void setMegapixels(int megapixels) {
        this.megapixels = megapixels;
    }

    // Getter for megapixels
    public int getMegapixels() {
        return megapixels;
    }

    // Validate the type value
    private void validateType(String type) {
        if (!type.equals(TYPE_COMPACT) && !type.equals(TYPE_DSLR) && !type.equals(TYPE_ACTION_CAMERA)) {
            throw new IllegalArgumentException("Invalid camera type");
        }
    }

    // toString method
    @Override
    public String toString() {
        return "Camera:\n" +
                super.toString() +"\n"+
                "Type: " + type + "\n" +
                "Size: " + size + "\n" +
                "Optical Zoom: " + opticalZoom + "\n" +
                "Digital Zoom: " + digitalZoom + "\n" +
                "Megapixels: " + megapixels + "\n" +
                "--------------------";
    }
}