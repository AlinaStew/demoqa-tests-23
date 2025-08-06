package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void dragAndDropShouldSwapElements() {
        open("/drag_and_drop"); //хвост ссылки
        SelenideElement source = $("#column-a"); //присвоили селекторы к source and target
        SelenideElement target = $("#column-b");
        actions().clickAndHold(source)
                .moveToElement(target)
                .release()
                .build()
                .perform();
        source.shouldHave(text("B"));
        target.shouldHave(text("A"));
    }
}
