package week3.day3;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutomatingFrameAndAlert {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		
		// SWITCH TO FRAME
		driver.switchTo().frame("iframeResult");
		
		// ADD IMPLICIT WAIT
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// CLICK ON TRY IT BUTTON
		WebElement eleTryClick = driver.findElement(By.xpath("//button[text()='Try it']"));
		eleTryClick.click();
		
		// HANDLE ALERT
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		// GET THE TEXTAND PRINT IT
		WebElement eleText = driver.findElement(By.xpath("//p[text()='You pressed OK!']"));
        String strText = eleText.getText();
        System.out.println(strText);
	}

}
