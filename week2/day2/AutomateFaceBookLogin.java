package week2.week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateFaceBookLogin {

	public static void main(String[] args) {
	
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("email")).sendKeys("testleaf.2023@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Tuna@321");
		driver.findElement(By.name("login")).click();
		
		driver.findElement(By.linkText("Find your account and log in.")).click();
		String pageTitle = driver.getTitle();
		System.out.println("Page Title = " + pageTitle);
		if(pageTitle.contains("Forgotten Password"))
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
