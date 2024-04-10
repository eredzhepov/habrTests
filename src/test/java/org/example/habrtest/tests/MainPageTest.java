package org.example.habrtest.tests;

import org.example.habrtest.MyExtension;
import org.example.habrtest.pages.MainPage.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MyExtension.class)
public class MainPageTest extends BaseTest {
    private MainPage mainPage;
    private LogInPage logInPage;
    private HabrSignUpPage habrSignUpPage;
    private HabrPasswordRecoveryPage habrPasswordRecoveryPage;
    private HabrAllFlowsPage habrAllFlowsPage;
    private  HabrAddCompanyPage habrAddCompanyPage;

    @BeforeEach
    @Override
    public void setUp() throws Exception {
        super.setUp();
        getDriver().get("https://habr.com/ru/feed/");
        mainPage = new MainPage(getDriver());
        logInPage = new LogInPage(getDriver());
        habrPasswordRecoveryPage = new HabrPasswordRecoveryPage(getDriver());
        habrSignUpPage = new HabrSignUpPage(getDriver());
        habrAllFlowsPage = new HabrAllFlowsPage(getDriver());
        habrAddCompanyPage = new HabrAddCompanyPage(getDriver());
    }

    @Test
    @Tag("1")
    @DisplayName("Тестирование кнопки Войти")
    public void shapowBoxFind() {
        mainPage.logInClick();
        assertTrue(logInPage.shadowBoxIsVisible(), "Окно логина не отобразилось");
    }

    @Test
    @Tag("2")
    @DisplayName("Тестирование появления окна Восстановления пароля")
    public void passwordRecoveryWindowIsDisplayed() {
        mainPage.logInClick();
        logInPage.clickForgotPasswordButton();
        assertTrue(habrPasswordRecoveryPage.recoveryFieldIsDisplayed(), "Попап окно Востановление пароля не появилось");
    }

    @Test
    @Tag("3")
    @DisplayName("Возврат с поля восстановления пароля на поля логина")
    public void comeBackToLogInPage() {
        mainPage.logInClick();
        logInPage.clickForgotPasswordButton();
        habrPasswordRecoveryPage.comeBackToLoginPage();
        assertTrue(logInPage.shadowBoxIsVisible(), "Окно логина не отобразилось");
    }

    @Test
    @Tag("3")
    @DisplayName("Переход в окно регистрации с попап окна Восстановление пароля")
    public void goToSignUpFromRecoveryPassswordWindow() {
        String actualTitle = "Регистрация";
        mainPage.logInClick();
        logInPage.clickForgotPasswordButton();
        habrPasswordRecoveryPage.signUpButtonClick();
        assertEquals(actualTitle, habrSignUpPage.getSignUpShadowBoxTitle(), "Заголовок на странице регистрации не совпадает");
    }

