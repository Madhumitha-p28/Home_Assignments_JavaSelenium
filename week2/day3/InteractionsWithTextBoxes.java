package week2.week2.day3;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InteractionsWithTextBoxes {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		//  CHECK IF BASIC CHECKBOX IS DISPLAYED
		WebElement basiccb = driver.findElement(By.xpath("//span[text()='Basic']"));
		boolean isdisplayed = basiccb.isDisplayed();		
		if (isdisplayed) {
			basiccb.click();
		}		
		
		//CLICK ON BASIC CHECKBOX
		WebElement verifyselected = driver.findElement(By.xpath("//span[text()='Basic']/preceding-sibling::div/input"));
		boolean verifystate=verifyselected.isSelected();
		System.out.println("Basic selected = " + verifystate);
		
		// CHECK IF NOTIFIACTION AJAX CHECKBOX IS DISPLAYED
		
		WebElement cbnoti = driver.findElement(By.xpath("//span[text()='Ajax']"));
		boolean isnotidisplayed = cbnoti.isDisplayed();
		if (isnotidisplayed) {
			cbnoti.click();
		}	
		
		// CLICK ON NOTIFICATION AJAX CHECKBOX
		WebElement verifynoti = driver.findElement(By.xpath("//span[text()='Ajax']/preceding-sibling::div/input"));
		boolean blnoti=verifynoti.isSelected();
		System.out.println("Notification selected = " + blnoti);
		
		// VERIFY THE MESSAGE 
		WebElement wblmessage = driver.findElement(By.xpath("//div[@role='alert']/div/span"));
		String message = wblmessage.getText();
		System.out.println("Ajax Message  " + message);
		
		if(message.equals("Checked"))
		{
			System.out.println("Ajax Message is verified");
		}
		
	
		
	    // CHECK IF UR  FAVOURITE LANGUAGE IS DISPLAYED
		
		WebElement wbllangclick = driver.findElement(By.xpath("//label[text()='Javascript']"));
		boolean blislang=wbllangclick.isDisplayed();
		if (blislang) {
			wbllangclick.click();
		}
		
		 // CLICK ON FAVOURITE LANGUAGE 	
		WebElement wbllang = driver.findElement(By.xpath("//label[text()='Javascript']/preceding-sibling::div/div/input"));
		boolean blislangselect=wbllang.isSelected();
		System.out.println("Language selected = " + blislangselect);
		
		
        // CHECK IF TRI COLOUR STATE CHECK BOX IS DISPLAYED
		
		WebElement wbltri = driver.findElement(By.xpath("//div[@id='j_idt87:ajaxTriState']//div[2]"));	
		String attribute = wbltri.getDomAttribute("class");
		
		// CLICK ON TRI COLOUR STATE
		if(!attribute.contains("state-active"))
		{
		driver.findElement(By.xpath("//div[@id='j_idt87:ajaxTriState']//div[2]")).click();
		
		String text = driver.findElement(By.xpath("//div[@role='alert']//div[2]/p")).getText();
		System.out.println("State Changed to = " + text);
		}
		Thread.sleep(2000);
		
		// CHECK IF TOGGLE SWITCH IS DISPLAYED
		
		WebElement eletoggle = driver.findElement(By.xpath("//div[@class='ui-toggleswitch ui-widget']"));
		boolean bltoggle = eletoggle.isDisplayed();
		
		// CLICK ON TOGGLE SWITCH
		if(bltoggle) {		
			eletoggle.click();
		}
		
		
		Thread.sleep(2000);
		// VERIFY CHECKBOX IS DISABLED
		WebElement wbltoggmessage = driver.findElement(By.xpath("//div[@role='alert']/div/span"));
		boolean istogglemesdisp = wbltoggmessage.isDisplayed();
		String  strtoggmessage = wbltoggmessage.getText();
		System.out.println("Toggle Message  " + strtoggmessage);
		
		if(message.equals("Checked"))
		{
			System.out.println("Toggle Message is verified");
		}
		
		
		
		WebElement elevercb = driver.findElement(By.xpath("(//div[@class='ui-selectbooleancheckbox ui-chkbox ui-widget'])[3]/span"));
		String strvercb = elevercb.getText();
		if (strvercb.equals("Disabled"))
		{
		  System.out.println("The CheckBox is disabled");	
		}
		
		// SELECT MULTIPLE
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//div[@class='ui-selectcheckboxmenu-multiple ui-selectcheckboxmenu ui-widget ui-state-default ui-corner-all']"));
		WebElement elecitydisp = driver.findElement(By.xpath("//ul[@data-label='Cities']"));
		boolean iscitydisp = elecitydisp.isDisplayed();
		System.out.println(iscitydisp);
		
		Thread.sleep(2000);
		
		WebElement eleSelectMulRome = driver.findElement(By.xpath("//ul[@data-label='Cities']"));
		eleSelectMulRome.click();
		
		WebElement eleEnterCityRome = driver.findElement(By.xpath("//div[@class='ui-selectcheckboxmenu-filter-container']/input"));
		eleEnterCityRome.sendKeys("Rome");
		
		
		
		
		WebElement eleSelRomClick= driver.findElement(By.xpath("//li/label[text()='Rome']/preceding-sibling::div/div[2]"));
		eleSelRomClick.click();
		
		eleEnterCityRome.clear();
		
		
		WebElement eleEnterCityLond = driver.findElement(By.xpath("//div[@class='ui-selectcheckboxmenu-filter-container']/input"));
		eleEnterCityLond.sendKeys("London");
		
		WebElement eleSelLonClick= driver.findElement(By.xpath("//li/label[text()='London']/preceding-sibling::div/div[2]"));
		eleSelLonClick.click();
		
		driver.findElement(By.xpath("//a[@class='ui-selectcheckboxmenu-close ui-corner-all']")).click();
		System.out.println("Cities are selected");
		
		driver.close();
	}

}
