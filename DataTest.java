package tests;

	import java.util.regex.Pattern;
	import java.util.concurrent.TimeUnit;
	import org.junit.*;
	import static org.junit.Assert.*;
	import static org.hamcrest.CoreMatchers.*;
	import org.openqa.selenium.*;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;

	public class DataTest {
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
	  public void testNr() throws Exception {
	    driver.get(baseUrl + "/carinderiaoms/login.php");
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("nroldan");
	    driver.findElement(By.id("pwd")).clear();
	    driver.findElement(By.id("pwd")).sendKeys("t");
	    driver.findElement(By.name("loginButton")).click();
	    driver.findElement(By.linkText("New Order")).click();
	    new Select(driver.findElement(By.name("searchtype"))).selectByVisibleText("Company");
	    driver.findElement(By.id("searchterm")).clear();
	    driver.findElement(By.id("searchterm")).sendKeys("rakuten");
	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	    
	    //at this point, we identify the cell in the table.
	   String scompany = driver.findElement(By.xpath("html/body/center/table/tbody/tr[3]/td[2]")).getAttribute("textContent");
	   //decide if it is equal to the correct value; in this case the correct value is "rakuten"
	   if (scompany.equalsIgnoreCase("rakuten")) 
		   {
			System.out.println("Data verification passed");
		   } else {
			   System.out.println("Data verification FAILED, please check");
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



