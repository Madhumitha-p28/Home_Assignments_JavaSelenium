package week1.day3;

public class Browser {
	
	String launchBrowser(String browserName)
	{
		//System.out.println(browserName);
		return browserName;
	}
	
	void loadUrl()
	{
		System.out.println("Application url loaded successfully");
	}
	
	
	
	

	public static void main(String[] args) {
		
		Browser brow = new Browser();
		String launch = brow.launchBrowser("Google Chrome");
		System.out.println(launch);
		brow.loadUrl();

	}

}
