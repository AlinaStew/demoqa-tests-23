package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestDemoQAHW {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alina");
        $("#lastName").setValue("Alinova");
        $("#userEmail").setValue("alina@testik.com");
        $("#gender-radio-2").doubleClick();
        $("#userNumber").setValue("9219219211");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July"); //.элемент с классом, выпадающий список, выбор опции с тексто июль
        $(".react-datepicker__year-select").selectOption("2002");
        $(".react-datepicker__day--010:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbies-checkbox-1").parent().click(); // Выбор "Sports"
        $("div").scrollTo();
        $("#uploadPicture").uploadFile(new File("src/test/resources/pic1.png"));
        $("#currentAddress").setValue("Moscow, Red Square");
        $("div").scrollTo();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(exactText("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                Condition.text("Student Name Alina Alinova"),
                Condition.text("Student Email alina@testik.com"),
                Condition.text("Gender Female"),
                Condition.text("Mobile 9219219211"),
                Condition.text("Date of Birth 10 July,2002"),
                Condition.text("Subjects Math"),
                Condition.text("Hobbies Sports"),
                Condition.text("Pic1.png"),
                Condition.text("Moscow, Red Square"),
                Condition.text("State and City NCR Noida"));
    }
}
