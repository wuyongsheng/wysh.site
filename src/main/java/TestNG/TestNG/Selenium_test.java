package TestNG.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Selenium_test {
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("beforeMethod!!!");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("afterMethod!!!");
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("beforeClass!!!");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("afterClass!!!");
  }

}
