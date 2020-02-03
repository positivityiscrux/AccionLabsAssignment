package org.jaydeep.frameworks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class BeginTestPage extends Page {

    String testName;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'sectionItem')]/button")
    @CacheLookup
    public List<WebElement> sections;

    public BeginTestPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public void beginTestPageVisible(){
        waitForPage(By.id("masterPage."+testName));
        System.out.println("it is executing till end");
    }

    public void beginSection(String sectionName){

        for (WebElement s:sections
             ) {
            if(s.getText().contains(sectionName))
            {
                s.click();
                return;
            }
        }
        System.out.println("section name does not exists on screen");
    }



}
