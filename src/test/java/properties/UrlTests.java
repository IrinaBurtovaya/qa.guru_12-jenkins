package properties;

import com.codeborne.selenide.Configuration;
import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

@Tag("url")
public class UrlTests {
    CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    @Test
    void UrlTest() {
        String login = config.login();
        String password = config.password();
        String selenoid = System.getProperty("selenoid", "selenoid.autotests.cloud/wd/hub");

        System.out.println(login);
        System.out.println(password);
        System.out.println(selenoid);

        System.out.println("https://" + config.login() + ":" + config.password() + "@" + selenoid);

    }
}
