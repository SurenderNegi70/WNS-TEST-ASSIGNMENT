
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MoneyTask {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "c:/work/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		/*1. Navigating to the url*/
		driver.get("https://www.moneycorp.com/en-gb/");
		
		/* Clicking on cookie's pop-up cross button, appearing at bottom.*/
		WebElement crossbutton =driver.findElement(By.xpath("//div[@id='onetrust-close-btn-container']//button"));
		JavascriptExecutor executor = (JavascriptExecutor)driver; // To resolve element click intercepted exception
		executor.executeScript("arguments[0].click()", crossbutton);
		
		/*2. Change the language and region from the top right corner to USA (English)*/
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//button[@id='language-dropdown-flag']"))));
		driver.findElement(By.xpath("//button[@id='language-dropdown-flag']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'USA')]")).click();
		
		//3.	Click "Find out more" for “Foreign exchange solutions” .
		WebDriverWait waitFbutton = new WebDriverWait(driver, 10);
		waitFbutton.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//h3[contains(text(),'Foreign exchange solutions')]/parent::div//span"))));
		driver.findElement(By.xpath("//h3[contains(text(),'Foreign exchange solutions')]/parent::div//span")).click();
		
		//3.1 	Validate if you have arrived on the page
          String ActualPageTitle= driver.getTitle();
      	 String ExpectedPageTitle= "Foreign Exchange Solutions";
		
		System.out.println(ActualPageTitle);
		
		if(ActualPageTitle.startsWith(ExpectedPageTitle)){
			System.out.println("you have arrived on the page:  "+ ActualPageTitle);
			}else{
			System.out.println("Not on the same page");
			}
		
		
        //4.1	Clicking on the search box
		WebElement element= driver.findElement(By.xpath("//span[contains(text(),'Search')]"));
		JavascriptExecutor exe = (JavascriptExecutor)driver; // To resolve element click intercepted exception
		exe.executeScript("arguments[0].click()", element);
		
		
		
		//4.2	Search for the word “international payments” using the search box
		WebElement search= driver.findElement(By.xpath("//input[@id='nav_search']"));
		search.click();
		search.sendKeys("international payments"); 
		search.sendKeys(Keys.ENTER);
		
		//5.	Validate if you have arrived on the result page
		String ActualPageUrl= driver.getCurrentUrl();
     	 String ExpectedTextOnUrl= "international+payments";
		
		System.out.println(ActualPageUrl);
		
		if(ActualPageUrl.contains(ExpectedTextOnUrl)){
			System.out.println("you have arrived on the result page:  "+ ActualPageUrl);
			}else{
			System.out.println("Not on the same page");
			}
		
		
		
		//6.	Validate that each article in the list displays a link that starts with https://www.moneycorp.com/en-us/ 
		List<WebElement> links = driver.findElements(By.xpath("//*[@class=\"results-wrapper\"]//a"));
		for (WebElement webElement : links) {
			String AllLinks=webElement.getAttribute("href");
			System.out.println(AllLinks);
			
	if(AllLinks.startsWith("https://www.moneycorp.com/en-us/")) {
		System.out.println("PASS:" + "Available articles in the list are displaying a link, that starts with : " + "https://www.moneycorp.com/en-us/");
	}
	else {
		System.out.println("FAIL:" + "Available articles are not displaying a link, starts with: " + "https://www.moneycorp.com/en-us/");
	}
	}
		driver.quit();
		}

	}

