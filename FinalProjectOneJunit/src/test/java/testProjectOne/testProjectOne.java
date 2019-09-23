package testProjectOne;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import pageProjectOne.BasePage;
import pageProjectOne.PageTechfios;
import utilProjectOne.BrowserFactory;


public class testProjectOne {
	
	WebDriver driver;
	
	@Test
	public void UsersShouldBeAbleToGoToSite() throws InterruptedException {
		
		//Test 1: Validate when the toggle all check box is CHECKED, all check boxes for list items are also CHECKED ON.
		//Start browser and saves the driver in the test class
		driver = BrowserFactory.startBrowser();
		
		//Go to site
		driver.get("http://techfios.com/test/101/");
		
		// Calling LoginPage Class or Activate
		PageTechfios pageTF = PageFactory.initElements(driver, PageTechfios.class);
		
		//NANDINI
		Boolean outcome = pageTF.isToggleAllCheckBoxSelected();
		
		if(outcome == false) {
			pageTF.checkToggleAll();
			Assert.assertTrue("CheckBox is not selected!!!", pageTF.isToggleAllCheckBoxSelected());
		}
		
		else {
			//unselect it
			pageTF.checkToggleAll();
			//then select it
			pageTF.checkToggleAll();
			Assert.assertTrue("Checkbox is not selected", pageTF.isToggleAllCheckBoxSelected());	
		}
		
		//validating if all the elements in the list are checked when the toggle all button
		Assert.assertTrue("All items in the list are not selected", pageTF.checkAllCheckBoxesAreSelected());
		
		//Test 2: Validate that a single list item could be removed using the remove button when a single checkbox is selected.
		
		//uncheck everything
		pageTF.checkToggleAll();
		
		//method to check if an element is selected
		
		
		//Validate the selection using assert
		Assert.assertTrue("Element is not selected!", pageTF.isAnElementselectedToRemove());
		
		//Remove single element from list
		pageTF.removeElementFromList();
		
		//Test 3: Validate that all list item could be removed using the remove button 
		//and when "Toggle All" functionality is on.
		
		//check all checkboxes - select togelle all to remove the list
		pageTF.checkToggleAll();
		
		//remvove entire list
		pageTF.removeElementFromList();
		
		//System.out.println("Warning Message: " + pageTF.getElement());
		
//		pageTF.waitForElement(WarningMessage, driver);
		
		Assert.assertTrue("Warning Message is Not Displayed", pageTF.IsWarningDisplayed());
		
		//AP'S METHOD
//		// Call the method from thePage Class
//		pageTF.checkToggleAll();
//		
//		Boolean outcome = pageTF.isToggleAllCheckBoxSelected();
//		System.out.println("Checked" + outcome);
//		
//		if(!outcome) {
//			pageTF.checkToggleAll();
//			Assert.assertTrue("Checkbox is Selected", outcome);
//		}
//		
//		Assert.assertTrue("All Checkboxes are Selected", pageTF.checkAllCheckBoxesAreSelected());

		//driver.close();
		//driver.quit();
		
		

		
		//my method
//		List<WebElement> elements = driver.findElements(By.xpath("//input[@type = \"checkbox\"]"));
//		int checkedcount=0;
//		int uncheckedcount = 0;
//		
//		for(int i =0; i <elements.size(); i++) {
//			if(elements.get(i).isSelected() == true)
//			checkedcount ++;
//			else
//				uncheckedcount++;
//				}
//		
//		System.out.println("Number of checked checkboxes are " + checkedcount);
//		System.out.println("Number of unchecked checkboxes are " + uncheckedcount);				
//		System.out.println(pageTechFios.checkAllSelectedInLoop());	
//		Assert.assertTrue("All the items were not checked!", pageTechFios.checkAllSelectedInLoop());
		
		
		
	}
}
	