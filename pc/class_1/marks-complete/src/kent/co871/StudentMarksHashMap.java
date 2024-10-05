package kent.co871;

import java.util.*;

public class StudentMarksHashMap {

    // A collection to hold a map student with mark
    private final HashMap<String, Integer> studentMarks;

    // Default constants
    private static final int DEFAULT_CLASS = 16;

    /**
     * Setting new student and mark group
     */
    public StudentMarksHashMap() {
        this.studentMarks = new HashMap<>();
    }

    /**
     * Add a student by name with mark
     * @param name the student's name
     * @param mark the student's mark
     */
    public void addStudentMark (String name, Integer mark) {
        studentMarks.put(name, mark);
    }

    /**
     * Get Mark by student's name
     * @param name student's name
     * @return mark
     */
    public Integer getStudentMark (String name) {
        return studentMarks.get(name);
    }

    public void list() {
        System.out.println("\nSTUDENTS\tMARKS");

        var student = allStudents();

        Arrays.sort(student, (s1, s2) -> {
            int num1 = Integer.parseInt(s1.split("_")[1]);
            int num2 = Integer.parseInt(s2.split("_")[1]);
            return Integer.compare(num1, num2);
        });

        for (String name : student) {
            System.out.println("\n" + name + "\t" + getStudentMark(name));
        }
    }

    /**
     * A student asked for this method
     * @return all the marks of student
     */
    public Integer[] allMarks() {
        return studentMarks.values().toArray(new Integer[studentMarks.size()]);
    }

    /**
     * A student asked for this method
     * @return all the students' name
     */
    public String[] allStudents() {
        return  studentMarks.keySet().toArray(new String[studentMarks.size()]);
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentMarksHashMap studentMarksHashMap = new StudentMarksHashMap();

        for (int i = 0; i < DEFAULT_CLASS; i++) {
            studentMarksHashMap.addStudentMark("Student_" + i, (int) Math.round(Math.random()*10));
        }

        studentMarksHashMap.list();

        float average = new AdversaryHashMap().analyse(studentMarksHashMap);
        //Check that we have what we want
        studentMarksHashMap.list();
        System.out.println("Average =" + average);
    }

}
