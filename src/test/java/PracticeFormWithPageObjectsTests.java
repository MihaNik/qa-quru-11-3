import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

public class PracticeFormWithPageObjectsTests {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

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


        practiceFormPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthday(bYear, bMonth, bDay)
                .setSubjects(subjects)
                .setHobby(firstHobby)
                .setHobby(secondHobby)
                .uploadPicture(picture)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .submit()
        ;

        /* asserts */
        practiceFormPage
                .checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", userEmail)
                .checkForm("Gender", gender)
                .checkForm("Mobile", userNumber)
                .checkForm("Date of Birth", bDay + " " + bMonth + "," + bYear)
                .checkForm("Subjects", subjectResult)
                .checkForm("Hobbies", firstHobby + ", " + secondHobby)
                .checkForm("Picture", picture)
                .checkForm("Address", currentAddress)
                .checkForm("State and City", state + " " + city);

    }


}
