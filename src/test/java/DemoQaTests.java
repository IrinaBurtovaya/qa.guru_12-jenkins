import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class DemoQaTests {
    @BeforeAll
    public static void openPage() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    @DisplayName("Тест на проверку заполнения формы регистрации")
    void checkFormFilled() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        RegistrationFormPage registrationFormPage = new RegistrationFormPage(); //не нужно создавать метод main,
        // т.к. аннотация @Test позволяет создавать объекты другого класса внутри себя.
        executeJavaScript("$('footer').remove()");// Отключает футер.
        executeJavaScript("$('#fixedban').remove()");// Отключает рекламу.

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
