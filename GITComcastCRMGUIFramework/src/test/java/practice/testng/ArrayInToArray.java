package practice.testng;

import java.util.Arrays;
import java.util.List;

public class ArrayInToArray {
	
	public static int[] createArray(int ele1,int ele2,int ele3,int ele4,int ele5) {
		//int a11[]={ele1,ele2,ele3,ele4,ele5};
		return  new int[]{ele1,ele2,ele3,ele4,ele5};
		
		
	}
	
	public static int[] createArray2(int[] elements) {
		return  elements;
		
		
	}
	public static String[] createArray2(String... elements) {
		return  elements;
		
		
	}
public static void main(String[] args) {
	Object [][]  a=   {{"ssssss"},{"kumar",10,false }};
	
	int aa[] =  new int[10];
	
	 
	int aaa[]= {1,2};
	
	   int a1[]= new int[]{10,20};
	   
	   int[] arr = new int[5]; // Creates an array of integers with length 5
       
	   
	   int[] arr1 = {1, 2, 3, 4, 5}; // Creates an array and initializes it with values 1, 2, 3, 4, 5

	   
	   int[] arr2 = new int[]{1, 2, 3, 4, 5}; // Creates an array and initializes it with values 1, 2, 3, 4, 5

	   
	   
	   int[] arr3 = createArray(1, 2, 3, 4, 5); // where createArray is a method that takes integers as arguments and returns an array
	  
	   int []a22={1, 2, 3, 4, 5};
	   int[] arr33 = createArray2(a22);
	   
	   //Using Stream API: You can create an array from a collection using the Stream API.
	   List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
	   int[] arr4 = list.stream().mapToInt(Integer::intValue).toArray();


}
}
