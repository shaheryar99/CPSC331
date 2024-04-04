/* Shaheryar Syed
 * TA: Harnoor K.
 * UCID: 30052162
 * Question 2 - HashTable 
 * REF - TA Tutorial Code: https://d2l.ucalgary.ca/d2l/le/content/569171/Home?itemIdentifier=D2L.LE.Content.ContentObject.ModuleCO-6296990
 */

import java.util.LinkedList;

public class StudentDB {
    public final int LEN = 8;
    public LinkedList<Student>[] mainTable;

    @SuppressWarnings("unchecked")
    public StudentDB() {
        mainTable = new LinkedList[LEN];

        for (int i = 0; i < LEN; i++) {
            mainTable[i] = new LinkedList<>();
        }
    }

    public int hashvalue(int studentID) {
        return studentID % LEN;
    }

    public boolean search (int studentID) {
        int studentIndex = hashvalue(studentID);
        for (Student studentInfo : mainTable[studentIndex]) {
            if (studentInfo.id == studentID) {
                return true;
            }
        }
        return false;
    }

    public String retrieve (int studentID) {
        int studentIndex = hashvalue(studentID);
        for (Student studentInfo : mainTable[studentIndex]) {
            if (studentInfo.id == studentID) {
                return studentInfo.studentName;
            }
        }

        return "No student with ID: " + studentID + " found.";
    }

    public void insert (int studentID, String studentName) {
        int studentIndex = hashvalue(studentID);
        boolean studentExists = false;

        for (Student studentInfo : mainTable[studentIndex]) {
            if (studentInfo.id == studentID) {
                studentInfo.studentName = studentName;
                studentExists = true;
                break;
            }
        }
        if (!studentExists) {
            mainTable[studentIndex].add(new Student (studentID, studentName));
        }
    }

    public String delete (int studentID) {
        int studentIndex = hashvalue(studentID);
        for (Student studentInfo : mainTable[studentIndex]) {
            if (studentInfo.id == studentID) {
                mainTable[studentIndex].remove(studentInfo);
                return null;
            }
        }

        return "No student with ID: " + studentID + " found.";
    }

    @Override
    public String toString() {
        String formatter = "";

        for (int i = 0; i < LEN; i++) {
            formatter += i + ": [";

            if (!mainTable[i].isEmpty()) {

                for (Student studentInfo : mainTable[i]) {
                    formatter += studentInfo.toString() + ", ";

                }
                formatter = formatter.substring(0, formatter.length() - 2);
            }
            formatter += "]\n";
        }

        return formatter;
    }

}
