package demoTest;

import org.testng.annotations.Test;

import challenge.mmt.Browser.Driver;
import challenge2.mmt.WebPages.HomePage;

public class NewTest {
  @Test
  public void f() throws InterruptedException {
	  Driver.initialize();
	  new HomePage().Search();
	  
  }
}
