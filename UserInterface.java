import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * The UserInterface class displays a menu and prompts the user for input.
 */


public class UserInterface {

    /**
     * The JsonLoader instance used to load and manage meteorite data.
     */
    private JsonLoader jsonLoader = new JsonLoader();
    
    private Scanner scnr = new Scanner(System.in);
    private int userChoice;

   
    public void go() {


        // Display the main menu and gets users input
        while (true){
        System.out.println("Welcome to the NASA Meteorite tracking database.\n");
        System.out.println("Here's the menu of choices - ");
        System.out.println("  0) Exit");
        System.out.println("  1) Import meteorite data");//
        System.out.println("  2) Display the meteorite data");
        System.out.println("  3) Export the meteorite data to a file");
        System.out.println("  4) Find a meteorite by name");
        System.out.println("  5) Find a meteorite by ID");
        System.out.println("  6) List the largest meteorites");
        System.out.println("  7) List the most recent meteorites by year");
        System.out.println("  8) List the meteorite Classes");
        System.out.print("Enter your choice: ");
        userChoice = scnr.nextInt();
        scnr.nextLine(); // Consume the newline character
        
        // Processes the user's choice
         switch (userChoice) {
            case 0: // Exits
                System.out.println("Exiting the program. Goodbye!");
                return;
            case 1: // Impports the meteorite data file
                System.out.println("Enter the JSON file name or press <Enter> to accept the default file (data/NASA_Meteorite.json): ");
                String fileName = scnr.nextLine().trim(); // Reads the file name inputted by user
                if (fileName.isEmpty()) {
                    fileName = "data/NASA_Meteorite.json";  // Defaults to data/NASA_Meteorite.json if no file name is entered
                }

                
                jsonLoader.loadJson(fileName);  // Loads the JSON file
                System.out.println(jsonLoader.getMeteorites().size() + " records processed.\n");
                break;
            case 2:  // Displays the meteorite data
                System.out.println("Meteor data:");
                for (Meteorite meteorite : jsonLoader.getMeteorites()) {
                    System.out.println(meteorite);
                    System.out.print("\n");
                }
                break;
            case 3:  // Exports the meteorite data to a file
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("meteorite_data"))) {
                    oos.writeObject(jsonLoader.getMeteorites()); // 
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Meteorite data exported to meteorite_data\n");
                break;
            case 4:  // Finds a meteorite by name
                System.out.print("Enter the name of the meteorite: ");
                String name = scnr.next();
                Meteorite foundMeteoriteName = jsonLoader.findMeteoriteByName(name);
                if (foundMeteoriteName != null) {
                    System.out.print("\n");
                    System.out.println(foundMeteoriteName.display());
                    System.out.print("\n");
                } else {
                    System.out.print("\n");
                    System.out.println("Meteorite not found.\n");
                }

                break;
            case 5:  // Finds a meteorite by ID
                System.out.print("Enter the ID of the meteorite: ");
                String id = scnr.next();
                Meteorite foundMeteoriteId = jsonLoader.findMeteoriteById(id);
                if (foundMeteoriteId != null) {
                    System.out.print("\n");
                    System.out.println(foundMeteoriteId.display());
                    System.out.print("\n");
                } else {
                    System.out.print("\n");
                    System.out.println("Meteorite not found.\n");
                }
                break;
                
            case 6:  // Lists the largest meteorites
                System.out.print("How many of the largest meteorites do you want to see? ");
                int countLarge = scnr.nextInt();
                scnr.nextLine();
                System.out.print("\n");
                System.out.println("Largest " + countLarge + " meteorites:");
                jsonLoader.listLargestMeteorites(countLarge).forEach(m -> System.out.println(m.display()));
                System.out.print("\n");
                break;
            case 7:  // Lists the most recent meteorites
                System.out.print("How many of the most recent meteorites do you want to see? ");
                int countRecent = scnr.nextInt();
                scnr.nextLine();
                System.out.print("\n");
                System.out.println("Most recent " + countRecent + " meteorites:");
                jsonLoader.listMostRecentMeteorites(countRecent).forEach(m -> System.out.println(m.display()));
                System.out.print("\n");
                break;
            case 8:  // Lists the meteorite classes
                System.out.println("Meteorite classes: ");
                System.out.println("Count \tClassification");
                System.out.println("====\t====================");
                jsonLoader.listMeteoriteClasses();
                System.out.print("\n");
                break;
            default:
                System.out.println("Invalid choice. Please enter a number from 0 to 8.\n");
        }
        
    }
}}
