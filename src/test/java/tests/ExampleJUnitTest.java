package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ExampleJUnitTest {
    @BeforeAll
    static void fullScreen() {
        Configuration.startMaximized = true;
    }

    @Test
    public void exampleJUnit() {
        //переходим на сайт GitHub
        open("https://github.com/");

        //ищем Selenide
        $("[name=q]").setValue("selenide").pressEnter();

        //открываем страницу Selenide в GitHub
        $(".repo-list").find(byText("selenide/")).click();

        //переходим в раздел Wiki проекта
        $("[data-content=Wiki]").click();

        //проверка, что в списке есть страница SoftAssertions и переход к данной странице
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));

        //переход к SoftAssertions и проверка, что на странице есть пример кода для JUnit5
        $(".wiki-rightbar").find(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }

}
