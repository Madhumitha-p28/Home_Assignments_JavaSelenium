package week2.Marathon2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethodMarathon {

	static ChromeDriver driver;
	String filePath, sheetName;

	@BeforeMethod
	@Parameters({ "url", "username", "password" })
	public void preCondition(String url, String userName, String password) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(0500);
	
		driver.findElement(By.xpath("//p[text()='Sales']/ancestor::a")).click();
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@title='Accounts']")));
		Thread.sleep(0500);

	}

	@AfterMethod
	public void postConditions() {

		driver.close();
	}

	@DataProvider(name = "fetchData")
	public String[][] sendData() throws IOException {
		return TestDataLibraryMarathon.readData(filePath,sheetName);
	}

}
