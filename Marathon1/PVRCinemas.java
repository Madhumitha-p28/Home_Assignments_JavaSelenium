package week1.Marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import week1.day3.EdgeBrowser;

public class PVRCinemas {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		
		
         // BROWSER LAUNCH
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//h6[text()='Chennai']")).click();
		driver.navigate().refresh();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// CLICK ON CINEMA
		WebElement eleCinema = driver.findElement(By.xpath("//span[@class='cinemas-inactive']"));
		eleCinema.click();
		
		// CLICK SELECT CINEMA 
		WebElement eleSelectCinema = driver.findElement(By.xpath("//div[@id='cinema']"));
		eleSelectCinema.click();
		
		// SELECT CINEMA
		WebElement eleSelTheatre = driver.findElement(By.xpath("//span[text()='INOX The Marina Mall, OMR, Chennai']//parent::li"));
		eleSelTheatre.click();
		
		// SELECT DATE
		WebElement eleDate = driver.findElement(By.xpath("//span[contains(text(),'Tomorrow')]//parent::li"));
		eleDate.click();
		
		// SELECT MOVIE
		WebElement eleMovie = driver.findElement(By.xpath("//span[text()='DNA']//parent::li"));
		eleMovie.click();

		// SELECT TIME
		WebElement eleTime = driver.findElement(By.xpath("//span[text()='10:35 PM']//ancestor::li"));
		eleTime.click();
		
		//CLICK BOOK
		WebElement eleBookClick = driver.findElement(By.xpath("//button[@class='p-button p-component sc-gNZgCX hrwxnG bgColor filter-btn']"));
		eleBookClick.click();
		
		// CLICK ON ACCEPT
		WebElement eleAccept = driver.findElement(By.xpath("//button[text()='Accept']"));
		eleAccept.click();
		Thread.sleep(1000);
		
		// SELECT SEAT
		WebElement eleSeat = driver.findElement(By.id("CL.CLUB|D:6"));
		eleSeat.click();
		
		// CLICK ON PROCEED
		WebElement eleProceed = driver.findElement(By.xpath("//button[text()='Proceed']"));
		eleProceed.click();
		
		Thread.sleep(1000);
		
		// GET TEXT FOR SEAT
		String strSeat = driver.findElement(By.xpath("//div[@class='select-seat-number']//p")).getText();
		System.out.println("Selected Seat = " + strSeat);
		
		// GET PRICE TEXT
		String strGrandPrice = driver.findElement(By.xpath("//div[@class='food-pay-amount']//div[@class='grand-tota col-md-3']/h6[2]/span")).getText();
		System.out.println("Total Price = " + strGrandPrice);
		
		// CLICK ON CONTINUE
		WebElement eleCont = driver.findElement(By.xpath("//button[text()='Continue']"));
		eleCont.click();		
		
		// CLICK ON CROSS ICON
		WebElement eleCross = driver.findElement(By.xpath("(//i[@class='pi pi-times'])[2]"));
		boolean blcross = eleCross.isDisplayed();
		System.out.println(blcross);
		eleCross.click();
		
		// GET PAGE TITLE
		String strPageTitle = driver.getTitle();
		System.out.println("Page Title = " + strPageTitle);
		driver.close();
	}

}
