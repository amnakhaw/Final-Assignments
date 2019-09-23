package pageProjectOne;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

public class PageTechfios extends BasePage {
	WebDriver driver;

	public PageTechfios(WebDriver driver) {
		this.driver = driver;
	}

	/// // Element Library
	@FindBy(how = How.NAME, using = "allbox")
	WebElement ToggleAllCheckBox;
	@FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
	WebElement EntireToggleList;
	// List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type =
	// 'checkbox']"));
	@FindBys(@FindBy(how = How.XPATH, using = "//input[@type='checkbox']"))
	List<WebElement> checkboxes;

	// test2 elements
	@FindBy(how = How.XPATH, using = "//input[@value = 'Remove']")
	WebElement RemoveButton;
	
	@FindBy(how = How.XPATH, using ="//b[contains(text(), 'Warning')]") WebElement WarningMessage;

	// Method to toggle all check box
	public void checkToggleAll() {
		ToggleAllCheckBox.click();
	}

	public boolean isToggleAllCheckBoxSelected() {
		return ToggleAllCheckBox.isSelected();
	}

	public boolean checkAllCheckBoxesAreSelected() {
		int uncheckedcount = 0;

		for (int i = 0; i < checkboxes.size(); i++) {
			if (checkboxes.get(i).isSelected() == false) {
				uncheckedcount++;
			}

		}
		if (uncheckedcount > 0) {
			return false;
		} else {
			return true;
		}
	}

	// TEST 2
	public boolean isAnElementselectedToRemove() {
		boolean outcomechecked = false;
		for (int i = 0; i < checkboxes.size(); i++) {
			if (i == 3) {
				checkboxes.get(i).click();
				outcomechecked = checkboxes.get(i).isSelected();
				System.out.println("is single element selected: " + outcomechecked);
				break;
			}

		}
		return outcomechecked;
	}

	// method to remove element from list remove button
	public void removeElementFromList() {
		RemoveButton.click();

	}
	
	//Test 3
//		public String getElement() {
//			
//			return WarningMessage.getText();
//		}
	
		public boolean IsWarningDisplayed() {
			
			return WarningMessage.isDisplayed();
			
		}
	

	// List<WebElement> togglelist =
	// driver.findElements(By.xpath("//input[@type='checkbox']"));
	//
	// boolean loopoutcome;
	//
	// public boolean checkAllSelectedInLoop() {
	//
	// System.out.println(togglelist.size());
	//
	// for(int i=0; i<togglelist.size(); i++) {
	// loopoutcome = togglelist.get(i).isSelected();
	// System.out.println(loopoutcome);
	//
	// if(loopoutcome == false) {
	// break;
	// }
	//
	// }
	// if(loopoutcome == false) {
	// return false;
	// }
	// else
	// return true;
	// }

}
