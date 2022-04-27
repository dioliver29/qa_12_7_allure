package qa.guru;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaTests {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NUMBER = "#76";

    @Test
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();

        });
        step("Переходим по ссылке репозитория " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Кликаем на таб Issues ", () -> {
            $(By.partialLinkText("Issues")).click();
        });
        step("Проверяем что существует Issue с номером", () -> {
            $(withText(ISSUE_NUMBER)).click();
        });

    }

}
