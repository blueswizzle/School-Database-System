package database;

import java.util.HashMap;

public class Course {
    private String name;
    private int price;

    public Course(String name, int price){
        this.name = name;
        this.price = price;
    }
    public String getCourseName(){
        return this.name;
    }
    public int getCoursePrice(){
        return this.price;
    }
    @Override
    public String toString(){
        return getCourseName() + " -- Cost: $" + getCoursePrice();
    }



}
