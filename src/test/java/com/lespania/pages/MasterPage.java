package com.lespania.pages;

import com.lespania.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class MasterPage {

    public MasterPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//img[contains(@src,'avatar')]")
    public WebElement imgUserAvatar;

    @FindBy(xpath = "//li[@data-id='logout']")
    public WebElement userMenuLogout;

}
