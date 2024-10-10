/**
 * The Main class is the main entry for the program.
 *
 * @author Christos Efstratiou
 * @version 2020.10.4
 */
public class Main {
    /**
     * Entry point for the application.
     * @param args Command line options are ignored
     */
    public static void main(String[] args) {
        Database db = new Database();

        // Create some items
        Item item = new Item("Generic Item",10);

        CD cd = new CD("Evolve","Imagine Dragon", 3, 100);
        cd.print();

        DVD dvd = new DVD("Harry Potter and the Philosopher's Stone", "Chris Columbus", 10);
        String version = dvd.toString();
        System.out.println(version);

        // Add items to the database
        db.addItem(item);
        db.addItem(cd);
        db.addItem(dvd);

        // List the items in the database
        db.list();
    }
}
