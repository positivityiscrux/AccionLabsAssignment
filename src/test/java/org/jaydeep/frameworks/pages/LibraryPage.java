package org.jaydeep.frameworks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Sample page
 */
public class LibraryPage extends Page {

  @FindBy(how = How.ID, using = "practiceTestLink")
  @CacheLookup
  public List<WebElement> tests;

  public LibraryPage(WebDriver webDriver) {
    super(webDriver);
  }

  public Boolean startTest(String testName) {
    waitForPage(By.className("libraryHeader"));
    for (WebElement test: tests
         ) {
      if(test.getText().contains(testName)) {
        test.click();
        return true;
      }
    }
    return false;
  }

}
