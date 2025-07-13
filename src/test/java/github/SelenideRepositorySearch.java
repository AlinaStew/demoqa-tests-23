package github;


import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

public class SelenideRepositorySearch {

    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        open("https://github.com/"); //открыть главную страницу
        $("[placeholder='Search or jump to...']").click();
        $("[name='query-builder-test']").setValue("Selenide").pressEnter(); //ввести в поле поиска selenide и нажать enter
        sleep(5000);
        var results = $$("[data-testid='results-list'] > div");
        results.first().$("a").click();
        // Проверяем, что перешли на страницу Selenide
        $("#repository-container-header").shouldHave(Condition.text("selenide/selenide"));
    }
}
