package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeworkTest {

    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1280x720";
        Configuration.browserPosition = "0x0";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Anton");
        $("#lastName").setValue("Shugaev");
        $("#userEmail").setValue("anton@anton.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("9998887755");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(6);
        $(".react-datepicker__year-select").selectOptionContainingText("1995");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__day--021").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("[for = hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/8cGS9lBq2Y0.jpg"));
        $("#currentAddress").setValue("my adress somewhere in Samara");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-body").shouldHave(text("Anton Shugaev"));
        $(".modal-body").shouldHave(text("anton@anton.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("9998887755"));
        $(".modal-body").shouldHave(text("21 July,1995"));
        $(".modal-body").shouldHave(text("Computer Science"));
        $(".modal-body").shouldHave(text("Computer Science"));
        $(".modal-body").shouldHave(text("8cGS9lBq2Y0.jpg"));
        $(".modal-body").shouldHave(text("my adress somewhere in Samara"));
        $(".modal-body").shouldHave(text("NCR Delhi"));
        $(".modal-body").shouldHave(
                text("Anton Shugaev"),
                text("anton@anton.com"),
                text("Male"),
                text("9998887755"),
                text("21 July,1995"),
                text("Computer Science"),
                text("Music"),
                text("8cGS9lBq2Y0.jpg"),
                text("my adress somewhere in Samara"),
                text("NCR Delhi")
        );

    }
}
