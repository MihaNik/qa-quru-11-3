package pages.components;

import com.codeborne.selenide.SelenideElement;

public class DropDownWithSearchComponent {


    public void setItemsList(String[] items, SelenideElement itemInput) {
        for (String item : items) {
            itemInput
                    .setValue(item)
                    .pressEnter();
        }
    }
}
