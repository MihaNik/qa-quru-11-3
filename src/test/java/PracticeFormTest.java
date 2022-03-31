import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void correctSubmitTest() {

        String firstName = "UserFirstname";
        String lastName = "UserLastName";
        String userEmail = "UserEmail@gmail.com";
        String gender = "Female";
        String userNumber = "9527777777";
        String bYear = "1961";
        String bMonth = "April";
        String bDay = "12";
        String[] subjects = {"Maths", "Chemistry", "Accounting", "Social Studies"};
        String subjectResult = String.join(", ", subjects);
        String firstHobby = "Sports";
        String secondHobby = "Reading";
        String picture = "qa_guru.png";
        String currentAddress = "Test currentAddress";
        String state = "Haryana";
        String city = "Karnal";

        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper ").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $$("select.react-datepicker__year-select option").findBy(text(bYear)).click();
        $$("select.react-datepicker__month-select option").findBy(text(bMonth)).click();
        $$("div.react-datepicker__day").findBy(text(bDay)).click();

        for (String subject : subjects) {
            $("#subjectsInput")
                    .setValue(subject)
                    .pressEnter();
        }

        $("#hobbiesWrapper").$(byText(firstHobby)).click();
        $("#hobbiesWrapper").$(byText(secondHobby)).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/" + picture));
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
        $("#submit").click();

        /* asserts */
        $(".table").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table").$(byText("Student Email")).parent().shouldHave(text(userEmail));
        $(".table").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table").$(byText("Mobile")).parent().shouldHave(text(userNumber));
        $(".table").$(byText("Date of Birth")).parent().shouldHave(text(bDay + " " + bMonth + "," + bYear));
        $(".table").$(byText("Subjects")).parent().shouldHave(text(subjectResult));
        $(".table").$(byText("Hobbies")).parent().shouldHave(text(firstHobby + ", " + secondHobby));
        $(".table").$(byText("Picture")).parent().shouldHave(text(picture));
        $(".table").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $(".table").$(byText("State and City")).parent().shouldHave(text(state + " " + city));
    }
}