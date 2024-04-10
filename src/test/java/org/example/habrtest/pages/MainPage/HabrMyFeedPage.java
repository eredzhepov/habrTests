package org.example.habrtest.pages.MainPage;

import org.example.habrtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class HabrMyFeedPage {
    WebDriver driver;
    AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(HabrMyFeedPage.class));
    @FindBy(css = ".tm-section-name__text")
    private WebElement myFeedSummary;
    public Boolean myFeedSummaryIsDisplayed(){
        LOG.info("Проверка отображения заголовка");
        return myFeedSummary.isDisplayed();
    }
    public HabrMyFeedPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
