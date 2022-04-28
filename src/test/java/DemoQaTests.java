import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class DemoQaTests {
    @BeforeAll
    public static void openPage() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Selenide.open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void checkFormFilled() {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(); //не нужно создавать метод main,
        // т.к. аннотация @Test позволяет создавать объекты другого класса внутри себя.

        registrationFormPage.setFirstName()
                .setLastName()
                .setEmail()
                .setGender("Male")
                .setPhoneNumber()
                .setDateOfBirth(7, "1990", "05")
                .setSubject("Maths")
                .setHobbies("Music")
                .uploadFile()
                .setStateAndCity()
                .checkResults();
    }
}
