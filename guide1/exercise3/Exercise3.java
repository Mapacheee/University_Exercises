public class Exercise3 {

    public static void main(String[] args) {

    }
}

class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }

}

class Class {
    private String nameCourse;

    public Class() {}

    public String getCourseName() { return nameCourse; }
}