package tests;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
public class TestStudentRegistrationForm extends TestBase {
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
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)")
                .findBy(text("3"))
                .click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").find(byText("Music")).click();
        //$("#uploadPicture").sendKeys(new File("src/test/resources/testbest.png").getAbsolutePath());
        $("#uploadPicture").uploadFromClasspath("testbest.png");
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
        $("#submit").click();
    }

    @Test
    void negativeTestWhenFirstNameIsEmpty() {
        open("/automation-practice-form");
        $("#lastName").setValue("Black");
        $("#userEmail").setValue("elena@black.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9876543210");
        $("#submit").scrollTo();
        $("#submit").click();
    }
    @Test
    void negativeTestWhenLastNameIsEmpty() {
        open("/automation-practice-form");
        $("#firstName").setValue("Elena");
        $("#userEmail").setValue("elena@black.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9876543210");
        $("#submit").scrollTo();
        $("#submit").click();
    }

    @Test
    void negativeTestWhenGenterIsEmpty() {
        open("/automation-practice-form");
        $("#firstName").setValue("Elena");
        $("#lastName").setValue("Black");
        $("#userEmail").setValue("elena@black.com");
        $("#userNumber").setValue("9876543210");
        $("#submit").scrollTo();
        $("#submit").click();
    }
}
