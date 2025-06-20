package week1.Marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);

		// LAUNCH BROWSER AND SEARCH URL
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();	
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// SEARCH
		WebElement eleSearch = driver.findElement(By.id("twotabsearchtextbox"));
		eleSearch.sendKeys("Bags for boys");
		
		// CLICK ON SEARCH
		WebElement eleClickSearch = driver.findElement(By.id("nav-search-submit-button"));
		eleClickSearch.click();
		
		// GET THE RESULTS COUNT
		WebElement eleGridText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none s-breadcrumb-header-text']//span"));
		String strGrid = eleGridText.getText();
		String[] splitResult = strGrid.split(" ");
		String strResult = splitResult[3];
		
		System.out.println("Total Numbet of Results = " + strResult);
		
		// CLICK ON FIRST BRAND CHECKBOX
		WebElement eleFirstCb = driver.findElement(By.xpath("(//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-medium'])[2]/span[@class='a-declarative']/span//a"));
		eleFirstCb.click();
		Thread.sleep(2000);
		boolean b =   driver.findElement(By.xpath("(//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-medium'])[1]/span[@class='a-declarative']/span[2]//a")).isDisplayed();
		
		// CLICK ON SECOND BRAND CHECKBOX
	 	WebElement eleSeccb =   driver.findElement(By.xpath("(//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-medium'])[1]/span[@class='a-declarative']/span[2]//a"));
		eleSeccb.click();
		Thread.sleep(1000);
		
		// CLICK ON SORT -->NEW ARRIVALS
		WebElement eleSort = driver.findElement(By.xpath("//select[@id='s-result-sort-select']//option[text()='Newest Arrivals']"));
		eleSort.click();
		WebElement eleSortClick= driver.findElement(By.xpath("//ul[@class='a-nostyle a-list-link']/li[5]/a"));
		eleSortClick.click();
		Thread.sleep(1500);
		
		// GET THE BRAND NAME TEXT OF FIRST SEARCH RESULT
		WebElement eleBrandName = driver.findElement(By.xpath("//div[@class='a-section a-spacing-base']//preceding-sibling::div[2]/div[@class='a-row a-size-base a-color-secondary']//span"));
		String strBrandName = eleBrandName.getText();
														  
		System.out.println("Brand = " + strBrandName);
 
		// GET THE PRICE  TEXT OF FIRST SEARCH RESULT
		WebElement elePrice =  driver.findElement(By.xpath("//div[@class='a-section a-spacing-base']/div[2]//span[@class='a-price-whole']"));
		String strPrice =elePrice.getText();
		System.out.println("Price = " + strPrice);
	
		// GET THE PAGE TITLE
		String strTitle = driver.getTitle();
		System.out.println("Page Title = " + strTitle);
		
		driver.close();
		
		
	}

}
