package properties;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

public class OwnerTests {
    CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    @Test
    void loginTest() {
        String login = config.login();
        String password = config.password();

        System.out.println(login);
        System.out.println(password);

    }
}
