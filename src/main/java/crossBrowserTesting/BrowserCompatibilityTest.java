package crossBrowserTesting;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BrowserCompatibilityTest {

  WebDriver driver;
  
 		@BeforeTest
 		@Parameters("browser")
		    public void setup(String browser) {
		        // Initialize the driver based on the specified browser
		        switch (browser.toLowerCase()) {
		            case "chrome":
		       
		               WebDriverManager.chromedriver().setup();
		            	driver = new ChromeDriver();
		            	System.out.println("Launch Chrome");
		                break;
		            case "firefox":
		              
		            	WebDriverManager.firefoxdriver().setup();
		            	driver = new FirefoxDriver();
		            	System.out.println("Launch firefox");
		                break;
		            case "edge":
		            	WebDriverManager.edgedriver().setup();
		                driver = new EdgeDriver();
		                System.out.println("Launch Edge");
		                break;
		            default:
		                throw new IllegalArgumentException("Invalid browser specified");
		        }
		    }

		    @Test
		    
		    public void testApplicationCompatibility() {
		        // Perform test steps here
		        driver.get("https://www.facebook.com/");
		        String actual=driver.getTitle();
		        String expected="Facebook – log in or sign up";
		        Assert.assertEquals(actual.contains("Facebook – log in or sign up"), expected.contains("Facebook – log in or sign up"));

		        
		    }

		    @AfterTest
		    public void endTest() {
		        // Close the browser after each test method
		    	driver.quit();
		
	}

}
