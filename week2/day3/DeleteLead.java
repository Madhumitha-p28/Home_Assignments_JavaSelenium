package week2.week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// ENTER USERNAME AND PASSWORD AND CLICK LOGIN
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		// CLICK ON CRM/SFA LINK AND CLICK ON LEADS TAB
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		// CLICK ON PHONE
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		// PHONE NUMBER
		driver.findElement(By.name("phoneNumber")).sendKeys("9876543210");
		
		// FIND LEADS
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();		
		Thread.sleep(1000);
		
		// GET TEXT FROM THE GRID
		String strID = driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a")).getText();
		System.out.println(strID);
		
		// CLICK THE ID FROM THE LIST
		driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']//a")).click();
		
		// DELETE THE LIST
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		Thread.sleep(0500);
		
		// CLICK ON  FIND LEADS
		driver.findElement(By.linkText("Find Leads")).click();
		
		// ENTER THE ID
		driver.findElement(By.name("id")).sendKeys(strID);
		
		// CLICK ON THE FIND LEADS
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(0500);
		
		// GET TEXT FROM NO OF RECORDS
		String text = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		System.out.println(text);
		Thread.sleep(1000);	
		
		if(text.equals("No records to display"))
		{
			System.out.println("Lead Successfully deleted");
		}
		
		driver.close();
	}

}
