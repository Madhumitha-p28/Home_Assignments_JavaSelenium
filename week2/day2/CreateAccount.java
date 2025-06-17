package week2.week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateAccount {

	public static void main(String[] args)  {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);		
		
		driver.get("http://leaftaps.com/opentaps/");	
		driver.manage().window().maximize();
		
		//ENTER USERNAME AND PASSWORD AND CLICK LOGIN
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		
		// CLICK ON CRM/SFA LINK AND CLICK ON ACCOUNTS TAB
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Accounts")).click();
		
		// CLICK ON CREATE ACCOUNT MENU
		driver.findElement(By.linkText("Create Account")).click();
		
		// ENTER THE DETAILS
		driver.findElement(By.id("accountName")).sendKeys("User2");
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
		driver.findElement(By.id("numberEmployees")).sendKeys("100");
		driver.findElement(By.id("officeSiteName")).sendKeys("Chennai");
		
		// CLICK ON CREATE ACCOUNT BUTTON
		driver.findElement(By.className("smallSubmit")).click();
		
		
		String title = driver.getTitle();
		if(title.contains("Account Details"))
		{
			System.out.println("Title is verified");
		}
		else
		{
			System.out.println("Title is not matching the requirement");
		}
		driver.close();
		
		
		
	}

}
