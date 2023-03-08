import java.util.ArrayList;

public class Parent extends Person {
    private ArrayList<Student> children;

    public Parent(String name, int age, Student child) {
        children = new ArrayList<Student>();
        this.setAge(age);
        this.setName(name);
        this.children.add(child);
        child.addParent(this);
    }
    void addChildren(Student student) {
        children.add(student);
    }
    ArrayList<Student> getChildren() {
        return this.children;
    }
    void helpWithHomeWork() {

    }
    @Override
    public String toString() {
        String str = "Parent: ";
        str += "Name: " + this.getName() + ", " +
                "Age " + this.getAge() + ".";
        return str;
    }
}
