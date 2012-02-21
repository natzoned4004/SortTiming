/*
 * Noah Alonso-Torres
 * SortTiming
 * Sorters Class
 */


import java.util.Arrays;
import java.util.*;

public class Sorters {
	
	// BubbleSort
	public static void bubbleSort(int[] array) {
		boolean exchanged = true;

		while (exchanged) { // First pass, or we made changes previous pass
			exchanged = false;
			for (int i = 0; i < array.length-1; i++) {
				if (array[i] > array[i+1]) {
					swap(array, i, i+1);
					exchanged  = true; //exchange was made
				}
			}
		}
	}
	
	// Quicksort.  This is the public method you'll call to do sorting.
	public static void quickSort(int[] array) {
		Arrays.sort(array); // standard library sort method is quicksort
	}
	
	// Handy method for printing the content of an array
	public static void printArray(int[] array) {
		for (int i:array)
			System.out.println(i + " ");
		System.out.println();
	}

	// Helper method, used by Bubblesort
	// Swap the data at indices i and j of the data array
	private static void swap(int array[], int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		int testcap = 20000; // Set this for the maximum array size for test.
		
		System.out.println("Size,       Bubblesort,            Quicksort");
		for (int size = 1000; size <= testcap; size += 1000){
			int[] array = new int[size];
			for ( int i = 0; i < array.length; i++ ){
				array[i] = (int)(Math.random()*1000000);
			}
			long before = System.nanoTime();
			bubbleSort(array);
			double bTime = (System.nanoTime() - before)/1000000000f;
			
			for ( int i = 0; i < array.length; i++ ){
				array[i] = (int)(Math.random()*1000000);
			}
			
			before = System.nanoTime();
			quickSort(array);
			double qTime = (System.nanoTime() - before)/1000000000f;
			
			System.out.println(size + ",  " + bTime + ",  " + qTime);
		}
	}
}