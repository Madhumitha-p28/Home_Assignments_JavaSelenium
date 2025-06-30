package week3.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonInteraction {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://leafground.com/button.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// CLICK ON THE BUTTON IN CLICK AND CONFIRM BUTTON
		WebElement eleClickAndCofirmTitle = driver
				.findElement(By.xpath("//h5[text()='Click and Confirm title.']/following-sibling::button"));
		eleClickAndCofirmTitle.click();

		// GET THE PAGE TITLE
		String strPageTitle = driver.getTitle();
		System.out.println("Page Title = " + strPageTitle);

		// VERIFY THE PAGE TITLE
		if (strPageTitle.equals("Dashboard")) {
			System.out.println("Page Title " + strPageTitle + " is verfied");
		} else {
			System.out.println("Page Title " + strPageTitle + " is mismatched");
		}

		// NAVIGATE BACK TO THE PREVIOUS PAGE
		driver.navigate().back();

		// CHECK IF THE BUTTON IS DIABLED
		WebElement eleDisabled = driver	.findElement(By.xpath("//h5[contains(text(),'is disabled.')]/following-sibling::button"));
		
		if (eleDisabled.isEnabled()) { 
			System.out.println("Confirm if the button is disabled is enabled");
		} else {
			System.out.println("Confirm if the button is disabled is disabled");
		}

		// GET THE POSITION OF THE SUBMIT BUTTON 
		WebElement eleSubmit = driver.findElement(By.xpath("//h5[contains(text(),'Find the position')]/following-sibling::button"));
		Point location = eleSubmit.getLocation();
		System.out.println("The position of Button is " + location.getX() + " and " + location.getY());
		
		
		// GET THE BACKGROUND COLOR OF THE SUBMIT BUTTON
		WebElement eleBackgroundColor = driver.findElement(By.xpath("//h5[text()='Find the Save button color']/following-sibling::button"));
		String bgColor = eleBackgroundColor.getCssValue("background-color"); 
		System.out.println("Background color is: " + bgColor);

		
		// GET THE HEIGHT AND WIDTH OF THE SUBMIT BUTTON
		WebElement eleHeightAndWidth = driver.findElement(By.xpath("//h5[contains(text(),'height and width')]/following-sibling::button"));
		Dimension size = eleHeightAndWidth.getSize(); 
		System.out.println("The Height :" + size.getHeight() + "," + "Width : " + size.getWidth());
		
		// CLOSE THE DRIVER
		driver.close();
	}

}
