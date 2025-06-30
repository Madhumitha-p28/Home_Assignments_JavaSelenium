package week4.day4;

import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Set<String> windows = new LinkedHashSet<String>();
		// ENTER USERNAME AND PASSWORD AND CLICK LOGIN
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		// CLICK ON CRM/SFA LINK AND CLICK ON LEADS TAB
		WebElement eleCRMClick = driver.findElement(By.partialLinkText("CRM/SFA"));
		eleCRMClick.click();

		// CLICK ON CONTACTS
		WebElement eleContacts = driver.findElement(By.linkText("Contacts"));
		eleContacts.click();

		// CLICK ON MERGE CONTACTS
		WebElement eleMergeContacts = driver.findElement(By.linkText("Merge Contacts"));
		eleMergeContacts.click();

		// CLICK ON THE WIDGET NEAR THE FROM CONTACT
		WebElement eleFromWidget = driver
				.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']//following-sibling::a"));
		eleFromWidget.click();
		Thread.sleep(0500);

		// GET THE WINDOWS ADDRESS IN SET
		windows = driver.getWindowHandles();

		// CREATE A LIST AND CONVERT THE SET TO LIST
		List<String> lstWindowsFirstContact = new ArrayList<String>(windows);

		// SWITCH TO THE WINDOW OPENED AFTER CLICKING THE FROM WIDGET
		driver.switchTo().window(lstWindowsFirstContact.get(1));
		
		// CLICK ON THE FIRST CONTACT
		WebElement eleFirstContact = driver
				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
		eleFirstContact.click();

		//  SWITCH THE FOCUS TO THE PARENT WINDOW
		driver.switchTo().window(lstWindowsFirstContact.get(0));

		// CLICK ON THE WIDGET NEAR THE TO CONTACT
		WebElement eleToWidget = driver
				.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdTo']//following-sibling::a"));
		eleToWidget.click();
		Thread.sleep(0500);
		
		// GET THE WINDOWS ADDRESS IN SET
		windows = driver.getWindowHandles();

		//  CREATE A LIST AND CONVERT THE SET TO LIST
		List<String> lstWindowsSecondContact = new ArrayList<String>(windows);

		// SWITCH TO THE WINDOW OPENED AFTER CLICKING THE TO WIDGET
		driver.switchTo().window(lstWindowsSecondContact.get(1));

		// CLICK ON THE SECOND CONTACT
		WebElement eleSecondContact = driver
				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]"));
		eleSecondContact.click();

		// SWITCH THE FOCUS TO THE PARENT WINDOW
		driver.switchTo().window(lstWindowsSecondContact.get(0));

		// CLICK ON MERGE BUTTON
		WebElement eleMergeClick = driver.findElement(By.xpath("//a[text()='Merge']"));
		eleMergeClick.click();

		// HANDLE ALERT
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		// GET THE PAGE TITLE
		String strMergePageTitle = driver.getTitle();
		System.out.println("Merge Title = " + strMergePageTitle);
	}

}
