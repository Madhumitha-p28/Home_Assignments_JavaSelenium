package week1.day3;

public class EdgeBrowser {

	public static void main(String[] args) {
		
		Browser brow = new Browser();	  
		System.out.println(brow.launchBrowser("Google Chrome"));
		brow.loadUrl();
	}

}
