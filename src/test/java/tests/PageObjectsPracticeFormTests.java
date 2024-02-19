package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class PageObjectsPracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void fullRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.birthDay, testData.birthMonth, testData.birthYear)
                .setSubjectsInput(testData.subject)
                .setHobbiesWrapperInput(testData.hobby)
                .setUploadPictureInput(testData.picture)
                .setCurrentAddress(testData.address)
                .setStateWrapper(testData.state)
                .setCityWrapper(testData.city)
                .submit();

        registrationPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.birthDay + " " + testData.birthMonth + "," + testData.birthYear)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobby)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.address)
                .checkResult("State and City", testData.city);
    }


    @Test
    void minimalRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .submit();

        registrationPage.checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber);

    }

    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .submit();

        registrationPage.noResult();


    }
}


