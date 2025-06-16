package week2.day1;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		String str1 = "stops";
		String str2 = "potss";
		boolean isAnagram = false;
		if (str1.length() == str2.length()) {
			char[] charArray1 = str1.toCharArray();
			char[] charArray2 = str2.toCharArray();

			Arrays.sort(charArray1);
			Arrays.sort(charArray2);

			for (int i = 0; i < charArray1.length; i++) {
				isAnagram = false;
				for (int j = i; j < charArray2.length; j++) {

					if (charArray1[i] == charArray2[j]) {
						isAnagram = true;
						break;
					}
				}
			}

			if (isAnagram) {
				System.out.println("The given strings are Anagram.");
			} else {
				System.out.println("The given strings are not an Anagram");
			}
		} else {
			System.out.println("Lengths mismatch therfore not an anagram");
		}

	}

}
