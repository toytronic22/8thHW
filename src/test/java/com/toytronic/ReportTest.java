package com.toytronic;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class ReportTest {
    private static final String ISSUE_ID = "2133";
    @Test
    @DisplayName("Проверка имени Issue без степов")
    public void checkNameIssue() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/selenide/selenide/issues");
        $("#js-issues-search").click();
        $("#js-issues-search").setValue(ISSUE_ID);
        $("#js-issues-search").pressEnter();
        $("#issue_2133_link").shouldHave(Condition.
                text("Add ClickOptions argument for the doubleClick method"));
    }
}