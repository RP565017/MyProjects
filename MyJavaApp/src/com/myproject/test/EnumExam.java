package com.myproject.test;


//Group of Named Constants 
//Every Enum concept is implemented by class concept 
//Every Enum constant is public static final 
//Every Enum constant is object of the type Enum 

 enum State {

	Running, Walking, Sitting, Dancing;
}

 public class EnumExam{
	 
	 public static void main(String[] args) {
		
//		 state s = state.Running;
//		 
//		 System.out.println(s);
		 
		 for (State state1 : State.values()) {
		 
		 System.out.println(state1);
		 
		 
	}
 
	 }
 }

