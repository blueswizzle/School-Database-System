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
        boolean studentExist = false;
        for(int i=0; i < students.size(); i++){
            if(students.get(i).getFirstName().equalsIgnoreCase(student)|| students.get(i).getLastName().equalsIgnoreCase(student)){
                studentExist = true;
            }
        }
        if(studentExist){
            return true;
        }else{
            return false;
        }

    }
    public String getStudentName(String student){               //Returns a student full name as a String
       String studentName="";
        for(int i=0; i < students.size(); i++){
            if(students.get(i).getFirstName().equalsIgnoreCase(student)|| students.get(i).getLastName().equalsIgnoreCase(student)){
                studentName= students.get(i).getFirstName() +" " + students.get(i).getLastName();
            }
        }
        return studentName;
    }
    public Student getStudent(String student){          // Returns Student object
        Student s = null;
        for(int i =0; i < students.size(); i++){
            if(students.get(i).getFirstName().equalsIgnoreCase(student)|| students.get(i).getLastName().equalsIgnoreCase(student)){
                 s = students.get(i);
            }
        }
        return s;

    }
    public String getTeacherName(String teacher){       //Returns a teacher's full name as a string
        String teacherName="";
        for(int i=0; i < teachers.size(); i++){
            if(teachers.get(i).getFirstName().equalsIgnoreCase(teacher)|| teachers.get(i).getLastName().equalsIgnoreCase(teacher)){
                teacherName= teachers.get(i).getFirstName() +" " + teachers.get(i).getLastName();
            }
        }
        return teacherName;
    }
    public boolean teacherExist(String teacher){
        boolean exist = false;
        for(int i=0; i < teachers.size(); i++){
            if(teachers.get(i).getFirstName().equalsIgnoreCase(teacher)|| teachers.get(i).getLastName().equalsIgnoreCase(teacher)){
                exist =true;
            }
        }
        if(exist){
            return true;
        }else{
            return false;
        }
    }
    public static Teacher getTeacher(String teacher){           //Retuns a Teacher object
        Teacher t = null;
        for(int i=0; i < teachers.size(); i++){
            if(teachers.get(i).getFirstName().equalsIgnoreCase(teacher)|| teachers.get(i).getLastName().equalsIgnoreCase(teacher)){
                t = teachers.get(i);
            }
        }
        return t;
    }

}
