package database;

public class Main {

    public static void main(String[] args){
        Student s = new Student("Boi", "Small", "256AE45", 2);
        System.out.println(s);

        Teacher t = new Teacher("Matt", "Stonie", "T23ER56",500);
        Teacher f = new Teacher("Yama", "Fuller", "T14QE98", 650);
        School school = new School("Coral Glades High School");
        school.addTeacher(t);
        school.addTeacher(f);
        school.listTeachers();


    }
}
