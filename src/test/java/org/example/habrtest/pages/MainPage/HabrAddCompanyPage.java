package org.example.habrtest.pages.MainPage;

import org.example.habrtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import static org.example.habrtest.MyWait.myWait;

public class HabrAddCompanyPage {
    WebDriver driver;
    AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(HabrAddCompanyPage.class));

    public String getCompanyPageTitle(){
        LOG.info("Получить title на странице добавления компании");
        return driver.getTitle();
    }
    @FindBy(css = ".tm-link.tm-link_down")
    private WebElement tarifPlanSelectinkLink;
    public void clickTarifPlanSelectinkLink(){
        LOG.info("Нажать на кнопку Выбор тарифного плана");
        tarifPlanSelectinkLink.click();
    }
    @FindBy(css = ".tm-links")
    private WebElement pricesBox;
    public Boolean pricesBoxIsdisplayed(){
        myWait(5).visible(pricesBox);
        LOG.info("Появился блок прайсов");
        return pricesBox.isDisplayed();
    }
    @FindBy(xpath = "//a[@class = 'tm-lang']")
    private WebElement chooseEnLanguageLink;
    public void clickChooseEnLanguageLink(){
        LOG.info("Нажать на кнопку смены языка на английский");
        chooseEnLanguageLink.click();
    }
    @FindBy(xpath = "//a[contains(text(),'Контакты')]")
    private WebElement contactUsLink;
    public void clickContactUsLink(){
        LOG.info("Нажать на кнопку Contact Us");
        contactUsLink.click();
    }
    @FindBy(css = "#contacts")
    private WebElement contactsBox;
    public Boolean contactsBoxtsIsDisplay(){
        myWait(5).visible(contactsBox);
        LOG.info("Блок с информацие отобразился");
        return contactsBox.isDisplayed();
    }

    public HabrAddCompanyPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
