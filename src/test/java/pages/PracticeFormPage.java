package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.DropDownWithSearchComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {
    CalendarComponent birthdayCalendar = new CalendarComponent();
    DropDownWithSearchComponent subjectDropDown = new DropDownWithSearchComponent();

    final private SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            currentAddressInput = $("#currentAddress"),
            uploadPicture = $("#uploadPicture"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit"),
            resultsTable = $(".table-responsive");

    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Student Registration Form"));

        return this;
    }

    public PracticeFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public PracticeFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public PracticeFormPage setEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public PracticeFormPage setGender(String gender) {
        genderInput.$(byText(gender)).click();
        return this;
    }

    public PracticeFormPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public PracticeFormPage setBirthday(String year, String month, String day) {
        dateOfBirthInput.click();
        birthdayCalendar.setDate(year, month, day);
        return this;
    }

    public PracticeFormPage setSubjects(String[] subjects) {
        subjectDropDown.setItemsList(subjects, subjectInput);

        return this;
    }

    public PracticeFormPage setHobby(String hobby) {
        hobbiesInput.$(byText(hobby)).click();
        return this;
    }

    public PracticeFormPage uploadPicture(String picture) {
        uploadPicture.uploadFile(new File("src/test/resources/" + picture));
        return this;
    }

    public PracticeFormPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public PracticeFormPage setStateAndCity(String state, String city) {
        stateInput.click();
        stateInput.$(byText(state)).click();
        cityInput.click();
        cityInput.$(byText(city)).click();
        return this;
    }

    public PracticeFormPage submit() {
        submitButton.click();
        return this;
    }

    public PracticeFormPage checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));
        return this;
    }

}
