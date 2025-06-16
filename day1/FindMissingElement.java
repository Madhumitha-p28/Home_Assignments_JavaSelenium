package week2.day1;

import java.util.Arrays;

public class FindMissingElement {

	public static void main(String[] args) {

		int arr[] = { 1, 4, 3, 2, 8, 6, 7 };

		Arrays.sort(arr);

		for (int i = 1; i < arr.length; i++) {
			int num = arr[i - 1];

			if (num != i) {
				System.out.println("The number is not present in the array = " + i);
				break;
			}
		}

	}

}
