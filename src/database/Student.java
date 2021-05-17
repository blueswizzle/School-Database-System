package database;

public class Student extends Person {
    private int grade;


    public Student(String firstName, String lastName, String id, int grade){
        super(firstName,lastName,id);
        this.grade = grade;
    }
    @Override
    public String toString(){
        return super.toString() + "Grade: " + this.grade;
    }

}
