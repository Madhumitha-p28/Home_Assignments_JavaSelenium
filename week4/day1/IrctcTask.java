package week4.day4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IrctcTask {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// LAUNCH THE URL
		driver.get("https://www.irctc.co.in/");
		// CLICK ON OK
		WebElement eleOK = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		eleOK.click();
		// CLICK ON FLIGHTS
		WebElement eleFlightClick = driver.findElement(By.xpath("(//label[text()='FLIGHTS'])[2]"));
		eleFlightClick.click();
		// GET THE WINDOWS ID
		Set<String> windows = driver.getWindowHandles();
		// CONVERT TO A LIST
		List<String> lstWindlowsID = new ArrayList<String>(windows);
		// SWITCH THE FOCUS TO THE CHILD WINDOW
		driver.switchTo().window(lstWindlowsID.get(1));
		// GET THE CHILD WINDOW PAGE TITLE AND PRINT
		String childWindowTitle = driver.getTitle();
		System.out.println("Child Window Title " + childWindowTitle);
		// SWITCH THE FOCUS TO THE PARENT WINDOW
		driver.switchTo().window(lstWindlowsID.get(0));
		// CLOSE THE PARENT WINDOW
		driver.close();

	}

}
