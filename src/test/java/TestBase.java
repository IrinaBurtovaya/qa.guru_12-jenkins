import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    static String selenoid = System.getProperty("selenoid", "selenoid.autotests.cloud/wd/hub");

    @BeforeAll
    public static void openPage() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://" + config.login() + ":" + config.password() + "@" + selenoid;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
        Selenide.closeWebDriver();
    }
}
