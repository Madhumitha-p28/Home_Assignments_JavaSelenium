package week5.week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethodSalesforce {

	static RemoteWebDriver driver;

	@BeforeMethod
	@Parameters({ "url", "username", "password", "browser" })
	public void preCondition(String url, String username, String password, String browser) throws InterruptedException {

		System.out.println("Test Data from XML File " + "\n URL : " + url + "\n USERNAME : " + username
				+ "\n Password : " + password + "\n browser : " + browser);

		switch (browser.toLowerCase()) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("guest");
			options.addArguments("--start-maximized");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			break;
			
			default: 
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				break;

		}

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// ENTER THE USERNAME
		WebElement eleUserName = driver.findElement(By.id("username"));
		eleUserName.sendKeys(username);

		// ENTER THE PASSWORD
		WebElement elePassword = driver.findElement(By.id("password"));
		elePassword.sendKeys(password);

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
