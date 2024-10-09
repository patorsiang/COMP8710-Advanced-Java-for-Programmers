import java.util.HashMap;
import java.util.Map;

public class MarksArray {

    /** Name of the module */
    private String moduleName;
    /** Year of delivery */
    private int year;

    //A collection to hold the students / marks
    private HashMap<String,Integer> studentMarks;


    // Default constants
    private static final int DEFAULT_YEAR = 2010; // Better to ask system
    private static final int DEFAULT_CLASS = 16;

    /**
     * Create new module
     * @param moduleName name of the module
     * @param year year of delivery
     * @param numStudents number of students
     */
    public MarksArray(String moduleName, int year, int numStudents) {
        this.moduleName = moduleName;
        this.year = year;
        this.studentMarks = new HashMap<String,Integer>(numStudents);
    }

    /**
     * Create new module with default year and number of students
     * @param moduleName name of the module
     */
    public MarksArray(String moduleName) {
        this(moduleName, DEFAULT_YEAR, DEFAULT_CLASS);
    }


    /**
     * Set a student's mark
     * @param name the student's name
     * @param mark the mark
     * @return whether the mark was added
     */
    public boolean setMark(String name, int mark) {
        // If there is already a mark don't allow a new mark
        if (studentMarks.containsKey(name))
            return false;
        studentMarks.put(name, mark);
        return true;
    }

    /**
     * Get a student's mark
     * @param name student name
     * @return the mark for this student
     */
    public int getMark(String name) {
        Integer value = studentMarks.get(name);
        // Check if we have the student in the dataset
        if (value == null) {
            return -1;
        }
        return value;
    }

    /**
     * Prints a list of the students and their marks
     */
    public void list() {
        System.out.println("\nMODULE: " + moduleName + " (" + year+")");
        System.out.println("STUDENTS\tMARKS");
        for (Map.Entry<String,Integer> e : studentMarks.entrySet()) {
            System.out.println(e.getKey()+"\t"+e.getValue());
        }
    }


    /**
     * A student asked for this method
     * @return all the marks
     */
    public int[] allMarks() {
        // We need to generate an int[] although we are working with Integers.
        // Traditional way
        int[] out = new int[studentMarks.size()];
        int i =0;
        for (Integer v : studentMarks.values()) {
            out[i] = v;
            i++;
        }
        //return out;

        // Java 8
        // There is more efficient way of generating an int[] using streams.
        int[] output = studentMarks.values().stream().mapToInt(Integer::intValue).toArray();

        return output;
    }

    /**
     * A student asked for this method
     * @return
     */
    public String[] allStudents() {
        // Return a clone of the array
        return studentMarks.keySet().toArray(new String[studentMarks.size()]);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Set up some students and random marks
        MarksArray marks = new MarksArray("CO871");
        for (int i = 0; i < DEFAULT_CLASS; i++) {
            marks.setMark("Student_"+i, (int) Math.round(Math.random()*10));
        }

        // Check that we have what we want
        marks.list();

        // Add statistics code here
        float average = new Adversary().analyse(marks);
        // Check that we have what we want
        marks.list();
        System.out.println("Average = " + average);

    }
}
