/**
 * Adversarial program
 * @author rej
 */
public class Adversary {

    public float analyse(MarksArray module){
        String[] students = module.allStudents();
        int[] marks = module.allMarks();
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
