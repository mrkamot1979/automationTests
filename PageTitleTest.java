package tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PageTitleTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testPageTitles() throws Exception {
	    driver.get(baseUrl + "/carinderiaoms/login.php");
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("nroldan");
	    driver.findElement(By.id("pwd")).clear();
	    driver.findElement(By.id("pwd")).sendKeys("t");
	    driver.findElement(By.name("loginButton")).click();
	    if (driver.getTitle().equals("Landing")) 
	    {
			System.out.println("Landing page tab title correct");
		} else {
			System.out.println("Page title incorrect");
		}
	    driver.findElement(By.linkText("New Client")).click();
	    if (driver.getTitle().equals("New Client")) {
			System.out.println("New Client tab title correct");
		} else {
			System.out.println("ERROR: incorrect title page");
		}
	    driver.findElement(By.linkText("New Order")).click();
	    if (driver.getTitle().equals("New Order")) {
			System.out.println("New Order tab title correct");
		} else {
			System.out.println("ERROR: incorrect title page");
		}
	    driver.findElement(By.linkText("Extract by Date Range")).click();
	    if (driver.getTitle().equals("Extract by Date")) {
			System.out.println("Extract by date tab title correct");
		} else {
			System.out.println("ERROR: incorrect title page");
		}
	    
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}

	
	


