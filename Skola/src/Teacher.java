import java.util.ArrayList;

public class Teacher extends Person {
    private double salary;
    private ArrayList<String> coursesTaught;

    public Teacher(String name, int age, double salary) {
        this.coursesTaught = new ArrayList<String>();
        this.setName(name);
        this.setAge(age);
        this.setSalary(salary);
    }
    public Teacher(String name, int age, double salary, ArrayList<String> coursesTaught) {
        this.setName(name);
        this.setAge(age);
        this.setSalary(salary);
        this.setCoursesTaught(coursesTaught);
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    ArrayList<String> getCoursesTaught() {
        return coursesTaught;
    }
    void addCoursesTaught(String course) {
        this.coursesTaught.add(course);
    }
    void setCoursesTaught(ArrayList<String> coursesTaught) {
        this.coursesTaught.addAll(coursesTaught);
    }
    public void gradeStudent(Student student, String course, char grade) {
        student.gradePerformance(course, grade);
    }
    @Override
    public String toString() {
        String str = "Teacher: ";
        str += "Name: " + this.getName() + ", " +
                "Age " + this.getAge() + ", " +
                "Salary: " + this.getSalary() + ", " +
                "Courses: " + this.getCoursesTaught().toString();
        return str;
    }
}
