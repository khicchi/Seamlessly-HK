package com.lespania.step_definitions;

import com.lespania.pages.FilesPage;
import com.lespania.pages.LoginPage;
import com.lespania.pages.MasterPage;
import com.lespania.utilities.ConfigurationReader;
import com.lespania.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class LogoutStepDefinitions {
    MasterPage masterPage;
    FilesPage filesPage;

    @Given("User is successfully logged in")
    public void userIsSuccessfullyLoggedIn() {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().login();
        filesPage = new FilesPage();
        masterPage = (MasterPage)filesPage;
    }

    @When("User clicks user icon on the top right of the page")
    public void userClicksUserIconOnTheTopRightOfThePage() {
        masterPage.imgUserAvatar.click();
    }

    @And("User clicks {string} user menu")
    public void userClicksUserMenu(String menuName) {
        if (menuName.equals("logout"))
            masterPage.userMenuLogout.click();
    }

    @Then("User should be logout and redirected to login page")
    public void userShouldBeLogoutAndRedirectedToLoginPage() {
        Assert.assertEquals("https://qa.seamlessly.net/index.php/login?clear=1", Driver.get().getCurrentUrl());
        Assert.assertEquals("Seamlessly -QA", Driver.get().getTitle());
    }

    @When("User is logged out successfully")
    public void userIsLoggedOutSuccessfully() {
        masterPage.imgUserAvatar.click();
        masterPage.userMenuLogout.click();
    }

    @And("User clicks step back button")
    public void userClicksStepBackButton() {
        Driver.get().navigate().back();
    }

    @Then("User should not go to home page again")
    public void userShouldNotGoToHomePageAgain() {
        Assert.assertTrue(Driver.get().getCurrentUrl().startsWith("https://qa.seamlessly.net/index.php/login"));
    }
}
