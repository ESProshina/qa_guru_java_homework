package tests;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
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
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)")
                .findBy(text("3"))
                .click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").find(byText("Music")).click();
        $("#currentAddress").setValue("Test Address 123");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $("#closeLargeModal").click();
    }
}
