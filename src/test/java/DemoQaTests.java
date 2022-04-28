import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class DemoQaTests extends TestBase{

    @Test
    @DisplayName("Тест на проверку заполнения формы регистрации")
    void checkFormFilled() {

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
