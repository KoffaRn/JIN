import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Student extends Person {
    private int classroom;
    private HashMap<String,Character> gradeList;

    public Student(String name, int age, int classroom) {
        this.gradeList = new HashMap<String, Character>();
        this.setName(name);
        this.setAge(age);
        this.setClassroom(classroom);
    }

    void setClassroom(int classroom) {
        this.classroom = classroom;
    }
    int getClassroom() {
        return classroom;
    }
    void gradePerformance(String course, char grade) {
        gradeList.put(course, grade);
    }
    HashMap<String, Character> getGradeList() {
        return gradeList;
    }
    @Override
    public String toString() {
        String str = "Student: ";
        str += "Name: " + this.getName() + ", " +
                "Age: " + this.getAge() + ", " +
                "Classroom: " + this.getClassroom() + ", " +
                "Grade list: " + this.getGradeList().toString() + ".";
        return str;
    }
}
