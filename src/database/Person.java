package database;

public class Person {
    String firstName;
    String lastName;
    String id;

    public Person(String firstName, String lastName, String id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }



    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getID(){
        return id;
    }
    public String toString(){
        return getFirstName() + " " + getLastName() + " (" + getID() + ") ";
    }



}

