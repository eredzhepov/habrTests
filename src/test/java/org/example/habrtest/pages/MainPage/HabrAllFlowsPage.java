package org.example.habrtest.pages.MainPage;

import org.example.habrtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.example.habrtest.MyWait.myWait;

public class HabrAllFlowsPage {
    WebDriver driver;
    AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(HabrAllFlowsPage.class));
    @FindBy(css = ".tm-section-name__text")
    private WebElement allFlowsSummary;
    public Boolean flowsSummaryIsDisplayed(){
        LOG.info("Отображение заголовка на странице с потоками");
        return allFlowsSummary.isDisplayed();
    }
    @FindBy(css = ".tm-tabs__tab-link.tm-tabs__tab-link")
    private List<WebElement> menuElements;
    @FindBy(css = ".tm-tabs__tab-link.tm-tabs__tab-link")
    private List<WebElement> allFlowsMenuList;
    public int getMenuPunctsAmount(){
        LOG.info("Вывести количество пунктов меню на странице Все потоки");
        return allFlowsMenuList.size();
    }
    public List<WebElement> getAllFlowsMenuList(){
        LOG.info("Возратить весь список меню");
        return allFlowsMenuList;
    }
    public void elementFlowsMenuClick(int i){
        myWait(5).visible(getAllFlowsMenuList().get(i - 1));
        LOG.info("Нажать на " + i + " - й пункт меню " + getAllFlowsMenuList().get(i - 1).getText());
        getAllFlowsMenuList().get(i - 1).click();
    }
    @FindBy(css = ".tm-suggest-button")
    private WebElement addCompanyButton;
    public void clickAddCompanyButton(){
        myWait(5).visible(addCompanyButton);
        LOG.info("Нажать кнопку Добавить компанию");
        addCompanyButton.click();
    }

    public HabrAllFlowsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

}
