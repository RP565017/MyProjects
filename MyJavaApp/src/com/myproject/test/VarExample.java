package com.myproject.test;
import java.util.HashMap;

public class VarExample {
    public static void main(String[] args) {
       // Using 'variable' for type inference
    	var employeeSalaries = new HashMap<String, Double>();

       employeeSalaries.put("Alice", 75000.0);
       employeeSalaries.put("Bob", 65000.0);
       employeeSalaries.put("Bob1", 65300.0);



	for ( var entry : employeeSalaries.entrySet()) {
          System.out.println("Employee: " + entry.getKey() + ", Salary: " + entry.getValue());
       }
    }
}