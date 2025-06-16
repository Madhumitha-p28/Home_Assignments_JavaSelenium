package week2.day1;

public class RemoveDuplicateWordInString {

	public static void main(String[] args) {

		String text = "We learn Java basics as part of java sessions in java week1";
		int count = 0;

		String[] split = text.split(" ");

		for (int i = 0; i < split.length; i++) {

			for (int j = i + 1; j < split.length; j++) {

				if (split[i].equalsIgnoreCase(split[j])) {
					split[j] = " ";
					count = count + 1;
				}
			}
		}

		if (count > 1) {
			String str = "", newtext = "";
			for (int i = 0; i < split.length; i++) {
				str = "";
				str = str.concat(split[i] + " ");
				newtext = str;
				System.out.print(newtext);
			}

		}

	}

}
