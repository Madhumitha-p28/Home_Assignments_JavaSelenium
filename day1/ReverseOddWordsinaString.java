package week2.day1;

import java.util.Arrays;

class ReverseOddWordsinaString {

	public static void main(String[] args) {

		String test = "I am a software tester";
		String reverse = "";
		String[] splitstr = test.split(" ");

		for (int i = 0; i < splitstr.length; i++) {
			if (i % 2 != 0) {
				reverse = "";
				for (int j = i; j <= i; j++) {
					char[] charArray2;
					charArray2 = splitstr[j].toCharArray();
					// System.out.println(charArray2);

					for (int k = charArray2.length - 1; k >= 0; k--) {
						String c = Character.toString(charArray2[k]);
						reverse = reverse.concat(c);

					}

					// System.out.println(reverse);
					splitstr[i] = reverse;
				}

			}
		}

		// reverse = Arrays.toString(splitstr);
		// reverse = String.join(" ", splitstr);
		// reverse = reverse.replaceAll(",", "");
		// reverse = reverse.replaceAll("", "");

		reverse = "";
		for (int i = 0; i < splitstr.length; i++) {
			reverse = reverse.concat(splitstr[i] + " ");

		}
		System.out.println(reverse);

	}

}
