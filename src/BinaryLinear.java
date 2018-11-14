import java.util.Scanner;

import java.util.Random;

import java.math.BigDecimal;

import java.util.Arrays;

public class BinaryLinear {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner in = new Scanner(System.in);
		System.out.println("Type in number of integers:"); // Number of integers to sort
		int userInput = in.nextInt();
		int numbers[] = new int[userInput];
		for (int i = 0; i < userInput; i++) { // Initializing all integers with a random number
			int randomInt = rand.nextInt(2000) - 1000;
			numbers[i] = randomInt;
		}

		Arrays.sort(numbers);

		long startTime = System.nanoTime();
		for (int i = 0; i < 500; i++) {
			int key = numbers[rand.nextInt(userInput - 1) + 1];
			binarySearch(numbers, key);
		}
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println();
		System.out.println("Average running time for for 500 Times, Binary: " + totalTime + " nanoseconds" );

		// Part 2

		System.out.println("Part 2");
		System.out.println("Type in number of integers");
		int userInput2 = in.nextInt();
		int numbers2[] = new int[userInput2];
		for (int i = 0; i < userInput2; i++) {
			int randomInt = rand.nextInt(2000) - 1000;
			numbers2[i] = randomInt;
		}
		
		Arrays.sort(numbers2);
		int key = 5000;
		int numbers3[] = new int[100000];
		//n = 10 ^ 5
		for (int i = 0; i < 100000; i++) {
			int randomInt = rand.nextInt(2000) - 1000;
			numbers3[i] = randomInt;

		}
		
		Arrays.sort(numbers3);
		
		// Binary Search
		System.out.println("N = 10 ^ 5");
		long binaryStartTime = System.nanoTime();
		binarySearch(numbers3, key);
		long binaryEndTime = System.nanoTime() - binaryStartTime;
		System.out.println("Worst Case Binary Search Time for N = 10 ^ 5: " + binaryEndTime + " nanoseconds");
		
		// Linear Search
		System.out.println("N = 10 ^ 5");
		long linearStartTime = System.nanoTime();
		linearSearch(numbers3, key);
		long linearEndTime = System.nanoTime() - linearStartTime;
		System.out.println("Worst Case Linear Search Time for N = 10 ^ 5: " + linearEndTime + " nanoseconds");
		
		
		// Finding time for one single step
		long startTime2 = System.nanoTime();		
		binarySearch(numbers2, key);
		linearSearch(numbers2, key);
		long endTime2 = System.nanoTime() - startTime2;
		endTime2 = (long) (binaryEndTime / Math.log(Math.pow(10, 5)/ Math.log(2))); // Log n / Base of 2
		System.out.println("One single step: " + endTime2 + " nanoseconds");
		System.out.println();
		
		
		//n = 10 ^ 7
		System.out.println("N = 10 ^ 7");
		int numbers4[] = new int[10000000];
		for (int i = 0; i < 10000000; i++) {
			int randomInt = rand.nextInt(2000) - 1000;
			numbers4[i] = randomInt;

		}
		Arrays.sort(numbers4); 
		
		// Binary Search
		long binaryStartTime2 = System.nanoTime();
		binarySearch(numbers4, key);
		long binaryEndTime2 = System.nanoTime() - binaryStartTime2;
		System.out.println("Worst Case Binary Search Time for N = 10 ^ 7: " + binaryEndTime2 + " nanoseconds");
		System.out.println("N = 10 ^ 7");
		
		// Linear Search
		long linearStartTime2 = System.nanoTime();
		linearSearch(numbers4, key);
		long linearEndTime2 = System.nanoTime() - linearStartTime2;
		System.out.println("Worst Case Linear Search Time for N = 10 ^ 7: " + linearEndTime2 + " nanoseconds");
		
	

	}

	// IF IT FINDS KEY, return true,
	public static boolean linearSearch(int[] a, int key) {
		// Run through entire array
		for (int i = 0; i < a.length; i++) {
			if (key == a[i]) {
				return true;
			}
		}
		return false;
	}

	
	public static boolean binarySearch(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		
		while (high >= low) { //Keep dividing by 2 until you find it
			// Find mid using low + high divide by 2
			int mid = (low + high) / 2;
			if (key == a[mid]) { // If key matches mid, FOUND
				return true;
			}
			else if (key < a[mid]) { // if key is less than the mid, set the high value one less than mid
				high = mid - 1;
			}
			else if (key > a[mid]) {  // if key is greater than the mid, set the high value one greater than mid
				low = mid + 1;
			}
		}
		return false; // Cant find it
	}
}