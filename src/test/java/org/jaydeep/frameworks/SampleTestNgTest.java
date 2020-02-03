package org.jaydeep.frameworks;

import org.jaydeep.frameworks.pages.BeginTestPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.jaydeep.frameworks.pages.LibraryPage;

import java.util.concurrent.TimeUnit;

public class SampleTestNgTest extends TestNgTestBase {

  private LibraryPage homepage;
  private BeginTestPage beginTestPage;

  @BeforeMethod
  public void initPageObjects() {
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      homepage = PageFactory.initElements(driver, LibraryPage.class);
      beginTestPage = PageFactory.initElements(driver,BeginTestPage.class);
  }

  @Test(priority = 0)
    public void testScript() {
        driver.get(baseUrl);
        homepage.startTest("The Official LSAT PrepTest 71");
        beginTestPage.setTestName("The Official LSAT PrepTest 71");
        beginTestPage.beginTestPageVisible();
        beginTestPage.beginSection("Section 1");


    }
}
