package practice;

import java.io.IOException;

import org.testng.annotations.Test;

import com.framework.Base;

public class NewTest extends Base {
  @Test
  public void f() throws IOException {
	  driver = initializeBrowser();
	  driver.get("https://www.google.com/");
  }
}
