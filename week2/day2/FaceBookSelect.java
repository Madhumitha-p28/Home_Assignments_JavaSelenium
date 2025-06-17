package week2.week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class FaceBookSelect {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		Select sel;
		
		
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// CLICK ON CREATE NEW ACCOUNT
		driver.findElement(By.linkText("Create new account")).click();
		
		
		// PASS THE VALUES 
		driver.findElement(By.name("firstname")).sendKeys("Varun");
		driver.findElement(By.name("lastname")).sendKeys("Krishnan");
		driver.findElement(By.name("reg_email__")).sendKeys("9876543210");
		driver.findElement(By.id("password_step_input")).sendKeys("pawpatrol18");
		
		WebElement ddDay = driver.findElement(By.id("day"));
		sel = new Select(ddDay);
		sel.selectByVisibleText("18");
		
		WebElement ddMon = driver.findElement(By.id("month"));
		sel = new Select(ddMon);
		sel.selectByVisibleText("Oct");
		
		WebElement ddYear= driver.findElement(By.id("year"));
		sel = new Select(ddYear);
		sel.selectByVisibleText("2002");
		
		WebElement radio = driver.findElement(By.xpath("//input[@name='sex' and @value='2']"));
		radio.click();
		
		driver.close();
		
	}

}
