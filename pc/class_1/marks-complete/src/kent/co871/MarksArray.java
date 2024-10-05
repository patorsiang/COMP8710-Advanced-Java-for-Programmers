package kent.co871;

import java.util.Arrays;

public class MarksArray {

    /** Name of the module */
    private final String moduleName;
    /** Year of delivery */
    private final int year;

    //A collection to hold the students
    private final String[] students;
    //A collection to hold marks
    private final int[] marks;

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
        this.students = new String[numStudents];
        this.marks = new int[numStudents];
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
        if (number >= this.students.length) return false;
        this.students[number] = name;
        return true;
    }

    /**
     * Get a student's name
     * @param number student number
     * @return the name
     */
    public String getStudent(int number) {
        if (number >= this.students.length || number < 0) return null;
        return this.students[number];
    }

    /**
     * Set a student's mark
     * @param number student number
     * @param mark the mark
     * @return whether the mark was added
     */
    public boolean setMark(int number, int mark) {
        if (number >= this.marks.length || number < 0) return false;
        this.marks[number] = mark;
        return false;
    }

    /**
     * Get a student's mark
     * @param number student number
     * @return the mark
     */
    public int getMark(int number) {
        if (number >= this.marks.length || number < 0) return -1;
        return this.marks[number];
    }

    /**
     * Get a student's mark
     * @param name student name
     * @return the mark for this student
     */
    public int getMark(String name) {
        return this.marks[Arrays.asList(this.students).indexOf(name)];
    }

    public void list() {
        System.out.println("\nSTUDENTS\tMARKS");
        for (var student : this.students) {
            if (student == null) continue;
            else System.out.println("\n" + student + "\t" + this.getMark(student));
        }
    }


    /**
     * A student asked for this method
     * @return all the marks
     */
    public int[] allMarks() {
        return marks.clone();
    }

    /**
     * A student asked for this method
     * @return
     */
    public String[] allStudents() {
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
        //Check that we have what we want
        marks.list();
        System.out.println("Average =" + average);
    }
}
