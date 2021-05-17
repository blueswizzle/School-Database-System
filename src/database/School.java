package database;

import java.util.ArrayList;


public class School {
    ArrayList<Teacher> teachers;
    ArrayList<Student> students;

    private String schoolName;
    private static int totalMoneyEarned; //Just the money earned from Students
    private static int totalMoneySpent; //Just the money spent for Teachers
    private static int totalAmount; //A school's total amount of money, including what they earned and spent i.e.
                                    // their balance


    public School(String schoolName){
        this.schoolName = schoolName;
        this.totalAmount = 0;
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        totalMoneyEarned =0;
        totalMoneySpent =0;
    }
    public void addTeacher(Teacher t){
        this.teachers.add(t);
    }
    public void addStudent(Student s){
        this.students.add(s);
    }
    public String getSchoolName(){
        return this.schoolName;
    }
    public void listTeachers(){
        System.out.println("Teachers in " + getSchoolName());
        System.out.println("--------------------------------");
        for(Teacher t : teachers){
            System.out.println(t);
        }
        System.out.println("--------------------------------");
    }
    public void listStudents(){
        System.out.println("Students in " + getSchoolName());
        System.out.println("--------------------------------");
        for(Student s : students){
            System.out.println(s);
        }
        System.out.println("--------------------------------");
    }
    public void listStudentsByGrade(int grade) {
        System.out.println("Listing Students in grade " + grade);
        System.out.println("--------------------------------");
        for (Student s : students) {
            if (s.getGrade() == grade) {
                System.out.println(s);
            }else{
                System.out.println("No students in that grade level");
                break;
            }

        }
        System.out.println("--------------------------------");

    }
    public static void receieveTuition(int amount){ //Used when a Student pays their tuition and money is sent to
                                                    // the school
        totalMoneyEarned += amount;
        totalAmount += amount;
    }
    public void paySalary(Teacher t){
        totalMoneySpent += t.getSalary();
        totalAmount -= t.getSalary();
    }
    public void showFinanceHistory(){
        System.out.println(getSchoolName() + " has paid a total of $" + totalMoneySpent + " to the teachers");
        System.out.println(getSchoolName() + " has received a total of $" + totalMoneyEarned + " from the Students");
        System.out.println(getSchoolName() + "'s Total Balance: $" + totalAmount);
    }

}
