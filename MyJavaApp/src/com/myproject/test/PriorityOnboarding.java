package com.myproject.test;

import java.util.PriorityQueue;

//Class representing a Passenger
class Passenger implements Comparable<Passenger> {
 private String name;
 private int priority; // Lower value means higher priority
 private int arrivalTime; // FIFO order within same priority

 public Passenger(String name, int priority, int arrivalTime) {
     this.name = name;
     this.priority = priority;
     this.arrivalTime = arrivalTime;
 }

 public String getName() {
     return name;
 }
 
 public int getPriority() {
     return priority;
 }

 @Override
 public int compareTo(Passenger other) {
     // First compare by priority
     if (this.priority != other.priority) {
         return Integer.compare(this.priority, other.priority);
     }
     // If priorities are the same, compare by arrival time
     return Integer.compare(this.arrivalTime, other.arrivalTime);
 }

 @Override
 public String toString() {
     return "Passenger{name='" + name + "', priority=" + priority + ", arrivalTime=" + arrivalTime + "}";
 }
}

//Main class for boarding process
public class PriorityOnboarding {

 public static void main(String[] args) {
     // Priority queue to manage passengers
     PriorityQueue<Passenger> priorityQueue = new PriorityQueue<>();

     // Adding passengers to the priority queue
     priorityQueue.add(new Passenger("Alice", 1, 1)); // First Class
     priorityQueue.add(new Passenger("Bob", 2, 2));   // Business Class
     priorityQueue.add(new Passenger("Charlie", 3, 3)); // Economy
     priorityQueue.add(new Passenger("Dave", 1, 4));  // First Class
     priorityQueue.add(new Passenger("Eve", 2, 5));   // Business Class
     
     
 

     // Boarding passengers based on priority
     System.out.println("Boarding Order:");
     while (!priorityQueue.isEmpty()) {
         Passenger passenger = priorityQueue.poll(); // Dequeue the highest-priority passenger
         System.out.println("Boarding Passenger: " + passenger.getName() + " (Priority: " + passenger.getPriority() + ")");
     }
 }
}

