import com.google.gson.Gson;
import com.google.gson.JsonArray;
import java.util.List;


/** 
 * Represents the geolocation of a meteorite.
 * Implements the java.io.Serializable interface.
 */
public class Geolocation implements java.io.Serializable {
    private String type;
    private List<Double> coordinates;


    /**
     * Constructs a new Geolocation object with the specified coordinates.
     * @param coordinates the coordinates of the geolocation
     */
    public Geolocation(List<Double> coordinates) {
        this.type = "Point";
        this.coordinates = coordinates;
    }

    /**
     * Returns the type of the geolocation.
     * @return the type of the geolocation
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the coordinates of the geolocation.
     * @return the coordinates of the geolocation
     */
    public List<Double> getCoordinates() {
        return coordinates;
    }

}
    


