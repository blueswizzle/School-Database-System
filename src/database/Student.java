package database;

import java.util.HashMap;

public class Student extends Person {
    private int grade;
    private int totalTutionCost; //Shows the total Tution cost student is enrolled in i.e. The amount they have to pay
                                // for all of their courses
    private int tuitionPaid; // The amount a student has paid so far
    private HashMap<String,Integer> courses;

    // A student's ID always starts with 'S' to signify this is a student
    public Student(String firstName, String lastName, String id, int grade){
        super(firstName,lastName,id);
        this.grade = grade;
        this.totalTutionCost=0;
        this.tuitionPaid=0;
        this.courses = new HashMap<>();
    }
    public void payTuition(int amount){
        totalTutionCost -= amount;
        tuitionPaid += amount;
        School.receieveTuition(amount);
    }
    public int getGrade(){
        return this.grade;
    }

    public void enroll(String course, int price){
        courses.put(course,price);
    }
    public void showEnrolledCourses(){
        courses.forEach((key,value) ->{
            System.out.println(key + ":$" + value);
        });
    }
    public String getID(){
        return this.id;
    }




    @Override
    public String toString(){
        return super.toString() + "Grade: " + this.grade;
    }

}
