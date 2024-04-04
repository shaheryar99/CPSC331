/* Shaheryar Syed
 * TA: Harnoor K.
 * UCID: 30052162
 * Question 2 - HashTable 
 */

public class Student {
    int id;
    String studentName;

    public Student (int id, String studentName) {
        this.id = id;
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return this.id + ":" + this.studentName;
    }
}
