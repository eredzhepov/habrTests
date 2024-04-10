package org.example.habrtest.pages.MainPage;

import org.example.habrtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import static org.example.habrtest.MyWait.myWait;

public class HabrPasswordRecoveryPage {
    WebDriver driver;
    AllureLogger  LOG = new AllureLogger(LoggerFactory.getLogger(HabrPasswordRecoveryPage.class));
    @FindBy(css = "#reminder_form")
    private WebElement recoveryField;
    public Boolean recoveryFieldIsDisplayed(){
        myWait(5).visible(recoveryField);
        LOG.info("Попап окно восстановление пароля - появилось");
        return recoveryField.isDisplayed();
    }
    @FindBy(css = ".form-additional-message__link:first-child")
    private WebElement enterButton;
    public void comeBackToLoginPage(){
        LOG.info("Нажали на кнопку Войти");
        enterButton.click();
    }
    @FindBy(css = ".form-additional-message__link:last-child")
    private WebElement signUpButton;
    public void signUpButtonClick(){
        LOG.info("Нажали на кнопку регистрации");
        signUpButton.click();
    }
    @FindBy(css = "button[name='go']")
    private WebElement submitButton;
    public Boolean subnitButtonIsDisable() {
        LOG.info("Проверка, что кнопка Отправить - disabled");
        return submitButton.isEnabled();
    }
    @FindBy(css = "input[type='email']")
    private WebElement emailIputField;
    public void setEmailInputField(String yourEmail){
        LOG.info("В поле email введен текст - " + yourEmail);
        emailIputField.sendKeys(yourEmail);
    }
    public HabrPasswordRecoveryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
