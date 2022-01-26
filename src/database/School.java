package database;

import java.util.ArrayList;



public class School {
     static ArrayList<Teacher> teachers;
     ArrayList<Student> students;

    private String schoolName;
    private static int totalMoneyEarned; //Just the money earned from Students
    private static int totalMoneySpent; //Just the money spent for Teachers
    private static int totalAmount; //A school's total amount of money, including what they earned and spent i.e.
                                    // their balance


    public School(String schoolName){
        this.schoolName = schoolName;
        this.totalAmount = 3000;
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
        System.out.println("\t\tTeachers in " + getSchoolName());
        System.out.println("\t\t--------------------------------");
        for(Teacher t : teachers){
            System.out.println("\t\t"+ t);
        }
        System.out.println("\t\t--------------------------------");
    }
    public void listStudents(){
        System.out.println("\t\tStudents in " + getSchoolName());
        System.out.println("--------------------------------");
        for(Student s : students){
            System.out.println("\t\t"+ s);
        }
        System.out.println("\t\t--------------------------------");
    }
    public void listStudentsByGrade(int grade) {
        System.out.println("\t\tListing Students in grade " + grade);
        System.out.println("\t\t--------------------------------");
        int i=0;
        for (Student s : students) {
            if (s.getGrade() == grade) {
                System.out.println("\t\t" +s);
                i++;
            }
        }
        if(i == 0){
            System.out.println("\tNo students in that grade");
        }
        System.out.println("\t\t--------------------------------");

    }
    public static void receieveTuition(int amount){ //Used when a Student pays their tuition and money is sent to
                                                    // the school
        totalMoneyEarned += amount;
        totalAmount += amount;
    }
    public static void paySalary(Teacher t){
            totalMoneySpent += t.getSalary();
            totalAmount -= t.getSalary();
    }
    public static int getBalance(){
        return totalAmount;
    }

    public void showFinanceHistory(){
        System.out.println("\t\t--------------------------------");
        System.out.println("\t\t"+ getSchoolName() + " has paid a total of $" + totalMoneySpent + " to the teachers");
        System.out.println("\t\t"+getSchoolName() + " has received a total of $" + totalMoneyEarned + " from the Students");
        System.out.println("\t\t"+getSchoolName() + "'s Total Balance: $" + totalAmount);
        System.out.println("\t\t--------------------------------");
    }
    public boolean studentExist(String student){
        for(Student s: students){
            if(s.getFirstName().equalsIgnoreCase(student)|| s.getLastName().equalsIgnoreCase(student)){
                return true;
            }
        }
        return false;

    }
    public String getStudentName(String student){               //Returns a student full name as a String
        for(Student s : students){
            if(s.getFirstName().equalsIgnoreCase(student)|| s.getLastName().equalsIgnoreCase(student)){
                return s.getFirstName() +" " + s.getLastName();
            }
        }
        return "Student doesn't exist";
    }
    public Student getStudent(String student){          // Returns Student object
        for(Student s : students){
            if(s.getFirstName().equalsIgnoreCase(student)|| s.getLastName().equalsIgnoreCase(student)){
                return s;
            }
        }
        return null;

    }
    public String getTeacherName(String teacher){       //Returns a teacher's full name as a string
        for(Teacher t: teachers){
            if(t.getFirstName().equalsIgnoreCase(teacher)|| t.getLastName().equalsIgnoreCase(teacher)){
                return t.getFirstName() +" " + t.getLastName();
            }
        }
        return "That teacher doesn't exist!";
    }
    public boolean teacherExist(String teacher){
        for(Teacher t : teachers){
            if(t.getFirstName().equalsIgnoreCase(teacher)|| t.getLastName().equalsIgnoreCase(teacher)){
                return true;
            }
        }
        return false;
    }
    public static Teacher getTeacher(String teacher){           //Returns a Teacher object
        for(Teacher t : teachers){
            if(t.getFirstName().equalsIgnoreCase(teacher)|| t.getLastName().equalsIgnoreCase(teacher)){
                return t;
            }
        }
        return null;
    }

}
