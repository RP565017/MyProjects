package com.myproject.test;

 enum Day {
    MONDAY("Workday"),
    SATURDAY("Weekend"),
    SUNDAY("Weekend");

    private String type; // Field

    // Constructor
    Day(String type) {
    	
    	System.out.println("I am" + type);
        this.type = type;
    }

    // Getter
    public String getType() {
        return type;
    }
}

public class MyTest {
    public static void main(String[] args) {
        // Accessing fields and methods
    	System.out.println("Main");
        Day day = Day.MONDAY;
       	System.out.println("day" + day);
        System.out.println(day.getType()); // Output: Workday
    }
}
