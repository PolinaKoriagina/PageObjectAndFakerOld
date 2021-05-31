package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


import java.io.File;
import java.util.Locale;


import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.*;


public class PageObjectAndFaker extends TestBase {

    Faker faker = new Faker(new Locale("pl"));

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            state = "NCR",
            city = "Delhi",
            gender = getRandomGender(),
            month = getRandomMonth(),
            year = getRandomYear(),
            day = getRandomDay(),
            hobby = getRandomHobby();

    File photoOfTheCat = new File("src/test/resources/IMG_4209.jpeg");

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void successfulSubmitForm() {
        open("https://demoqa.com/automation-practice-form");
        //fill the form

        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeUserEmail(email);
        registrationPage.selectUserGender(gender);
        registrationPage.typeUserNumber(phoneNumber);
        registrationPage.setupDateOfBirth(day, month, year);
        registrationPage.selectSubject("Co");
        registrationPage.selectHobby(hobby);
        registrationPage.uploadPicture(photoOfTheCat);
        registrationPage.selectState(state);
        registrationPage.selectCity(city);
        registrationPage.submitForm();

        //check the form
        registrationPage.checkSubmitting();
        registrationPage.checkFirstNameAndLastName((firstName + " " + lastName));
        registrationPage.checkEmail(email);
        registrationPage.checkGender(gender);
        registrationPage.checkPhoneNumber(phoneNumber);
        registrationPage.checkDateOfBirth(day + " " + month + "," + year);
        registrationPage.checkSubject("Computer Science");
        registrationPage.checkHobby(hobby);
        registrationPage.checkImage("IMG_4209.jpeg");
        registrationPage.checkStateAndCity(state + " " + city);

    }

}


