package database;

import java.util.HashMap;


public class Student extends Person {
    private int grade;
    private int totalTutionCost; //Shows the total Tution cost student is enrolled in i.e. The amount they have to pay
                                // for all of their courses
    private int tuitionPaid; // The amount a student has paid so far
    private int tuitionRemaining;
    private HashMap<String,Integer> courses;

    // A student's ID always starts with 'S' to signify this is a student
    public Student(String firstName, String lastName, String id, int grade){
        super(firstName,lastName,id);
        this.grade = grade;
        this.totalTutionCost=0;
        this.tuitionPaid=0;
        this.tuitionRemaining=0;
        this.courses = new HashMap<>();
    }
    public void payTuition(int amount){
           if(!(amount > tuitionRemaining) ){
               tuitionRemaining = totalTutionCost - amount;
               tuitionPaid += amount;
               School.receieveTuition(amount);

           }else{
               System.out.println("\t\tAmount exceeds Student's total tuition cost! Enter lower amount");

           }
    }
    public int getGrade(){
        return this.grade;
    }

    public void enroll(String course, int price){
        if(!(courses.containsKey(course))){
            courses.put(course,price);
            totalTutionCost += price;
            tuitionRemaining = totalTutionCost;
        }

    }
    public void showEnrolledCourses(){
        if(courses.isEmpty()){
            System.out.println("\t\t This student is currently not enrolled in any course");
        }else{
            courses.forEach((key,value) ->{
                System.out.println("\t\t\t\t" +key);
            });
        }

    }

    public void showInfo(){
        System.out.println("\t\t" + toString());
        System.out.println("\t\tTotal Tuition Cost: $" + totalTutionCost);
        System.out.println("\t\tTuiton amount paid as of now: $" + tuitionPaid);
        System.out.println("\t\tTuition remaining to be paid: $" + tuitionRemaining);
        System.out.println("\t\tCourses Enrolled in: ");
        showEnrolledCourses();
    }




    @Override
    public String toString(){
        return super.toString() + "Grade: " + this.grade;
    }

}
