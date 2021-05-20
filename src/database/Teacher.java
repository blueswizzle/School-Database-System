package database;

public class Teacher extends Person{

    private int salary; //A teacher's fixed salary per week, doesn't change
    private int salaryEarned; // Salary that a teacher has earned so far
    private int timesGotPaid;
    //A teacher's ID always start with 'T' to signify this is a teacher; ID is a 7 digit combination of letters and numbers e.g. T23CX78
    public Teacher(String firstName, String lastName, String id, int salary){
        super(firstName,lastName,id);
        this.salary = salary;
        this.salaryEarned = 0;
        timesGotPaid=0;
    }
    public int getSalary(){
        return this.salary;
    }
    public void receiveSalary(){
        if(School.getBalance() - salary < 0){
            System.out.println("\t\tThe school doesn't have enough money!");
        }else{
            salaryEarned += salary;
            timesGotPaid++;
            School.paySalary(School.getTeacher(this.getFirstName()));
        }

    }

    public void showTeacherInfo(){
        System.out.println("\t\t" + toString());
        System.out.println("\t\tTotal Salary Recevied: $" + salaryEarned);
        System.out.println("\t\tNumber of times paid: " + timesGotPaid);
    }

    @Override
    public String toString(){
        return super.toString() + "Salary Rate: $" + this.salary;
    }
}
