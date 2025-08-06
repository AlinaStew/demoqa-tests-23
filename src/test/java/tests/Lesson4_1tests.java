package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Lesson4_1tests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/"; //задаем базовый url
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void MenuSolutionEnterprise() {
        open("");
        $(byTagAndText("button", "Solutions")).hover(); //ищем элемент по тегу <button> с текстом "Solutions" и наводим курсор на элемент
        $(byText("Enterprises")).click(); //enterprise другой объект в меню, нам нужен enterpriseS
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\ndeveloper platform")); //убрали точку в конце фразы
    }
}
