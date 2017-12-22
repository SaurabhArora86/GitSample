

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.xml.sax.InputSource;

public class Consolidatedtests {
 WebDriver driver;
 String url = null;
 String userid = null;
 String password = null;
 String email = null;

	@BeforeClass
	void beforetestfunction() throws IOException {
	InputStream fis = Consolidatedtests.class.getClassLoader().getResourceAsStream("config.properties");;
	Properties prop = new Properties();
	prop.load(fis);
	url = prop.getProperty("url");
	userid = System.getenv("userid");
	password = System.getenv("password");
	System.out.println("Password : "+password);
	    email = prop.getProperty("email");
	System.setProperty("webdriver.chrome.driver", "D:\\Projects\\Selenium Work\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	String baseURL = url;
	driver.navigate().to(baseURL);
	}
	@Test(priority=2,singleThreaded= true)
  public void firstfunction() throws InterruptedException {
	WebElement element1 = driver.findElement(By.name("email"));
	WebElement element2 = driver.findElement(By.name("pass"));
	element1.sendKeys(userid);
	Thread.sleep(3000);
	element2.sendKeys(password);
	driver.findElement(By.xpath("//*[@id='loginbutton']")).click();
	System.out.println("First function");
  }
	@Test(priority=1,singleThreaded= true)
	public void secondfunction() {
	Actions action = new Actions(driver);
	WebElement element = driver.findElement(By.name("email"));
	Action series = action.moveToElement(element).keyDown(element, Keys.SHIFT).sendKeys(element, "hello").keyUp(element, Keys.SHIFT).doubleClick()
			.contextClick().build();
	series.perform();
	System.out.println("second function");
	}

	@Test(priority=0,singleThreaded= true)
	public void thirdfunction() {
	
	String Title = driver.getTitle();
	//Assert.assertEquals(Title, "abc");
	System.out.println("Title is: " + Title);
	  }
	
	@AfterClass
	void finalfunction(){
	System.out.println("Quitting driver after first class");
	driver.quit();
	}
	
	
}
