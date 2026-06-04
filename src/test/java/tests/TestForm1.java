package tests;
import org.junit.jupiter.api.Test;

import java.io.File;
//import java.net.URL;
//import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
//import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
public class TestForm1 extends TestBase {
    @Test
    void successfulFillFormTest() {

        open("/automation-practice-form");
        $("#firstName").setValue("Elena");
        $("#lastName").setValue("Black");
        $("#userEmail").setValue("elena@black.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9876543210");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("2000");
        //$(".react-datepicker__day-003").click;
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)")
                .findBy(text("3"))
                .click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").find(byText("Music")).click();
        //$(byId("uploadPicture")).uploadFromClasspath("screentest.png");
        $("#uploadPicture").sendKeys(new File("src/test/resources/testbest.png").getAbsolutePath());
        $("#currentAddress").setValue("Test Address 123");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $("#closeLargeModal").click();
    }

    @Test
    void successfulMandatoryFieldsTest() {

        open("/automation-practice-form");
        $("#firstName").setValue("Elena");
        $("#lastName").setValue("Black");
        $("#userEmail").setValue("elena@black.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9876543210");
    }

    @Test
    void negativeTestWhenFirstNameIsEmpty() {
        open("/automation-practice-form");        // Заполняем все поля, кроме First Name
        // $("#firstName").setValue("Elena"); // Пропускаем заполнение
        $("#lastName").setValue("Black");
        $("#userEmail").setValue("elena@black.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9876543210");        // Прокручиваем страницу до кнопки Submit
        $("#submit").scrollTo();        // Нажимаем кнопку Submit
        $("#submit").click();        // Ожидаемый результат: форма НЕ отправляется

    }

    @Test
    void negativeTestWhenLastNameIsEmpty() {
        open("/automation-practice-form");        // Заполняем все поля, кроме First Name
        $("#firstName").setValue("Elena"); // Пропускаем заполнение
        //$("#lastName").setValue("Black");
        $("#userEmail").setValue("elena@black.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9876543210");        // Прокручиваем страницу до кнопки Submit
        $("#submit").scrollTo();        // Нажимаем кнопку Submit
        $("#submit").click();        // Ожидаемый результат: форма НЕ отправляется

    }

    @Test
    void negativeTestWhenGenterIsEmpty() {
        open("/automation-practice-form");        // Заполняем все поля, кроме First Name
        $("#firstName").setValue("Elena"); // Пропускаем заполнение
        $("#lastName").setValue("Black");
        $("#userEmail").setValue("elena@black.com");
        //$("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9876543210");        // Прокручиваем страницу до кнопки Submit
        $("#submit").scrollTo();        // Нажимаем кнопку Submit
        $("#submit").click();        // Ожидаемый результат: форма НЕ отправляется

    }

}
