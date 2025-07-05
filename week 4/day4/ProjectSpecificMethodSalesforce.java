package week4.week4.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProjectSpecificMethodSalesforce {

	static ChromeDriver driver ;
	
	
	@BeforeMethod
	public void preCondition() throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// ENTER THE USERNAME
		WebElement eleUserName = driver.findElement(By.id("username"));
		eleUserName.sendKeys("bhuvanesh.moorthy@testleaf.com");

		// ENTER THE PASSWORD
		WebElement elePassword = driver.findElement(By.id("password"));
		elePassword.sendKeys("Leaf@2025");

		// CLICK ON LOGIN
		WebElement eleLogin = driver.findElement(By.id("Login"));
		eleLogin.click();

		// CLICK ON THR APPLAUNCHER ICON
		WebElement eleAppLauncher = driver.findElement(By.xpath("//button[@title='App Launcher']"));
		eleAppLauncher.click();

		// CLICK ON VIEWALL
		WebElement eleViewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		eleViewAll.click();
		Thread.sleep(1000);

		// CLICK ON LEGAL AUTHOROTIES
		WebElement eleLegalEntities = driver.findElement(By.xpath("//a[@data-label='Legal Entities']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-label='Legal Entities']")));
		js.executeScript("arguments[0].click();", eleLegalEntities);
		Thread.sleep(2000);

		// CLICK ON THE DROPDOWN ICON NEXT TO LEGAL ENTITY
		WebElement eleDropDown = driver.findElement(By.xpath("//span[text()='Legal Entities List']/ancestor::a"));
		eleDropDown.click();
		Thread.sleep(1000);
		
		// CLICK ON NEW LEGAL ENTITY
		WebElement eleNewLegal = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		js.executeScript("arguments[0].click();", eleNewLegal);
		Thread.sleep(0500);

		

	}

	@AfterMethod
	public void postCondition() {
		
		// CLOSE THE DRIVER
		driver.close();

	}

}
