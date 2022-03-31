package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {


    public void setDate(String year, String month, String day) {
        $$("select.react-datepicker__year-select option").findBy(text(year)).click();
        $$("select.react-datepicker__month-select option").findBy(text(month)).click();
        $$("div.react-datepicker__day").findBy(text(day)).click();
    }
}
