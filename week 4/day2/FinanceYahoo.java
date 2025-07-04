package week4.week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class FinanceYahoo {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		Actions action = new Actions(driver);

		// LOAD THE URL
		driver.get("https://finance.yahoo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// MOUSEHOVER ON MARKET
		WebElement eleMarket = driver.findElement(By.xpath("//span[text()='Markets']"));
		action.moveToElement(eleMarket).perform();

		// CLICK ON CRYPTO
		WebElement eleCrypto = driver.findElement(By.xpath("(//div[text()='Crypto'])[2]"));
		action.moveToElement(eleCrypto).click().perform();

		// GET THE TABLE AND TRAVERSE THROUGH THE ROWS AND COLUMNS IN PRINT
		// CRYPTOCURRENCY NAMES
		List<WebElement> eleBitCoinNames = driver
				.findElements(By.xpath("//div[contains(@class,'table-container')]/table//tbody/tr"));

		System.out.println(" Bit Coin Names ");
		System.out.println("=================");
		for (int i = 1; i <= eleBitCoinNames.size(); i++) {

			String strName = driver
					.findElement(
							By.xpath("//div[contains(@class,'table-container')]/table//tbody/tr[" + i + "]/td[2]/div"))
					.getText();
			System.out.println(strName);

		}
		
		// CLOSE THE CURRENT WINDOW
		driver.close();

	}

}
