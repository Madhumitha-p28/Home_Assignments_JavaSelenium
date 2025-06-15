package week1.day3;

public class LibraryManagement {

	public static void main(String[] args) {
		Library lib = new Library();
		String book = lib.addBook("The Power of Money");
		System.out.println("Book Name is " + book);
		lib.issueBook();
	}

}
