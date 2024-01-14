package exploratory_Testing;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class ExploratoryTestAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\Test\\driver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
	        // Create a new instance of the Chrome driver
	        WebDriver driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        // Navigate to the application under test
	        driver.get("https://restful-booker.herokuapp.com/");

	        // Example of exploring the application
	        exploreApplication(driver);

	        // Close the browser
	        driver.quit();
	    }

	    private static void exploreApplication(WebDriver driver) throws InterruptedException {
	        // Sample exploratory actions
	        clickOnRandomLinks(driver, 5);
	        fillRandomFormFields(driver);
	        performDynamicSearch(driver, "exploratory testing");
	    }

	    private static void clickOnRandomLinks(WebDriver driver, int numberOfLinks) throws InterruptedException {
	        // Find all links on the page
	        List<WebElement> links = driver.findElements(By.tagName("a"));

	        // Click on a random subset of links
	        for (int i = 0; i < numberOfLinks && i < links.size(); i++) {
	            links.get(i).click();
	            // Add further actions as needed
	            driver.navigate().back();
	            Thread.sleep(5000);
	            try {
	            	links.get(i).click();
	        }
	            catch
	            	(StaleElementReferenceException e)
	            {
	            	links = driver.findElements(By.tagName("a"));
	            	links.get(i).click();
	            }
	            	}
	            
	            
	    }

	    private static void fillRandomFormFields(WebDriver driver) {
	        // Find form elements and fill with random data
	        WebElement inputField = driver.findElement(By.tagName("input"));
	        inputField.sendKeys("RandomTestData");

	        // Add more form interactions as needed
	    }

	    private static void performDynamicSearch(WebDriver driver, String searchTerm) {
	        // Find the search input field and submit a dynamic search
	        WebElement searchInput = driver.findElement(By.id("search"));
	        searchInput.sendKeys(searchTerm);
	        searchInput.submit();

	        // Add further actions based on search results
	    

	}

}
