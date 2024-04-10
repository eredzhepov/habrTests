package org.example.habrtest.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseTest {
    private static WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "123.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to add test badge */
            put("name", "Test badge...");

            /* How to set session timeout */
            put("sessionTimeout", "15m");
            put("enableVNC", true);
            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to add "trash" button */
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});

            /* How to enable video recording */
            put("enableVideo", true);
        }});

        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public static WebDriver getDriver() {
        return  driver;
    }
    @AfterEach
    public void tearDown(){
        driver.close();
    }
}