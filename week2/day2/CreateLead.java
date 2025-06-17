package week2.week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateLead {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();

		// ENTER USERNAME AND PASSWORD AND CLICK LOGIN
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		// CLICK ON CRM/SFA LINK AND CLICK ON LEADS TAB
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		
		// CLICK ON CREATE LEAD
		driver.findElement(By.linkText("Create Lead")).click();
		
		// PASS THE VALUES TO THE RESPECTIVE ELEMENTS
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("John");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Smith");
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Test Engineer");
		
		// CLICK ON CREATE LEAD BUTTON
		driver.findElement(By.name("submitButton")).click();
		
		
		// GET THE TITLE
		String title = driver.getTitle();
		if(title.contains("View Lead"))
		{
			System.out.println("Title is Verified");
		}
		else
		{
			System.out.println("Title does not match the requirements");
		}
		
		driver.close();

	}

}
