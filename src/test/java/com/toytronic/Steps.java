package com.toytronic;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;

public class Steps {

    @Step("Открываем страницу https://github.com/{page}")
    public void openPage(String page) {
        open("https://github.com/" + page);
    }
    @Step("Вводим в строке поиска issueId {issueId}")
    public void inputIssueIdInSearchField(String issueId) {
        $("#js-issues-search").click();
        $("#js-issues-search").setValue(issueId);
        $("#js-issues-search").pressEnter();
    }

    @Step("Проверяем название Issue {issueId}" )
    public void checkIssueName(String issueId, String issueName) {
        $("#issue_2133_link").shouldHave(Condition.
                text(issueName));
    }
}