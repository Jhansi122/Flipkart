package FlipKart;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Configurations.ConfigReaderTest;
import Screenshot.ScreenshotLibraryTest;

public class FlipkartTest 
{
	WebDriver driver;
	@BeforeTest
	public void browser() 
	{
       ConfigReaderTest config = new ConfigReaderTest();
       Logger log = Logger.getLogger(FlipkartTest.class);
       System.setProperty("webdriver.gecko.driver", config.path());
       driver = new FirefoxDriver();
       log.info("Instanciating webdrver");
       log.info("URL");
       driver.get(config.URL());
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       log.info("Capturing Screenshot");
       ScreenshotLibraryTest.Screenshots(driver, "Google");
       
  //Cookie Management       
       Set<Cookie> cookies =driver.manage().getCookies();
       System.out.println("total number of cookies = "+cookies.size());
       
       for (Cookie cookie : cookies) 
       {
		System.out.println("Name of the cookie =" +cookie.getName());
		System.out.println("path of the cookie =" +cookie.getPath());
		System.out.println("Value of the cookie =" +cookie.getValue());
				
	}
       driver.manage().deleteAllCookies();
       Set<Cookie> after_deletion = driver.manage().getCookies();
       System.out.println("Cookies after deletion = " +after_deletion.size());
       
	}
	
	@Test(priority =1)
	 public void Operations()
	 {
		WebElement textbox = driver.findElement(By.xpath("//input[@title='Search']"));
		textbox.sendKeys("Flipkart");
		ScreenshotLibraryTest.Screenshots(driver, "Search");
		textbox.sendKeys(Keys.ENTER);
		ScreenshotLibraryTest.Screenshots(driver, "Search Results");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//h3[contains(@class,'sA5rQ')]")).click();
		ScreenshotLibraryTest.Screenshots(driver, "Selection from Search results");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		
		driver.findElement(By.xpath("//div[@class='_39M2dM']//input[@type='text']")).sendKeys("jhansicse12@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("important8");
		ScreenshotLibraryTest.Screenshots(driver, "Login credentials");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='_1avdGP']//button[@type='submit']")).click();
		
		List<WebElement>total_links =driver.findElements(By.tagName("a"));
		System.out.println("total number of links in the flipkart home page= " +total_links.size());

		for (WebElement element : total_links) 
		{
			System.out.println("Link = "+element.getAttribute("href"));
		}
		
	 }
	
	@Test(priority=2)
	public void MouseHover()
	{
		
		Actions action = new Actions(driver);
		WebElement mouseHouver = driver.findElement(By.xpath("//span[@class='_1QZ6fC _3Lgyp8'][contains(.,'Women')]"));
		action.moveToElement(mouseHouver).build().perform();
	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@title='Sarees']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		((JavascriptExecutor)driver).executeScript("scroll(0,500)");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		WebElement logout = driver.findElement(By.xpath("//div[@class='_2aUbKa'][contains(.,'Jhansi Lakshmi')]"));
		Actions loggingout =new Actions(driver);
		loggingout.moveToElement(logout).build().perform();
		
		driver.findElement(By.xpath("//div[@class='_1Q5BxB'][contains(.,'Logout')]")).click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
