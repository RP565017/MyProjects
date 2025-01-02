package com.myproject.test;

import java.util.HashMap;
import java.util.Map;

public class HmapExam {
  public static void main(String[] args) {
    Map<String, String> capitalCities = new HashMap<>();
    capitalCities.put("England", "London");
    capitalCities.put("Germany", "Berlin");
    capitalCities.put("Norway", "Oslo");
    capitalCities.put("USA", "Washington DC");
    capitalCities.merge("Canada", "Ottawa", (a, b) -> a + " -> " + b);
    capitalCities.merge("England", "London", (a, b) -> a + " -> " + b);
    capitalCities.merge("Germany", "Berlin", (a, b) -> a + " -> " + b);
    System.out.println(capitalCities.keySet());
    System.out.println(capitalCities.containsKey("Canada"));
  }
}
