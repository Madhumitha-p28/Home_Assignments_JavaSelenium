package week5.week5.day1;




import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class EntityNameSP extends ProjectSpecificMethodSalesforce{

	@Test
	public void CreateEntityName() throws InterruptedException {

		// ENTER VALUE IN  LEGAL ENTITY NAME
		WebElement eleName = driver.findElement(By.xpath("//input[@name='Name']"));
		eleName.sendKeys("Salesforce Automation by Madhu");

		// CLICK ON SAVE BUTTON
		WebElement eleSaveClick = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		eleSaveClick.click();

		// GET THE TEXT FROM GRID
		WebElement eleGridLegalEntityName = driver
				.findElement(By.xpath("(//lightning-formatted-text[text()='Salesforce Automation by Madhu'])[2]"));
		String strText = eleGridLegalEntityName.getText();

		// VERIFY THE NAME ENTERED AND NAE ON GRID
		if (strText.equals("Salesforce Automation by Madhu")) {
			System.out.println("Name is verified");
		}
	}

}
