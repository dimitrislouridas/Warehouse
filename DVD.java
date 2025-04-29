//--------------------------
// authors:
//         author1:Dimitris Louridas (p3200281)
//         author2:Xristos Giapitzakis(p3200034)
//--------------------------

public class DVD extends ImageAndSoundDevice {
    public static final String TYPE_BLU_RAY = "Blu-ray";
    public static final String TYPE_DVD = "DVD";
    public static final String FORMAT_BD_R = "BD-R";
    public static final String FORMAT_BDRD = "BDRD";
    public static final String FORMAT_DVD_RW = "DVD-RW";
    public static final String FORMAT_DVD_PLUS_RW = "DVD+RW";

    // Variables
    private String type;
    private String analysis;
    private String reproductionFormat;

    // Constructor
    public DVD(){
         super("", 0, "", 0, "", 0.0);
    }
   
    public DVD(String name_model, int stock, String code, int year, String constructor, double price, String type, String analysis, String reproductionFormat) {
        super(name_model, stock, code, year, constructor, price);
        validateType(type);
        this.type = type;
        this.analysis = analysis;
        validateReproductionFormat(reproductionFormat);
        this.reproductionFormat = reproductionFormat;
    }

    // Getter for type
    public String getType() {
        return type;
    }

    // Setter for type
    public void setType(String type) {
        this.type = type;
        validateType(type);
    }

    // Getter for analysis
    public String getAnalysis() {
        return analysis;
    }

    // Setter for analysis
    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    // Getter for reproductionFormat
    public String getReproductionFormat() {
        return reproductionFormat;
    }

    // Setter for reproductionFormat
    public void setReproductionFormat(String reproductionFormat) {
        this.reproductionFormat = reproductionFormat;
        validateReproductionFormat(reproductionFormat);
    }

    // Validate the type value
    private void validateType(String type) {
        if (!type.equals(TYPE_BLU_RAY) && !type.equals(TYPE_DVD)) {
            throw new IllegalArgumentException("Invalid DVD type");
        }
    }

    // Validate the reproductionFormat value
    private void validateReproductionFormat(String reproductionFormat) {
        if (!reproductionFormat.equals(FORMAT_BD_R) && !reproductionFormat.equals(FORMAT_BDRD)
                && !reproductionFormat.equals(FORMAT_DVD_RW) && !reproductionFormat.equals(FORMAT_DVD_PLUS_RW)) {
            throw new IllegalArgumentException("Invalid DVD reproduction format");
        }
    }

    // toString method
    @Override
    public String toString() {
        return "DVD/Blu-ray:\n" +
                super.toString() +"\n"+
                "Type: " + type + "\n" +
                "Analysis: " + analysis + " pixels" + "\n" +
                "Reproduction Format: " + reproductionFormat + "\n" +
                "--------------------";
    }
}