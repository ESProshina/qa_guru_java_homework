package tests;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
public class TestStudentRegistrationForm extends TestBase {
    private final String firstName = "Elena";
    private final String lastName = "Black";
    private final String email = "elena@black.com";
    private final String gender = "Female";
    private final String mobileNumber = "9876543210";
    private final String year = "2000";
    private final String month = "June";
    private final String day = "3";
    private final String subject = "English";
    private final String hobby = "Music";
    private final String address = "Test Address 123";
    private final String state = "NCR";
    private final String city = "Delhi";
    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").find(byText(gender)).click();
        $("#userNumber").setValue(mobileNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)")
                .findBy(text(day))
                .click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").find(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath("testbest.png");
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#state").parent().find(byText(state)).click();
        $("#city").click();
        $("#city").parent().find(byText(city)).click();
        $("#submit").click();
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Student Name"));
        $(".table-responsive").shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").shouldHave(text("Student Email"));
        $(".table-responsive").shouldHave(text(email));
        $(".table-responsive").shouldHave(text("Gender"));
        $(".table-responsive").shouldHave(text(gender));
        $(".table-responsive").shouldHave(text("Mobile"));
        $(".table-responsive").shouldHave(text(mobileNumber));
        $(".table-responsive").shouldHave(text("Date of Birth"));
        $(".table-responsive").shouldHave(text(day + " " + month + "," + year));
        $(".table-responsive").shouldHave(text("Subjects"));
        $(".table-responsive").shouldHave(text(subject));
        $(".table-responsive").shouldHave(text("Hobbies"));
        $(".table-responsive").shouldHave(text(hobby));
        $(".table-responsive").shouldHave(text("Picture"));
        $(".table-responsive").shouldHave(text("testbest.png"));
        $(".table-responsive").shouldHave(text("Address"));
        $(".table-responsive").shouldHave(text(address));
        $(".table-responsive").shouldHave(text("State and City"));
        $(".table-responsive").shouldHave(text(state + " " + city));
        $("#closeLargeModal").click();
    }
    @Test
    void successfulMandatoryFieldsTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").find(byText(gender)).click();
        $("#userNumber").setValue(mobileNumber);
        $("#submit").click();
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Student Name"));
        $(".table-responsive").shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").shouldHave(text("Student Email"));
        $(".table-responsive").shouldHave(text(email));
        $(".table-responsive").shouldHave(text("Gender"));
        $(".table-responsive").shouldHave(text(gender));
        $(".table-responsive").shouldHave(text("Mobile"));
        $(".table-responsive").shouldHave(text(mobileNumber));
        $("#closeLargeModal").click();
    }
    @Test
    void negativeTestWhenFirstNameIsEmpty() {
        open("/automation-practice-form");
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").find(byText(gender)).click();
        $("#userNumber").setValue(mobileNumber);
        $("#submit").scrollTo();
        $("#submit").click();
        $(".modal-title").shouldNotBe(visible);
        SelenideElement firstNameField = $("#firstName");
        firstNameField.shouldHave(attribute("required"));
        boolean isValid = executeJavaScript("return arguments[0].checkValidity();", firstNameField);
        assert !isValid : "Field should be invalid when empty";
    }
    @Test
    void negativeTestWhenLastNameIsEmpty() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").find(byText(gender)).click();
        $("#userNumber").setValue(mobileNumber);
        $("#submit").scrollTo();
        $("#submit").click();
        $(".modal-title").shouldNotBe(visible);
        SelenideElement lastNameField = $("#lastName");
        lastNameField.shouldHave(attribute("required"));
        boolean isValid = executeJavaScript("return arguments[0].checkValidity();", lastNameField);
        assert !isValid : "Field should be invalid when empty";
    }
    @Test
    void negativeTestWhenMobileIsEmpty() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").find(byText(gender)).click();
        $("#submit").scrollTo();
        $("#submit").click();
        $(".modal-title").shouldNotBe(visible);
        SelenideElement mobileField = $("#userNumber");
        mobileField.shouldHave(attribute("required"));
        boolean isValid = executeJavaScript("return arguments[0].checkValidity();", mobileField);
        assert !isValid : "Field should be invalid when empty";
    }
    @Test
    void negativeTestWhenGenderIsEmpty() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#userNumber").setValue(mobileNumber);
        $("#submit").scrollTo();
        $("#submit").click();
        $(".modal-title").shouldNotBe(visible);
        $("#gender-radio-1").shouldNotBe(checked);
        $("#gender-radio-2").shouldNotBe(checked);
        $("#gender-radio-3").shouldNotBe(checked);
        boolean isFormValid = executeJavaScript("return document.querySelector('form').checkValidity();");
        assert !isFormValid : "Form should be invalid when gender not selected";
    }
}

