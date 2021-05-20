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
        enrollStudentOption();


    }
    public void enrollStudentOption(){
                System.out.println("Which student?");
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
