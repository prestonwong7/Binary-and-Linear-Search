import java.util.Scanner;
import java.util.Random;

public class BinaryLinear1 {
	private static int[] a;
	private static int key;

	public static void main(String[] args) {
		long[] LinearRunStore = new long[30];
		long[] BinaryRunStore = new long[30];
		Scanner in = new Scanner(System.in);
		Random random = new Random();
		System.out.print("Enter the size of your array: ");
		int n = in.nextInt();
		a = new int[(int) Math.pow(10, 5)];
		for(int i = 0; i < a.length; i++){
			a[i] = random.nextInt(10000) - 5000;
		}
		a[a.length - 1] = 7000;
		key = 7000;
		System.out.println("");
		System.out.println(key);
		/*int Lsum = 0, Bsum = 0;
	for(int k = 0; k < 30; k++){
	Lsum += LinearRunStore[k];
	Bsum += BinaryRunStore[k];
	}
	double Lavg = Lsum/LinearRunStore.length;
	double Bavg = Bsum/BinaryRunStore.length;*/
		/*
		 * inputsize(x) = previous second record
		 * solve for x
		 * 10^7(x) to get run time
		 */
		double LrunTime = (double) linearSearch(a, key)/1000000000;
		a = new int[(int) Math.pow(10, 5)];
		for(int i = 0; i < a.length; i++){
			a[i] = random.nextInt(10000) - 5000;
		}
		a[a.length - 1] = 7000;
		double BrunTime = (double) binarySearch(Sorting(a),

				key)/1000000000;

		double Ltotal = ((LrunTime/a.length))*Math.pow(10,7);
		double Btotal = (BrunTime/(Math.log(a.length)/Math.log(2)))*

				(Math.log((int) Math.pow(10,7))/Math.log(2));

		System.out.println("The Linear run time is: " + LrunTime + "second/s.");

				System.out.println("The Binary run time is: " + BrunTime + "second/s.");

						System.out.println("The Linear run time for n = 10^(7) is: " +Ltotal + " second/s");

				System.out.println("The Binary run time for n = 10^(7) is: " +Btotal + " second/s");
	}

	/*
	 * public static double log(int x, int base){ return (Math.log(x)/
	 * Math.log(base)); }
	 */
	public static int[] Sorting(int[] a) {
		int temp = 0;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 1; j < a.length - i; j++) {
				if (a[j - 1] > a[j]) {
					temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}

	public static long linearSearch(int a[], int key) {
		long Starttime = System.nanoTime();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == key) {
				System.out.println("The position Linear Search of " +

						key + " is: " + i);

				long Total = System.nanoTime() - Starttime;
				return Total;
			}
		}
		return 0;
	}

	public static long binarySearch(int a[], int key) {
		long Starttime = System.nanoTime();
		int low = 0, high = a.length - 1;
		while (high >= low) {
			int medium = (high + low) / 2;
			if (a[medium] == key) {
				System.out.println("The position Binary Search of " +

						key + " is: " + medium);

				long Total = System.nanoTime() - Starttime;
				return Total;
			} else if (a[medium] < key) {
				low = medium + 1;
			} else if (a[medium] > key) {
				high = medium - 1;
			}
		}
		return 0;
	}
}
