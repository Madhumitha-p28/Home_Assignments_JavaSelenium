package week2.week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {

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
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TestLeaf123");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("TestSample");
		driver.findElement(By.xpath("(//input[@name='lastName'])[3]")).sendKeys("User");
		driver.findElement(By.xpath("//input[@name='firstNameLocal']")).sendKeys("testuser");

		driver.findElement(By.name("departmentName")).sendKeys("CSC");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Selenium Automation Testing ");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("abc@gmail.com");
		
		WebElement eleState = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select sel = new Select(eleState);
		sel.selectByVisibleText("Texas");
		
		// CLICK ON CREATE
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		Thread.sleep(1000);
		
		// CLICK ON EDIT
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		Thread.sleep(1000);
		
		
		// CLEAR DESCRIPTION
		driver.findElement(By.id("updateLeadForm_description")).clear();
		
		// UPDATE IMP NOTE
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Important info on Testing ");
		
		// CLICK ON UPDATE
		driver.findElement(By.name("submitButton")).click();
		Thread.sleep(1000);
		
		// GET PAGE TITLE
		String strTitle = driver.getTitle();
		
		System.out.println("Page Title " + strTitle);
		
		driver.close();
		
		
	}

}
