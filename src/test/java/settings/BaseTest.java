package settings;


import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.LoggerFactory;
import service.RestSendler;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.openqa.selenium.devtools.v117.network.Network.clearBrowserCache;

public class BaseTest {

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 30000;
        Configuration.headless = false;
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

    public SoftAssertions softAssertions;
    public RestSendler rest;

    @BeforeEach
    public void setUps() {
        softAssertions = new SoftAssertions();
        rest = new RestSendler();
        clearBrowserCache();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @BeforeAll
    public static void changeLogLevel() {
        final Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        logger.setLevel(Level.ERROR);
    }
}

