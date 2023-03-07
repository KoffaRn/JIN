import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Student extends Person {
    private int classroom;
    private HashMap<String,Character> gradeList;
    private ArrayList<Parent> parents;

    public Student(String name, int age, int classroom) {
        this.gradeList = new HashMap<String, Character>();
        this.parents = new ArrayList<Parent>();
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
    void addParent(Parent parent) {
        this.parents.add(parent);
    }
    HashMap<String, Character> getGradeList() {
        return gradeList;
    }
    ArrayList<Parent> getParents() {
        return parents;
    }
    @Override
    public String toString() {
        String str = "Student: ";
        str += "Name: " + this.getName() + ", " +
                "Age: " + this.getAge() + ", " +
                "Classroom: " + this.getClassroom() + ", " +
               "Grade list: " + getGradeList() + ".";
               // "Parents: " + getParents() + ".";
        return str;
    }
}
