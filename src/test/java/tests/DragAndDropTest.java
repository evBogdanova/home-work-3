package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @BeforeAll
    static void fullScreen() {
        Configuration.startMaximized = true;
    }

    @Test
    public void dragAndDrop() {
        //переход на страницу
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //перенос прямоугольника А на место В
        $("#column-a").dragAndDropTo($("#column-b"));

        //проверка, что пряумоугольники перенеслись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
