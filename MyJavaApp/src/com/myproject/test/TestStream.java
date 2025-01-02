package com.myproject.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* map
   sort
   collect
   filter
 * 
 */
public class TestStream {

	public static void main(String[] args) {

		System.out.println("Strem API started ");

		List<Integer> al = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> result = new ArrayList<>();

		for (int number : al) {

			if (number % 2 == 0) {

				result.add(number * 2);
			}
		}
		System.out.println(result);
		
		List<String> cars = new ArrayList<>();
	    cars.add("Volvo");
	    cars.add("BMW");
	    cars.add("Ford");
	    cars.add("Mazda");
	    System.out.println(cars);

	}

}

