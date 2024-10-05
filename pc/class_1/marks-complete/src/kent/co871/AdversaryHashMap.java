package kent.co871;

/**
 * Adversarial program, modified for running with HashMap
 * @author napatchol thaipanich
 */
public class AdversaryHashMap {

    public float analyse(StudentMarksHashMap module){
        String[] students = module.allStudents();
        Integer[] marks = module.allMarks();
        students[0] = "A. Rascal";
        marks[0] = 10;
        int sum = 0;
        int count = 0;
        for (int m : marks) {
            sum += m;
            count++;
        }
        return sum / count;
    }
}
