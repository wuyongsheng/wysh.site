package TestNG.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Select1 {
	private WebDriver driver;
	private String baseUrl;

	@BeforeMethod
	public void setUp() throws Exception {
		// driver = new FirefoxDriver(); // 初始化ff
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
	    driver = new ChromeDriver(); //初始化chrome
		// driver = new InternetExplorerDriver();//初始化IE
		baseUrl = "http://127.0.0.1/zentao/user-login-L3plbnRhby8=.html";
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // 全局的元素等待设置
	}
	@Test(dataProvider = "dp")
	public void testUntitled(String name,String password) throws Exception {

		driver.get(baseUrl); // get 打开网址
		driver.findElement(By.id("account")).sendKeys(name);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"userNav\"]/li/a/span[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"userNav\"]/li/ul/li[13]/a")).click();
	
	}
	
	 @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { "admin", "Aa1234" },
	      new Object[] { "zhangsan","Bb1234"},
	    };
	  }

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit(); // 关闭浏览器
	}

}
