package com.gl.problem1;
import java.util.Scanner;
import java.util.Stack;

public class ConstructionProblem {
	
	//Declaring required variables as static to skip creation of object for class
	
	//arr[] holds all floors that the user inputs
	//curr_floor keeps track of the current floor to be assembled. (For ex. After assembling 5th floor, curr_floor would be 4 and so on.)
	//floorSize keeps track of the current floor size we are at.
	//stack is used to hold the order of construction on a particular day
	
	static int arr[];
	static int j;
	static int i;
	static int totalFloors=0;
	static int curr_floor= totalFloors;  								
	static int floorSize=0;												
	static Scanner sc = new Scanner(System.in);
	static Stack<Integer> stack = new Stack<Integer>();
	
	
	//traverse() function traverses through each floorSize stored in arr[] and calls display method for each day.
	static void traverse() {
		for(j=0;j<arr.length;j++) {
			
			stack.push(arr[j]);						//Push the floorSize to stack in every iteration.
			
			display(arr[j], j);						//Passing floorSize i.e. arr[j] and the day it was constructed i.e (j+1) technically
			
		}
	}
	
	static void display(int floorSize, int k) {
		
		/*1. Condition checks if the current floorSize = TotalFloors. If yes, pop the floorSize from stack and display floorSize until stack is not empty.*/
		
		if(stack.peek()==totalFloors) {
			curr_floor = totalFloors;
			System.out.println("Day : "+(k+1));
			do {
				curr_floor = curr_floor - 1;
				System.out.print(stack.pop()+" ");
			}while(!(stack.isEmpty()) && stack.peek()==curr_floor);
			//while(stack.peek()==)
		}
		/*if(stack.peek()==totalFloors-1) {
			System.out.println("Day : "+(i+1));
			System.out.println(stack.pop());
		}*/
		
		/*2. If the above condition is not satisfied, 
		 * 	a. check if, the current floorSize = the next floorSize in line , If yes, pop the floorSize from stack and display floorSize until stack is not empty.  
		 * 	b. else, if condition not satisfied, print blank */
		
		else {
			if(floorSize == curr_floor) {
				System.out.println("Day : "+(k+1));
				do {
					System.out.print(stack.pop()+" ");
					curr_floor-=1;
				}while(!(stack.isEmpty()) && stack.peek()==curr_floor);
			}
			else {
				System.out.println("Day : "+(k+1));
				System.out.print(" ");
			}
			/*if(i==(totalFloors-1)) {
				//System.out.println("Day : "+(i+1));
				while(!stack.isEmpty()){
					System.out.print(stack.pop()+" ");
				}
			}*/
			
		}
		//System.out.println(stack);
		System.out.println();
		
	}
	
	
	public static void main(String[] args) {
		
		
		System.out.println("Enter the total floors in the building: ");
		totalFloors = sc.nextInt();
		arr = new int[totalFloors];
		//Running a loop from 1 to totalFloors
		
		for(i=0; i<totalFloors; i++) {
			System.out.println("Enter the floor size given on day : "+i);
			floorSize = sc.nextInt();
			
			//stack.push(floorSize);
			
			arr[i] = floorSize;
			
			
		}
		System.out.println();
		System.out.println("The order of construction is as follows: ");
		traverse();
		
		//System.out.println(stack);
		//System.out.println(stack.peek());
		//System.out.println(tempArr);
		
		/*for(int j=0;j<arr.length;j++) {
			System.out.print(arr[j]+" ");
		}*/
	}

}