    @Test
    @Tag("4")
    @DisplayName("Восстановление пароля, кнопка Отправить не активна")
    public void recoveryPageSendButtonIsDisabled() {
        mainPage.logInClick();
        logInPage.clickForgotPasswordButton();
        assertFalse(habrPasswordRecoveryPage.subnitButtonIsDisable(), "Кнопка Отправить активна");

    }

//    @Test
//    @Tag("5")
//    @DisplayName("Восстановление пароля, кнопка Отправить активна если в инпут ввести любой текст")
//    public void recoveryPageSendButtonIsEnable() {
//        String yourEmail = "usertestovich@mail.ru";
//        mainPage.logInClick();
//        logInPage.clickForgotPasswordButton();
//        habrPasswordRecoveryPage.setEmailInputField(yourEmail);
//        assertTrue(habrPasswordRecoveryPage.subnitButtonIsDisable(), "Кнопка Отправить не активна");
//
//    }
//
//    @Test
//    @Tag("6")
//    @DisplayName("Регистрация, кнопка Зарегестрировать  не активна если в инпутgens не заполнены")
//    public void signUpButtonIsDisabled() {
//        mainPage.logInClick();
//        logInPage.clickForgotPasswordButton();
//        habrPasswordRecoveryPage.signUpButtonClick();
//        assertFalse(habrSignUpPage.registrationButtonIsDisabled(), "Кнопка Зарегестрироваться активна");
//    }
//
//    @Test
//    @Tag("7")
//    @DisplayName("Регистрация, кнопка Зарегестрировать   активна если все инпуты заполнены")
//    public void signUpButtonIsEnable() {
//        String yourEmail = "usertestovich@mail.ru";
//        String yourNick = "monk";
//        String yourPassword = "12345678";
//        mainPage.logInClick();
//        logInPage.clickForgotPasswordButton();
//        habrPasswordRecoveryPage.signUpButtonClick();
//        habrSignUpPage.setEmailInputField(yourEmail);
//        habrSignUpPage.setNickInputField(yourNick);
//        habrSignUpPage.setPasswordInputField(yourPassword);
//        habrSignUpPage.setPasswordRepeatInputField(yourPassword);
//        assertTrue(habrSignUpPage.registrationButtonIsDisabled(), "Кнопка Зарегестрироваться не активна");
//    }
//
//    @Test
//    @Tag("8")
//    @DisplayName("Появление Попап окна с настройками страницы ")
//    public void totgglePopapWindowArize() {
//        mainPage.userMenuToggleButtonClick();
//        assertTrue(mainPage.popapToggleWindowIsDisplayed(), "Попап окно с настройками не появилось");
//    }
//
//    @Test
//    @Tag("9")
//    @DisplayName("Смена языка интерфейса")
//    public void switchInterfaceLanguage() {
//        String expectedlChangedToggleSummary = "Page settings";
//        mainPage.userMenuToggleButtonClick();
//        mainPage.clickRadioButtonEnglishInterface();
//        assertEquals(expectedlChangedToggleSummary, mainPage.getTogglePopapWidowSummary(), "Заголовок интерфейса не соответствует");
//    }
//
//    @Test
//    @Tag("10")
//    @DisplayName("Сохранение изменений языка интерфейса")
//    public void changeInterfaceLanguage() {
//        String expectedlMyFeedSummary = "My feed";
//        mainPage.userMenuToggleButtonClick();
//        mainPage.clickRadioButtonEnglishInterface();
//        mainPage.saveButtonClick();
//        assertEquals(expectedlMyFeedSummary, mainPage.getMyFeedSummary(), "Заголовок на странице не соответствует, язык не изменен");
//    }
//
//    @Test
//    @Tag("11")
//    @DisplayName("Возвращение текущих настроек - изменений языка интерфейса")
//    public void changeInterfaceLanguage1() {
//        String expectedlMyFeedSummary = "Моя лента";
//        mainPage.userMenuToggleButtonClick();
//        mainPage.clickRadioButtonRussianInterface();
//        mainPage.saveButtonClick();
//        assertEquals(expectedlMyFeedSummary, mainPage.getMyFeedSummary(), "Заголовок на странице не соответствует, язык не изменен");
//    }
//
//    @Test
//    @Tag("12")
//    @DisplayName("При помощи поиска, ввести  и отправить запрос")
//    public void findRequst() {
//        String yourRequest = "Reforge";
//        mainPage.searchButtonClick();
//        mainPage.findYourRequest(yourRequest);
//        assertEquals(yourRequest, mainPage.getSearchFieldText(), "Тест в поле поиска не соответствует");
//    }
//
//    @Test
//    @Tag("13")
//    @DisplayName("Раскрытие настроек ленты")
//    public void openFeedProperty() {
//        mainPage.clickFeedProperty();
//        assertTrue(mainPage.feedPropertyIsDisplayed(), "Окно с настройками не отобразились");
//    }
//
//    @Test
//    @Tag("14")
//    @DisplayName("Раскрытие настроек ленты")
//    public void flowsSuammaryDisplay() {
//        mainPage.clickAllFlows();
//        assertTrue(habrAllFlowsPage.flowsSummaryIsDisplayed(), "Заголовок на странице с потоками не отобразился");
//    }
//    @Test
//    @Tag("15")
//    @DisplayName("Все 6 пунктов меню на вкладке все потоки")
//    public void allMenuItemsAtTheAllflowsPage() {
//        int expectedAmount = 6;
//        mainPage.clickAllFlows();
//        assertEquals(expectedAmount, habrAllFlowsPage.getMenuPunctsAmount(), "Количество пунктов меню не совпадает");
//    }
//    @Test
//    @Tag("16")
//    @DisplayName("Соответствие всех пунктов меню ")
//    public void equalityAllMenuItemsAtTheAllflowsPage() {
//        String[] expectedMenuPunctsArr = {"Статьи", "Посты", "Новости", "Хабы", "Авторы", "Компании"};
//        int amount = habrAllFlowsPage.getAllFlowsMenuList().size();
//        List<WebElement> actualMenuPunct = habrAllFlowsPage.getAllFlowsMenuList();
//        String[] actualMenuPuncts = {};
//        for(int i = 0; i < amount; i++){
//            actualMenuPuncts[i] = actualMenuPunct.get(i).getText();
//        }
//        mainPage.clickAllFlows();
//        for(int i = 0; i < amount; i++){
//            assertEquals(expectedMenuPunctsArr[i],  actualMenuPuncts[i], "Пункты меню не совпадают");
//        }
//    }
//
//    @Test
//    @Tag("17")
//    @DisplayName("Переход на страницу добавления компании")
//    public void addCompanyTitle(){
//        String expectedTitle = "Хабр — корпоративные блоги";
//        mainPage.clickAllFlows();
//        habrAllFlowsPage.elementFlowsMenuClick(6);
//        habrAllFlowsPage.clickAddCompanyButton();
//        assertEquals(expectedTitle, habrAddCompanyPage.getCompanyPageTitle(), "Title на странице не соответствует");
//    }
//    @Test
//    @Tag("18")
//    @DisplayName("Развернуть тарифный план")
//    public void tarifPlanExpand(){
//        mainPage.clickAllFlows();
//        habrAllFlowsPage.elementFlowsMenuClick(6);
//        habrAllFlowsPage.clickAddCompanyButton();
//        assertTrue(habrAddCompanyPage.pricesBoxIsdisplayed(), "Блок с прайсом не появился");
//    }
//    @Test
//    @Tag("19")
//    @DisplayName("Развернуть тарифный план")
//    public void switchLanguageToEnglish(){
//        String expectedTitle = "Habr — corporate blogs";
//        mainPage.clickAllFlows();
//        habrAllFlowsPage.elementFlowsMenuClick(6);
//        habrAllFlowsPage.clickAddCompanyButton();
//        habrAddCompanyPage.clickChooseEnLanguageLink();
//        assertEquals(expectedTitle, habrAddCompanyPage.getCompanyPageTitle(), "Title на странице не соответствует");
//    }
//    @Test
//    @Tag("20")
//    @DisplayName("Отображение блока с контактами ")
//    public void contactBlockDisplayed(){
//        mainPage.clickAllFlows();
//        habrAllFlowsPage.elementFlowsMenuClick(6);
//        habrAllFlowsPage.clickAddCompanyButton();
//        habrAddCompanyPage.clickContactUsLink();
//        assertTrue(habrAddCompanyPage.contactsBoxtsIsDisplay(), "Блок с контактами не появился");
//    }
//


}
