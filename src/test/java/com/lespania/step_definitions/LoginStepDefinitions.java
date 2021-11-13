package com.lespania.step_definitions;

import com.lespania.pages.LoginPage;
import com.lespania.utilities.ConfigurationReader;
import com.lespania.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class LoginStepDefinitions{

    LoginPage loginPage;

    @Given("User navigates to Login Page")
    public void user_navigates_to_Login_Page() {
        Driver.get().get(ConfigurationReader.get("url"));
        loginPage = new LoginPage();
    }

    @When("User enters {string} to username textbox")
    public void user_enters_to_username_textbox(String userName) {
        loginPage.txtUserName.sendKeys(userName);
    }

    @And("User enters {string} to password textbox")
    public void user_enters_to_password_textbox(String password) {
        loginPage.txtPassword.sendKeys(password);
    }
    @And("User presses Enter key")
    public void user_presses_Enter_key() {
        loginPage.txtPassword.sendKeys(Keys.ENTER);
    }

    @Then("User should be able to land on the Files page")
    public void user_should_be_able_to_land_on_the_files_page() {
        Assert.assertEquals("Files - Seamlessly -QA", Driver.get().getTitle());
    }

    @And("User clicks LogIn button")
    public void userClicksLogInButton() {
        loginPage.btnLogIn.click();
    }

    @Then("Wrong username or password. message should be displayed")
    public void wrongUsernameOrPasswordMessageShouldBeDisplayed() {
        Assert.assertTrue(loginPage.lblMessage.isDisplayed());
    }

    @Then("Please fill out this field message should be displayed")
    public void pleaseFillOutThisFieldMessageShouldBeDisplayed() {
        if (loginPage.txtUserName.getAttribute("value").isEmpty())
            Assert.assertEquals("Please fill out this field.", loginPage.txtUserName.getAttribute("validationMessage"));
        else if(loginPage.txtPassword.getAttribute("value").isEmpty())
            Assert.assertEquals("Please fill out this field.", loginPage.txtPassword.getAttribute("validationMessage"));

    }

    @Then("User should see the password in a form of dots by default")
    public void userShouldSeeThePasswordInAFormOfDotsByDefault() {
        Assert.assertEquals("password", loginPage.txtPassword.getAttribute("type"));
    }

    @And("User clicks eye icon near the password textbox")
    public void userClicksEyeIconNearThePasswordTextbox() {
        loginPage.btnShowPassword.click();
    }

    @Then("User should see the password explicitly")
    public void userShouldSeeThePasswordExplicitly() {
        Assert.assertEquals("text", loginPage.txtPassword.getAttribute("type"));
    }

    @Then("User should see Forgot password link on the page")
    public void userShouldSeeForgotPasswordLinkOnThePage() {
        Assert.assertEquals("Forgot password?", loginPage.lnkForgotPassword.getText());
        Assert.assertTrue(loginPage.lnkForgotPassword.isDisplayed());
    }

    @And("User clicks on the Forgot password link")
    public void userClicksOnTheForgotPasswordLink() {
        loginPage.lnkForgotPassword.click();
    }

    @Then("User should see the Reset password button")
    public void userShouldSeeTheResetPasswordButton() {
        Assert.assertTrue(loginPage.btnResetPassword.isDisplayed());
    }

    @Then("User should see Username or email placeholder on the Username field")
    public void userShouldSeeUsernameOrEmailPlaceholderOnTheUsernameField() {
        Assert.assertEquals("Username or email", loginPage.txtUserName.getAttribute("placeholder"));
    }

    @And("User should see Password placeholder on the Password field")
    public void userShouldSeePasswordPlaceholderOnThePasswordField() {
        Assert.assertEquals("Password", loginPage.txtPassword.getAttribute("placeholder"));
    }


}
