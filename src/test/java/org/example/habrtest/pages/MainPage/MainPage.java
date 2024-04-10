package org.example.habrtest.pages.MainPage;

import org.example.habrtest.AllureLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.example.habrtest.MyWait.myWait;

public class MainPage {
    WebDriver driver;
    AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(MainPage.class));
    @FindBy(xpath = "//a/button[contains(text(), 'Войти')]")
    private WebElement logInButton;
    private static final By LOG_IN_BUTTON = By.xpath("//a/button[contains(text(), 'Войти')]");

    public  void logInClick(){
        logInButton.click();
    }
    private static final By USER_MENU_TOGGLE_BUTTON = By.cssSelector(".tm-header-user-menu__toggle");
    @FindBy(css = ".tm-header-user-menu__toggle")
    private WebElement userMenuToggleButton;
    public void userMenuToggleButtonClick(){
        LOG.info("нажали на кнопку настроек");
        myWait(4).visible(userMenuToggleButton);
        userMenuToggleButton.click();
    }
    @FindBy(css = ".tm-page-settings-form")
    private WebElement popapToggleWindow;
    public Boolean popapToggleWindowIsDisplayed(){
        myWait(5).visible(popapToggleWindow);
        LOG.info("Попап окно с настройками отображается");
        return popapToggleWindow.isDisplayed();
    }
    @FindBy(css = ".tm-page-settings-form .tm-page-settings-form__fieldset:nth-child(2) .tm-fieldset__container .tm-page-settings-form__input-wrapper:last-child")
    private WebElement radioButtonEnglishInterface;
    public void clickRadioButtonEnglishInterface(){
        LOG.info("Выбран английский язык интерфейса");
        radioButtonEnglishInterface.click();
    }
    @FindBy(css = ".tm-page-settings-form__title")
    private WebElement togglePopapWidowSummary;
    public String getTogglePopapWidowSummary(){
        LOG.info("Возвращается заголовок страницы " + togglePopapWidowSummary.getText());
        return togglePopapWidowSummary.getText();
    }
    @FindBy(css = ".btn_solid.btn_large")
    private WebElement saveButton;
    public void saveButtonClick(){
        LOG.info("Нажата кнопка " + saveButton.getText());
        saveButton.click();
    }
    @FindBy(css = ".tm-section-name__text")
    private WebElement myFeedSummary;
    public String getMyFeedSummary(){
        LOG.info("Получить текст " + myFeedSummary.getText() );
        return myFeedSummary.getText();
    }
    @FindBy(css = ".tm-page-settings-form .tm-page-settings-form__fieldset:nth-child(2) .tm-fieldset__container .tm-page-settings-form__input-wrapper:first-child")
    private WebElement radioButtonRussianInterface;
    public void clickRadioButtonRussianInterface(){
        LOG.info("Выбран русский язык интерфейса");
        radioButtonRussianInterface.click();
    }
    @FindBy(css = ".tm-svg-img.tm-header-user-menu__icon.tm-header-user-menu__icon_search.tm-header-user-menu__icon_dark")
    private WebElement searchButton;
    public void searchButtonClick(){
        myWait(4).visible(searchButton);
        LOG.info("Нажать на поиск");
        searchButton.click();
    }
    @FindBy(css = ".tm-input-text-decorated__input")
    private WebElement searchField;
    public void findYourRequest(String yourRequest){
        myWait(5).visible(searchField);
        LOG.info("Ввести в поле поиск " + yourRequest + " и нажать на поиск");
        searchField.sendKeys(yourRequest);
        searchField.submit();
    }
    public String getSearchFieldText(){
        LOG.info("Получить текст из поля ввода");
        return searchField.getAttribute("value");
    }
    @FindBy(css = ".tm-navigation-filters-spoiler__button")
    private WebElement feedProperty;
    public void clickFeedProperty(){
        LOG.info("Нажать на кнопку настрокий ленты");
        feedProperty.click();
    }
    public Boolean feedPropertyIsDisplayed(){
        LOG.info("Отображение окна настроек ленты");
        return feedProperty.isDisplayed();
    }
    @FindBy(css = ".tm-main-menu__section-content a")
    private List<WebElement> listMenu;
    public void clickAllFlows(){
        listMenu.get(1).click();
    }

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
