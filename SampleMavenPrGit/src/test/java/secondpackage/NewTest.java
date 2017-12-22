package secondpackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;
	String url = null;
	String userid = null;
	String password = null;
	String email = null;

	@Test
	public void secondmethod() throws InterruptedException, IOException {
	InputStream fis = NewTest.class.getClassLoader().getResourceAsStream("config.properties");
	;
	Properties prop = new Properties();
	prop.load(fis);
	url = prop.getProperty("url");
	userid = System.getenv("userid");
	password = System.getenv("password");
	System.out.println("Password : " + password);
	email = prop.getProperty("email");
	System.setProperty("webdriver.chrome.driver", "D:\\Projects\\Selenium Work\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	String baseURL = url;
	driver.navigate().to(baseURL);
	WebElement element1 = driver.findElement(By.name("email"));
	WebElement element2 = driver.findElement(By.name("pass"));
	element1.sendKeys(userid);
	Thread.sleep(3000);
	element2.sendKeys(password);
	driver.findElement(By.xpath("//*[@id='loginbutton']")).click();
	System.out.println("secondmethod function");
	}
	@AfterTest
	void finalfunction2() {
	driver.quit();
	System.out.println("Under final After test");

	}
}
