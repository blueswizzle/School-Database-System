package database;

public class Main {

    public static void main(String[] args){
        Student s = new Student("Boi", "Small", "S56AE45", 2);
        Student s2 = new Student("Anna", "Baker", "S43BH21", 2);
        System.out.println(s);

        Teacher t = new Teacher("Matt", "Stonie", "T23ER56",500);
        Teacher f = new Teacher("Yama", "Fuller", "T14QE98", 650);
        School school = new School("Coral Glades High School");
        school.addTeacher(t);
        school.addTeacher(f);

        school.addStudent(s);
        school.addStudent(s2);
        s.payTuition(1000);
        school.paySalary(t);
        s.payTuition(2000);
        school.showFinanceHistory();
        school.listStudentsByGrade(3);



    }
}
