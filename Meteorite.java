import com.google.gson.Gson;
import com.google.gson.JsonArray;

/**
 * Meteorite class represents a meteorite with various attributes.
 * Implelments java.io.Serializable to allow the serialization of meteorite objects.
 */


public class Meteorite implements java.io.Serializable {
    private String name;
    private String id;
    private String nametype;
    private String recclass;
    private String mass;
    private String fall;
    private String year;
    private String reclat;
    private String reclong;
    private Geolocation geolocation;

    /**
     * Creates a new Meteorite object with the specified attributes.
     * @param name the name of the meteorite
     * @param id the ID of the meteorite
     * @param nametype the name type of the meteorite
     * @param recclass the classification of the meteorite
     * @param mass the mass of the meteorite
     * @param fall the fall status of the meteorite
     * @param year the year the meteorite was found
     * @param reclat the latitude where the meteorite was found
     * @param reclong the longitude where the meteorite was found
     * @param geolocation the geolocation of the meteorite
     */
    public Meteorite(String name, String id, String nametype, String recclass, String mass, String fall, String year, String reclat, String reclong, Geolocation geolocation) {
        this.name = name;
        this.id = id;
        this.nametype = nametype;
        this.recclass = recclass;
        this.mass = mass;
        this.fall = fall;
        this.year = year;
        this.reclat = reclat;
        this.reclong = reclong;
        this.geolocation = geolocation;
    }

    /**
     * Returns the name of the meteorite.
     * @return the name of the meteorite
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the ID of the meteorite
     * @return the ID of the meteorite
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the name type of the meteorite.
     * @return the name type of the meteorite
     */
    public String getNametype() {
        return nametype;
    }

    /**
     * Returns the classification of the meteorite.
     * @return the classification of the meteorite
     */
    public String getRecclass() {
        return recclass;
    }

    /**
     * Returns the mass of the meteorite.
     * @return the mass of the meteorite
     */
    public String getMass() {
        return mass;
    }

    /**
     * Returns the fall status of the meteorite.
     * @return the fall status of the meteorite
     */
    public String getFall() {
        return fall;
    }

    /**
     * Returns the year the meteorite was found.
     * @return the year the meteorite was found
     */
    public Integer getYear() {
        if (year == null || year.isEmpty()) {
            return 0; // Sets the year to 0 if it's null or empty
        }
        try {
            return Integer.parseInt(year.substring(0,4));  // Displays just the year
        } catch (Exception e) {
            return 0;
        }

    }

    /**
     * Returns the latitude where the meteorite was found.
     * @return the latitude where the meteorite was found
     */
    public String getReclat() {
        return reclat;
    }

    /**
     * Returns the longitude where the meteorite was found.
     * @return the longitude where the meteorite was found
     */
    public String getReclong() {
        return reclong;
    }

    /**
     * Returns the geolocation of the meteorite.
     * @return the geolocation of the meteorite
     */
    public Geolocation getGeolocation() {
        return geolocation;
    }

    /**
     * Returns a string representation of the meteorite.
     * @return a string representation of the meteorite
     */
    @Override
    public String toString() {
        return "Meteorite{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", nametype='" + nametype + '\'' +
                ", recclass='" + recclass + '\'' +
                ", mass='" + mass + '\'' +
                ", fall='" + fall + '\'' +
                ", year='" + year + '\'' +
                ", reclat='" + reclat + '\'' +
                ", reclong='" + reclong + '\'' +
                ", geolocation=" + geolocation +
                '}';
    }

    /**
     * Returns a sipmple string representation of the meteorite for display purposes.
     * @return a string representation of the meteorite
     */
    public String display(){
        return "name = " + name + ", id = " + id + ", recclass = " + recclass + ", mass = " + mass + ", year = " + getYear();
    }

}   