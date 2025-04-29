//--------------------------
// authors:
//         author1:Dimitris Louridas (p3200281)
//         author2:Xristos Giapitzakis(p3200034)
//--------------------------

public class Televisions extends ImageAndSoundDevice {
    // static variables
    public static final String TYPE_LCD = "LCD";
    public static final String TYPE_LED = "LED";
    public static final String TYPE_PLASMA = "Plasma";

    public static final String PORT_HDMI = "HDMI";
    public static final String PORT_DVI = "DVI";
    public static final String PORT_COMPOSITE = "Composite";

    // variables
    private String type;
    private int dimension;
    private String analysis;
    private String ports;

    // Constructor
    public Televisions(){
         super("", 0, "", 0, "", 0.0);
    }
       
       public Televisions(String name_model, int stock, String code, int year, String constructor, double price,
                       String type, int dimension, String analysis, String ports) {
        super(name_model, stock, code, year, constructor, price);
        validateType(type);
        validatePorts(ports);
        this.type = type;
        this.dimension = dimension;
        this.analysis = analysis;
        this.ports = ports;
    }

    // Setters/getters
    public void setType(String type) {
        validateType(type);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getDimension() {
        return dimension;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setPorts(String ports) {
        validatePorts(ports);
        this.ports = ports;
    }

    public String getPorts() {
        return ports;
    }

    // Validate the type value
    private void validateType(String type) {
        if (!type.equals(TYPE_LCD) && !type.equals(TYPE_LED) && !type.equals(TYPE_PLASMA)) {
            throw new IllegalArgumentException("Invalid TV type");
        }
    }

    // Validate the ports value
    private void validatePorts(String ports) {
        if (!ports.equals(PORT_HDMI) && !ports.equals(PORT_DVI) && !ports.equals(PORT_COMPOSITE)) {
            throw new IllegalArgumentException("Invalid TV ports");
        }
    }

    // toString method
    @Override
    public String toString() {
        return "Television:\n" +
                super.toString() + "\n" +
                "Type: " + type + "\n" +
                "Dimension: " + dimension + "\n" +
                "Analysis: " + analysis + " pixels" + "\n" +
                "Ports: " + ports + "\n" +
                "--------------------";
    }
}