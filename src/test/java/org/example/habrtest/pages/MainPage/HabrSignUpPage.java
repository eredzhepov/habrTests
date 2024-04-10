package org.example.habrtest.pages.MainPage;

import org.example.habrtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class HabrSignUpPage {
    WebDriver driver;
    AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(HabrSignUpPage.class));
    @FindBy(css = ".shadow-box__title")
    private WebElement signUpShadowBoxTitle;
    public String getSignUpShadowBoxTitle(){
        LOG.info("Получить заголовок окна регистрации");
        return  signUpShadowBoxTitle.getText();
    }
    @FindBy(css = "#registration_button")
    private WebElement registrationButton;
    public Boolean registrationButtonIsDisabled(){
        return registrationButton.isEnabled();
    }
    @FindBy(css = "input[type = 'email']")
    private WebElement emailInputField;
    public void setEmailInputField(String emailText){
        LOG.info("В поле с email введен текст - " + emailText);
        emailInputField.sendKeys(emailText);
    }
    @FindBy(css = "#nickname_field")
    private WebElement nickInputField;
    public void setNickInputField(String nickText){
        LOG.info("В поле с ником введен текст - " + nickText);
        nickInputField.sendKeys(nickText);
    }
    @FindBy(css = "#password_field")
    private WebElement passwordInputField;
    public void setPasswordInputField(String password){
        LOG.info("В поле пароль введен текст - " + password);
        passwordInputField.sendKeys(password);
    }
    @FindBy(css = "#password_repeat")
    private WebElement passwordRepeatInputField;
    public void setPasswordRepeatInputField(String password){
        LOG.info("В поле повтора пароля введен текст - " + password);
        passwordRepeatInputField.sendKeys(password);
    }
    public HabrSignUpPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
