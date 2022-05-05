package properties;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("testWithProperties")
public class SystemPropertiesTests {

    @Disabled
    @Test
    void checkAnotherBrowserProperties() {
        String propertyBrowser = System.getProperty("propertyBrowser", "chrome");
        String propertyVersion = System.getProperty("propertyVersion", "100");
        String propertyBrowserSize = System.getProperty("propertyBrowserSize", "1920x1080");

        Configuration.browser = propertyBrowser;
        Configuration.browserVersion = propertyVersion;
        Configuration.browserSize = propertyBrowserSize;


        Selenide.open("https://yandex.ru/");
    }

    @Test
    void checkAnotherBrowserSize() {
        String propertyBrowserSize = System.getProperty("propertyBrowserSize", "1920x1080"); // эту переменную нужно менять в терминале
        Configuration.browserSize = propertyBrowserSize;
        Selenide.open("https://yandex.ru/");
    }
}
