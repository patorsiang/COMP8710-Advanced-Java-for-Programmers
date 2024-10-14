import javax.xml.crypto.Data;

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
        System.out.println("= part 4 ===================");

        // Part 4
        CD myCD = new CD("Sultans of Swing", "Dire Straights", 12, 60);

        myCD.print();

        System.out.println("= part 5 ===================");
        // Part 5
        Database myDB = new Database();

        myDB.addItem(myCD);
        myDB.list();

        System.out.println("= part 6 ===================");

        // Part 6
        DVD myDVD = new DVD("Dune", "David Lynch", 137);
        System.out.println(myDVD);
    }
}
