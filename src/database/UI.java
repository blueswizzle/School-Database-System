package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class UI {
    School school;
    Scanner scanner;
    ArrayList<Course> courseArrayList;

    public UI(School school){
        this.school = school;
        this.scanner = new Scanner(System.in);
        this.courseArrayList = new ArrayList<>();
    }

    public void start() throws FileNotFoundException {
        addCourses();
        addStudents();
        addTeachers();
        System.out.println("****Welcome to the " + school.getSchoolName() + " Database****");
        while(true){
            System.out.println("");
            printOptions();
            int input = Integer.valueOf(scanner.nextLine());
            switch(input){
                case 0:
                    System.out.println("Exiting Database");
                    break;
                case 1: school.listStudents();
                    continue;
                case 2:
                    System.out.println("Enter Grade level");
                    int grade = Integer.valueOf(scanner.nextLine());
                    school.listStudentsByGrade(grade);
                    continue;
                case 3: school.listTeachers();
                    continue;
                case 4: enrollStudentOption();
                    continue;
                case 5: receiveStudentTuitionOption();
                    continue;
                case 6: getStudentInfo();
                    continue;
                case 7: getTeacherInfo();
                    continue;
                case 8: paySalaryTeacher();
                    continue;
                case 9: school.showFinanceHistory();
                    continue;
            }
            break;
        }


    }
    public void enrollStudentOption(){
                System.out.println("Which student to enroll courses in? Enter first or last name: ");
                String student = scanner.nextLine();
                while(true){
                    if(school.studentExist(student)){
                        System.out.println("Which course(s) should " + school.getStudentName(student) + " be enrolled in? Press 0 to end");
                        printCourses();
                        int courseInput = Integer.valueOf(scanner.nextLine());
                        switch(courseInput){
                            case 0: break;
                            case 1: school.getStudent(student).enroll("Physics", 300);
                                continue;
                            case 2: school.getStudent(student).enroll("Calculus", 330);
                                continue;
                            case 3: school.getStudent(student).enroll("English", 300);
                                continue;
                            case 4: school.getStudent(student).enroll("Chemistry", 330);
                                continue;
                            case 5: school.getStudent(student).enroll("Biology", 300);
                                continue;
                        }
                    }
                    break;
                }

    }
    public void printOptions(){
        System.out.println("What would you like to do? Press 0 to exit the Database");
        System.out.println("1)List Students");
        System.out.println("2)List Students by grade");
        System.out.println("3)List Teachers");
        System.out.println("4)Enroll a student in courses");
        System.out.println("5)Receive student tuition");
        System.out.println("6)Show a student's information");
        System.out.println("7)Show a teacher's information");
        System.out.println("8)Pay Teacher salary");
        System.out.println("9)View School's finance history");
    }
    public void receiveStudentTuitionOption(){
        school.listStudents();
        System.out.println("From which student did you receive tuition from?");
        String student = scanner.nextLine();
        if(school.studentExist(student)){
            school.getStudent(student).showInfo();
            System.out.println("How much did " + school.getStudentName(student) + " pay?");
            int amount = Integer.valueOf(scanner.nextLine());
            school.getStudent(student).payTuition(amount);
        }else{
            System.out.println("That student doesn't exist");
        }
    }
    public void getStudentInfo(){
        school.listStudents();
        System.out.println("Which student's info would you like to access? Enter first or last name: ");
        String student = scanner.nextLine();
        school.getStudent(student).showInfo();
    }
    public void getTeacherInfo(){
        school.listTeachers();
        System.out.println("Which teacher's information would you like to access? Enter first or last name: ");
        String teacher = scanner.nextLine();
        school.getTeacher(teacher).showTeacherInfo();
    }
    public void paySalaryTeacher(){
        school.listTeachers();
        System.out.println("Whose salary would you like to pay? School's Remaining balance: $" + school.getBalance());
        String teacher = scanner.nextLine();
        school.getTeacher(teacher).receiveSalary();
        System.out.println("\t\tSchool's Remaining balance: $" + school.getBalance());
    }
    public void addCourses() throws FileNotFoundException {
        File coursesList = new File("/Users/atheek_99/Documents/Java Projects/School Database System/courselist.txt");
        Scanner fileReader = new Scanner(coursesList);
        while(fileReader.hasNextLine()){
            String course = fileReader.nextLine();
            String[] parts = course.split(",");
            String name = parts[0];
            int price = Integer.valueOf(parts[1]);
            courseArrayList.add(new Course(name,price));
        }
    }
    public void printCourses(){
        System.out.println("Courses Available: ");
        int i =1;
        for(Course c : courseArrayList){
            System.out.print(i +" ") ;
            System.out.println(c);
            i++;
        }
    }
    public void addStudents() throws FileNotFoundException {
        File studentList = new File("/Users/atheek_99/Documents/Java Projects/School Database System/studentlist.txt");
        Scanner studentReader = new Scanner(studentList);
        while(studentReader.hasNextLine()){
            String student = studentReader.nextLine();
            String [] parts = student.split(",");
            String firstName = parts[0];
            String lastName = parts[1];
            String id = parts[2];
            int grade = Integer.valueOf(parts[3]);
            school.addStudent(new Student(firstName,lastName,id,grade));
        }
    }
    public void addTeachers() throws FileNotFoundException {
        File teacherList = new File("/Users/atheek_99/Documents/Java Projects/School Database System/teacherslist.txt");
        Scanner teacherReader = new Scanner(teacherList);
        while(teacherReader.hasNextLine()){
            String teacher = teacherReader.nextLine();
            String [] parts = teacher.split(",");
            String firstName = parts[0];
            String lastName = parts[1];
            String id = parts[2];
            int salary = Integer.valueOf(parts[3]);
            school.addTeacher(new Teacher(firstName,lastName,id,salary));
        }
    }



}
