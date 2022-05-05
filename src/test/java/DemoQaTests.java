import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class DemoQaTests extends TestBase {

    @Test
    @DisplayName("Тест на проверку заполнения формы регистрации")
    void checkFormFilled() {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage(); //не нужно создавать метод main,
        // т.к. аннотация @Test позволяет создавать объекты другого класса внутри себя.

        step("Открываем страницу для тестирования", () -> {
            open("https://demoqa.com/automation-practice-form");
            executeJavaScript("$('footer').remove()");// Отключает футер.
            executeJavaScript("$('#fixedban').remove()");// Отключает рекламу.
        });

        step("Заполняем форму регистрации", () -> {
            registrationFormPage.setFirstName()
                    .setLastName()
                    .setEmail()
                    .setGender("Male")
                    .setPhoneNumber()
                    .setDateOfBirth(7, "1990", "05")
                    .setSubject("Maths")
                    .setHobbies("Music")
                    .uploadFile()
                    .setStateAndCity();
        });

        step("Проверяем результаты теста", () -> {
            registrationFormPage.checkResults();
        });
    }
}
