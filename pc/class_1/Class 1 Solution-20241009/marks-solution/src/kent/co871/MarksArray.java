package kent.co871;

public class MarksArray {

    /** Name of the module */
    private String moduleName;
    /** Year of delivery */
    private int year;

    //A collection to hold the students
    private String students[];
    //A collection to hold marks
    private int marks[];

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
        this.marks = new int[numStudents];
        this.students = new String[numStudents];
    }

    /**
     * Create new module with default year and number of students
     * @param moduleName name of the module
     */
    public MarksArray(String moduleName) {
        this(moduleName, DEFAULT_YEAR, DEFAULT_CLASS);
    }

    /**
     * Add a student with a number
     * @param name the student's name
     * @param number the student's number
     * @return whether the student was added
     */
    public boolean addStudent(String name, int number) {
        if ((number < 0) || (number >= students.length)) {
            return false;
        }
        // Check if there is already a student in that position
        if (students[number] != null) {
            return false;
        }
        students[number] = name;
        return true;
    }

    /**
     * Get a student's name
     * @param number student number
     * @return the name
     */
    public String getStudent(int number) {
        if ((number < 0) || (number >= students.length)) {
            return null;
        }
        // If there is no student there, it will just return null
        return students[number];
    }

    /**
     * Set a student's mark
     * @param number student number
     * @param mark the mark
     * @return whether the mark was added
     */
    public boolean setMark(int number, int mark) {
        if ((number < 0) || (number >= marks.length)) {
            return false;
        }
        // Ensure we have a student on that position
        if (students[number] == null) {
            return false;
        }
        marks[number] = mark;
        return true;
    }

    /**
     * Get a student's mark
     * @param number student number
     * @return the mark
     */
    public int getMark(int number) {
        if ((number < 0) || (number >= marks.length)) {
            return -1;
        }
        // Ensure we have a student on that position
        if (students[number] == null) {
            return -1;
        }
        return marks[number];
    }

    /**
     * Get a student's mark
     * @param name student name
     * @return the mark for this student
     */
    public int getMark(String name) {
        // Inefficient with arrays
        for (int i =0; i < students.length; i++) {
            if (students[i].equals(name)) {
                return marks[i];
            }
        }
        // No match found
        return -1;
    }

    public void list() {
        System.out.println("\nMODULE: " + moduleName + " (" + year+")");
        System.out.println("STUDENTS\tMARKS");
        for (int i = 0; i < students.length; i++) {
            String student = getStudent(i);
            int mark = getMark(i);
            if (student == null)
                continue;
            System.out.println(student+"\t"+mark);
        }
    }


    /**
     * A student asked for this method
     * @return all the marks
     */
    public int[] allMarks() {
        // Return a clone of the marks array to protect our data
        return marks.clone();
    }

    /**
     * A student asked for this method
     * @return
     */
    public String[] allStudents() {
        // Return a clone of the array to protect our data
        return students.clone();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Set up some students and random marks
        MarksArray marks = new MarksArray("CO871");
        for (int i = 0; i < DEFAULT_CLASS; i++) {
            marks.addStudent("Student_"+i, i);
            marks.setMark(i, (int) Math.round(Math.random()*10));
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
