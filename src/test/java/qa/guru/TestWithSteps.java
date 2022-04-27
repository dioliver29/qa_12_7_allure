package qa.guru;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestWithSteps {

    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();

    }

    @Step("Переходим по ссылке репозитория ")
    public void clickOnRepositoryLink(String repo) {
        $(By.linkText(repo)).click();

    }

    @Step("Кликаем на таб Issues ")
    public void openIssuesTab() {
        $(By.partialLinkText("Issues")).click();

    }
    @Step("Проверяем что существует Issue с номером {issue_number}")
    public void shouldSeeIssueWithNumber(int issue_number) {
        $(withText("#" + issue_number)).shouldBe(Condition.visible);

    }
}
