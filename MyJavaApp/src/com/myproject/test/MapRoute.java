package com.myproject.test;
import java.util.LinkedList;

public class MapRoute {
    public static void main(String[] args) {
        LinkedList<String> route = new LinkedList<>();

        route.add("Start: Home");
        route.add("Turn left on Main Street");
        route.add("Turn right on Elm Street");
        route.add("Destination: Grocery Store");
        route.set(2, "Macys");

        // Adding a detour
        route.add(2, "Detour: Coffee Shop");

        System.out.println("Updated Route:");
        for (String step : route) {
            System.out.println(step);
        }
    }
}