package org.example.habrtest;

import org.slf4j.Logger;
import io.qameta.allure.Step;
public class AllureLogger {
    private final Logger logger;
    public AllureLogger(Logger logger){
        this.logger = logger;
    }
    @Step("{logText}")
    public void info(String logText) {
        logger.info(logText);
    }
    @Step("{logText}")
    public void infoWithScreenshot(String loginfo){
        logger.info(loginfo);
        AllureAttachmentsManager.screenshot();
    }
    @Step("{logText}")
    public void error(String logText) {
        logger.error(logText);
    }


}
