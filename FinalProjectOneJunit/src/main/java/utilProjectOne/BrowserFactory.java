package utilProjectOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//MY MAVEN TEST PROJECT

public class BrowserFactory {

	// global, so all methods can use
	WebDriver driver;
	
	public static WebDriver startBrowser() {
		
		//Set chrome driver properties
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		
		//Create ChromeDriver object and launch browser
		WebDriver driver = new ChromeDriver();
				
		return driver;
				
	}
	
}
