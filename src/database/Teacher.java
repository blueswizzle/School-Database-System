package database;

public class Teacher extends Person{

    private int salary; //A teacher's fixed salary per week, doesn't change
    private int salaryEarned; // Salary that a teacher has earned so far

    public Teacher(String firstName, String lastName, String id, int salary){
        super(firstName,lastName,id);
        this.salary = salary;
        this.salaryEarned = 0;
    }

    @Override
    public String toString(){
        return super.toString() + "Salary: $" + this.salary;
    }
}
