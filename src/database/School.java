package database;

import java.util.ArrayList;

public class School {
    ArrayList<Teacher> teachers;
    ArrayList<Student> students;
    private String schoolName;
    private int moneyEarned;
    private int moneySpent;

    public School(String schoolName){
        this.schoolName = schoolName;
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.moneyEarned =0;
        this.moneySpent =0;
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

}
