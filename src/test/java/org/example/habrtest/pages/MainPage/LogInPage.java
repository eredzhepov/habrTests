package org.example.habrtest.pages.MainPage;

import org.example.habrtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class LogInPage {
    WebDriver driver;
    @FindBy(css = ".shadow-box")
    private WebElement shadowBox;
    AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(LogInPage.class));
    public Boolean shadowBoxIsVisible(){
        LOG.info("Попап окно логина - отображается");
        return shadowBox.isDisplayed();
    }


    @FindBy(css = ".form__remind-password-link")
    private WebElement forgotPasswordButton;
    public void clickForgotPasswordButton(){
        LOG.info("Нажата кнопка Забыли пароль?");
        forgotPasswordButton.click();
    }

    public LogInPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
