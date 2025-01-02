package com.myproject.test;


class Person {
    private String name; // Private field
    private int age;     // Private field

    // Getter for name
    public String getName() {
    	
    	System.out.println("1" +  name );
    	
        return name;
    }

    // Setter for name
    public void setName(String name) {
    	
 
    	System.out.println( "2" + this.name   + name );
    	
        this.name = name;
        
        System.out.println( "3" + this.name   + name );
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age with validation
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative");
        }
    }
}

public class DemoEncapsulation1  {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Alice"); // Uses setter to set name
        person.setAge(-5);       // Invalid value is rejected
        System.out.println(person.getName() + " is " + person.getAge() + " years old.");
    }
}

