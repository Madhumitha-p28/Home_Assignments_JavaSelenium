package steps_Week6Day1_HA_DP;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base_Week6Day1_HA_DP.ProjectSpecificMethod_Week6Day1_HA_1;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefTwo_Week6Day1_HA_1 extends ProjectSpecificMethod_Week6Day1_HA_1 {

	
	String phno ="";
	String phnoStr = "";
	
	// SEARCH NAME IN SEARCH BOX
	@When("the user searches the name in Search as (.*)$")
	public void the_user_searches_the_name_in_search_as(String straccountName) throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']"))
				.sendKeys(straccountName + Keys.ENTER);
		Thread.sleep(1000);
		
	}
	
	// CLICK ON THE DROPDOWN
	@When("the user clicks the dropdown icon for corresponding name as (.*)$")
	public void the_user_clicks_the_dropdown_icon_for_corresponding_name_as(String straccountName) throws InterruptedException {
		List<WebElement> noOfRows = driver.findElements(By.xpath("//table/tbody/tr"));
		int rowCount = noOfRows.size();

		for (int i = 1; i <= rowCount; i++) {
			WebElement eleAccName = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/th[1]/span//a//span"));
			String strName = eleAccName.getText();
			if (strName.equalsIgnoreCase(straccountName)) {
				// CLICK ON THE FIRST DISPLAYED NAME
				driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[6]")).click();
				Thread.sleep(1000);
				break;
			}
		}
	}


	// CLICK ON EDIT
	@When("the user clicks on Edit")
	public void the_user_clicks_on_edit() throws InterruptedException {
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		Thread.sleep(1000);
	}

	// SELECT THE TYPE
	@When("the user select type as (.*)$")
	public void the_user_select_type_as(String strType) {
		WebElement typeDD = driver.findElement(By.xpath("//button[@aria-label='Type']"));
		driver.executeScript("arguments[0].click()", typeDD);
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='" + strType + "']")).click();
	}

	// SELECT THE INDUSTRY
	@When("the user select Industry as (.*)$")
	public void the_user_select_industry_as(String strIndustry) {
		WebElement industryDD = driver.findElement(By.xpath("//button[@aria-label='Industry']"));
		driver.executeScript("arguments[0].click()", industryDD);
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='" + strIndustry + "']")).click();
	}

	// ENTER THE BILLING ADDRESS
	@When("the user enters the billing address (.*)$")
	public void the_user_enters_the_billing_address(String strBillingAddress) {
		WebElement biilingStreet = driver.findElement(By.xpath("//label[text()='Billing Street']/following::textarea"));
		biilingStreet.clear();
		biilingStreet.sendKeys(strBillingAddress);
	}

	// ENTER THE SHIPPING ADDRESS
	@When("the user enters the shipping address (.*)$")
	public void the_user_enters_the_shipping_address(String strShippingAddress) {
		WebElement shippingStreet = driver
				.findElement(By.xpath("//label[text()='Shipping Street']/following::textarea"));
		shippingStreet.clear();
		shippingStreet.sendKeys(strShippingAddress);
	}

	// SELECT CUSTOMER PROIRITY
	@When("the user sets the Customer Priority to (.*)$")
	public void the_user_sets_the_customer_priority_to(String strCustPriority) {
		WebElement priorityDD = driver.findElement(By.xpath("//button[@aria-label='Customer Priority']"));
		driver.executeScript("arguments[0].click()", priorityDD);
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='" + strCustPriority + "']")).click();
	}

	// SELECT THE SLA
	@When("the user sets the SLA to (.*)$")
	public void the_user_sets_the_sla_to(String strSLA) {
		driver.findElement(By.xpath("//button[@aria-label='SLA']")).click();
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='" + strSLA + "']")).click();
	}

	// SELECT ACTIVE
	@When("the user sets the Active to (.*)$")
	public void the_user_sets_the_active_to(String strActive) {
		WebElement activeDD = driver.findElement(By.xpath("//button[@aria-label='Active']"));
		driver.executeScript("arguments[0].click()", activeDD);
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='" + strActive + "']")).click();
	}

	// ENTER PHONENUMBER
	@When("the user enters phone number")
	public void the_user_enters_phone_number() {
		int randomNum1 = (int) (Math.random() * 999999);
		int randomNum2 = (int) (Math.random() * 999999);
		phno = "" + randomNum1 + randomNum2;
		phno = phno.substring(0, 10);
		System.out.println(phno);

		// ENTER THE PHONE NUMBER
		WebElement phnoField = driver.findElement(By.xpath("//input[@name='Phone']"));
		phnoField.clear();
		phnoField.sendKeys(phno);

	}

	// SELECT UPSELL
	@When("the user sets the Upsell oppurtunity (.*)$")
	public void the_user_sets_the_upsell_oppurtunity(String strUpsell) {
		WebElement upsellOpportunityDD = driver.findElement(By.xpath("//button[@aria-label='Upsell Opportunity']"));
		driver.executeScript("arguments[0].click()", upsellOpportunityDD);
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='" + strUpsell + "']")).click();

	}

	// CLICK ON SAVE
	@When("the user clicks the Update")
	public void the_user_clicks_the_update() {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		phnoStr = driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText();
		System.out.println(phnoStr);
	}

	// VERIFY PHONE NUMBER
	@Then("the user verifies the phone number")
	public void the_user_verifies_the_phone_number() {
		Assert.assertTrue(phnoStr.contains(phno), "verify the mobileNumber");
	}

}
