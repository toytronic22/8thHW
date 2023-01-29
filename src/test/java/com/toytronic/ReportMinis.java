package com.toytronic;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class ReportMinis {

    private static final String issueId = "2133";
    private static final String Issue2133Title = "Add ClickOptions argument for the doubleClick method";

    @Test
    @DisplayName("Проверка имени Issue через Lambda steps")
    public void checkNameIssueLambdaSteps() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу issues проекта Selenide", () -> {
            open("https://github.com/selenide/selenide/issues");
        });
        step("Вводим в строке поиска id Issue " + issueId,  () -> {
            $("#js-issues-search").click();
            $("#js-issues-search").setValue(issueId);
            $("#js-issues-search").pressEnter();

        });
        step("Проверяем название Issue " + issueId, () -> {
            $("#issue_2133_link").shouldHave(Condition.
                    text("Add ClickOptions argument for the doubleClick method"));
        });
    }
    @Test
    @DisplayName("Проверка имени Issue через annotation steps")
    public void checkNameIssueAnnotatedSteps() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        Steps steps = new Steps();

        steps.openPage("selenide/selenide/issues");
        steps.inputIssueIdInSearchField(issueId);
        steps.checkIssueName(issueId, Issue2133Title);
    }
}