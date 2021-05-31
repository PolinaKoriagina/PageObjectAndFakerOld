package pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {


    private String dayValue = ".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)",
            hobbyPicker = "//label[contains(text(),'%s')]";
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            dobInput = $("#dateOfBirthInput"),
            monthPicker = $(".react-datepicker__month-select"),
            yearPicker = $(".react-datepicker__year-select"),
            subjectInput = $("#subjectsInput"),
            pictureUploadButton = $("#uploadPicture"),
            statePicker = $(byText("Select State")),
            cityPicker = $(byText("Select City")),
            submitButton = $("[id=\"submit\"]"),
            thanksForSubmitText = $("[id=\"example-modal-sizes-title-lg\"]"),
            firstNameAndLastNameCell = $(byXpath("//table/tbody/tr[1]/td[2]")),
            emailCell = $(byXpath("//table/tbody/tr[2]/td[2]")),
            genderCell = $(byXpath("//table/tbody/tr[3]/td[2]")),
            phoneNumberCell = $(byXpath("//table/tbody/tr[4]/td[2]")),
            dateOfBirthCell = $(byXpath("//table/tbody/tr[5]/td[2]")),
            subjectCell = $(byXpath("//table/tbody/tr[6]/td[2]")),
            hobbyCell = $(byXpath("//table/tbody/tr[7]/td[2]")),
            imageCell = $(byXpath("//table/tbody/tr[8]/td[2]")),
            stateAndCityCell = $(byXpath("//table/tbody/tr[10]/td[2]"));

    //input

    public void typeFirstName(String value) {
        firstNameInput.val(value);
    }

    public void typeLastName(String value) {
        lastNameInput.val(value);
    }

    public void typeUserEmail(String value) {
        emailInput.val(value);
    }

    public void selectUserGender(String value) {
        $(byText(value)).click();
    }

    public void typeUserNumber(String value) {
        numberInput.val(value);
    }

    public void setupDateOfBirth(String day, String month, String year) {
        dobInput.click();
        monthPicker.selectOption(month);
        yearPicker.selectOption(year);
        $(String.format(dayValue, day)).click();
    }

    public void selectSubject(String value) {
        subjectInput.val(value).pressEnter();
    }

    public void selectHobby(String hobby) {
        $(byXpath(String.format(hobbyPicker, hobby))).click();
    }

    public void uploadPicture(File picture) {
        pictureUploadButton.uploadFile(picture);
    }

    public void selectState(String value) {
        statePicker.scrollTo().click();
        $(byText(value)).click();

    }

    public void selectCity(String value) {
        cityPicker.click();
        $(byText(value)).click();

    }

    public void submitForm() {
        submitButton.click();
    }
    //checking

    public void checkSubmitting() {
        thanksForSubmitText.shouldHave(exactText("Thanks for submitting the form"));
    }

    public void checkFirstNameAndLastName(String value) {
        firstNameAndLastNameCell.shouldHave(text(value));
    }

    public void checkEmail(String value) {
        emailCell.shouldHave(text(value));
    }

    public void checkGender(String value) {
        genderCell.shouldHave(text(value));
    }

    public void checkPhoneNumber(String value) {
        phoneNumberCell.shouldHave(text(value));
    }

    public void checkDateOfBirth(String value) {
        dateOfBirthCell.shouldHave(text(value));
    }

    public void checkSubject(String value) {
        subjectCell.shouldHave(text(value));
    }

    public void checkHobby(String value) {
        hobbyCell.shouldHave(text(value));

    }

    public void checkImage(String value) {
        imageCell.shouldHave(text(value));
    }

    public void checkStateAndCity(String value) {
        stateAndCityCell.shouldHave(text(value));
    }

}

