package week5.week5.day1;



import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EntityNameDP extends ProjectSpecificMethodSalesforce{

	
	@DataProvider(name = "fetchData")
	public String[][] SendData()
	{
		String dynamic[][];
		dynamic= new String[3][1];
		
		dynamic[0][0] = "Salesforce by Varun";
		dynamic[1][0] = "Salesforce by Sathish";
		dynamic[2][0] = "Salesforce by Madhu";
		
		return dynamic;
		
	}
	
	
	
	@Test(dataProvider = "fetchData")
	public void CreateEntityName(String strName) throws InterruptedException {

		// ENTER VALUE IN  LEGAL ENTITY NAME
		WebElement eleName = driver.findElement(By.xpath("//input[@name='Name']"));
		eleName.sendKeys(strName);

		// CLICK ON SAVE BUTTON
		WebElement eleSaveClick = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		eleSaveClick.click();

		// GET THE TEXT FROM GRID
		WebElement eleGridLegalEntityName = driver
				.findElement(By.xpath("(//lightning-formatted-text[text()='"+strName +"'])[2]"));
		String strText = eleGridLegalEntityName.getText();

		// VERIFY THE NAME ENTERED AND NAE ON GRID
		if (strText.contains(strName)) {
			System.out.println("Name is verified");
		}
	}

}
