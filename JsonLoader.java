import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.google.gson.Gson;


/**
 * A class for loading meteorite data from a JSON file.
 */
public class JsonLoader {

        private List<Meteorite> meteorites; // List to store the loaded meteorite data

    /**
     * Loads meteorite data from a JSON file.
     * @param fileName the name of the JSON file to load
     * @return a list of loaded meteorite objects
     */
    public List<Meteorite> loadJson(String fileName)  {

        try {
        Gson gson = new Gson(); // Create a new Gson instance 

        String jsonString = Files.readString(Paths.get(fileName)); // Read the JSON file as a string

        Meteorite[] meteoriteArray = gson.fromJson(jsonString, Meteorite[].class);
        List<Meteorite> meteorites = Arrays.asList(meteoriteArray);
        this.meteorites = meteorites;
        return meteorites;
    } catch (IOException e) {
        System.err.println("Error reading JSON file: " );
        return null;
    }
    }

    /**
     * Returns the list of loaded meteorite objects.
     * @return the list of loaded meteorite objects
     */
   public List<Meteorite> getMeteorites() {
        return meteorites;
    }

    /**
     * Finds a meteorite by its name.
     * @param name the name of the meteorite to find
     * @return the found meteorite, or null if not found
     */
    public Meteorite findMeteoriteByName(String name) {
        if (meteorites == null) {
            return null; // No data loaded
        }
        return meteorites.stream()
                .filter(m -> m.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null); // Not found
    }

    /**
     * Finds a meteorite by its ID.
     * @param id the ID of the meteorite to find
     * @return the found meteorite, or null if not found
     */
    public Meteorite findMeteoriteById(String id) {
        if (meteorites == null) {
            return null; // No data loaded
        }
        return meteorites.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null); // Not found
    }

    /**
     * Lists the largest meteorites.
     * @param countLarge the number of largest meteorites to list
     * @return a list of the largest meteorites
     */
    public List<Meteorite> listLargestMeteorites(int countLarge) {
        if (meteorites == null) {
            return null; // No data loaded
        }
        return meteorites.stream()
                .filter(m -> m.getMass() != null)
                .sorted((m1, m2) -> Double.compare(Double.parseDouble(m2.getMass()), Double.parseDouble(m1.getMass()))) // Sort by mass in descending order
                .limit(countLarge)
                .collect(Collectors.toList());
    }

    /**
     * Lists the most recent meteorites.
     * @param countRecent the number of most recent meteorites to list
     * @return a list of the most recent meteorites
     */
    public List<Meteorite> listMostRecentMeteorites(int countRecent) {
        if (meteorites == null) {
            return null; // No data loaded
        }
        return meteorites.stream()
                .sorted((m1, m2) -> m2.getYear().compareTo(m1.getYear()))  // Sort by year in descending order
                .limit(countRecent)
                .collect(Collectors.toList());
    }

    /**
     * Lists the classes of meteorites.
     * @return a list of the meteorite classes
     */
    public void listMeteoriteClasses() {
        if (meteorites == null) {
            return; // No data loaded
        }
        meteorites.stream()
                .filter(m -> m.getRecclass() != null && !m.getRecclass().isEmpty()) // Filter out null or empty recclass values
                .collect(Collectors.groupingBy(Meteorite::getRecclass,
                    Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())) // Sort by count in descending order
                .forEach(e -> System.out.println(e.getValue() + " \t" + e.getKey())); 
        
                
    }

} 