package com.lespania.pages;

import com.lespania.utilities.ConfigurationReader;
import com.lespania.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "user")
    public WebElement txtUserName;

    @FindBy(id = "password")
    public WebElement txtPassword;

    @FindBy(id = "submit-form")
    public WebElement btnLogIn;

    @FindBy(css = ".warning.wrongPasswordMsg")
    public WebElement lblMessage;

    @FindBy(xpath = "//img[contains(@src,'toggle.svg')]")
    public WebElement btnShowPassword;

    @FindBy(id = "lost-password")
    public WebElement lnkForgotPassword;

    @FindBy(id = "reset-password-submit")
    public WebElement btnResetPassword;

    public void login(){
        txtUserName.sendKeys(ConfigurationReader.get("username"));
        txtPassword.sendKeys(ConfigurationReader.get("password"));
        btnLogIn.click();
    }
}
