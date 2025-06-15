package week1.day3;

public class Library {
	
	
	
	
	
	String addBook(String bookTitle)
	{
		System.out.println("Book added Successfully");
		return bookTitle;		
	}
	
	void issueBook()
	{
		System.out.println("Book issued Successfully");
	}

	public static void main(String[] args) {
	
		
		Library lib = new Library();
		String book = lib.addBook("Life is Beautiful");
		System.out.println("Book Name - " + book);
		lib.issueBook();
		
		
	}

}
