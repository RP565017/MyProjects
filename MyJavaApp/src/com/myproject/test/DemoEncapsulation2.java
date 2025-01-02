package com.myproject.test;

 class PersonName {
    
    private String name;

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name with validation
    public void setName(String name) {
        if ("Alice".equals(name)) { // Correct string comparison
            System.out.println("Validation failed: Name cannot be 'Alice'.");
            return; // Stop further execution if validation fails
        }
        this.name = name; // Set the name if validation passes
    }
}

public class DemoEncapsulation2 {
    
    public static void main(String[] args) {
        
        Person person = new Person();

        // Set the value first
        person.setName("Alice"); // Validation will trigger, and "Validation failed..." will be displayed

        // Get the value later
        System.out.println("Name: " + person.getName()); // Will print: Name: null
    }
}
