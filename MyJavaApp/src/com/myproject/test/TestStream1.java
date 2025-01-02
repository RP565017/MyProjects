package com.myproject.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// DO stream Operations 
/* 1. filter(): Keep only Item that match tyhe condition 
 * 2.map(): Transform each Item
 * 3.sorted(): SOrt the Items
 * 4.COllect) Gather the list into the collection
 * 5.ForEach(): Perform an action for each item
 * 
 *  Task : You have the list of Numbers , and you want to filter out even Numbers and double them and sort order
 */
public class TestStream1 {
	
	public static void main(String[] args) {
		
		System.out.println("My STream API ");
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6, 9, 5);
		
		List<Object> result =  numbers.stream()
				.filter(num -> num % 2 == 0)
				.map(num -> num * 2)
				.collect(Collectors.toList());
		System.out.println(result);
		
	}

}
