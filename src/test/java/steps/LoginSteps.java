package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.HomePageLocators;
import locators.LoginPageLocators;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CustomWebDriverManager;
import utils.WaitUtils;

public class LoginSteps {
    WebDriver driver = CustomWebDriverManager.getDriver();

    @Given("user click sign in")
    public void user_click_sign_in() {
        driver.get("https://voila.id/account/login");
        WaitUtils.waitForElementToBeVisible(driver, By.xpath(LoginPageLocators.SIGN_IN_WORDING));
        WaitUtils.waitForElementToBeVisible(driver, By.xpath(LoginPageLocators.SIGN_IN_SUBWORDING));
    }

    @When("user input email {string}")
    public void userInputEmail(String email) {
        WebElement emailField = WaitUtils.waitForElementToBeClickable(driver, By.xpath(LoginPageLocators.INPUT_EMAIL));
        emailField.click();
        emailField.sendKeys(email);
    }

    @And("user input password {string}")
    public void userInputPassword(String password) {
        WebElement passField = WaitUtils.waitForElementToBeClickable(driver, By.xpath(LoginPageLocators.INPUT_PASS));
        passField.click();
        passField.sendKeys(password);
    }

    @And("user click Sign In Button")
    public void userClickSignInButton() {
        WaitUtils.waitForElementToBeClickable(driver, By.xpath(HomePageLocators.SIGN_IN_BUTTON)).click();
    }

    @Then("verify user redirect to homepage")
    public void verifyUserRedirectToHomepage() {
        //Assert
        WaitUtils.waitForElementToBeVisible(driver, By.xpath(HomePageLocators.VIOLA_LOGO));
        WaitUtils.waitForUrlToBe(driver, "https://voila.id/");
        Assert.assertTrue(driver.findElements(By.xpath(HomePageLocators.SIGN_IN_BUTTON)).isEmpty());
    }

    @Then("verify user redirect to register page")
    public void verifyUserRedirectToRegisterPage() {
        WaitUtils.waitForUrlToContain(driver, "https://voila.id/account/register?identifier=");
        Assert.assertTrue(driver.findElements(By.xpath(HomePageLocators.SIGN_IN_BUTTON)).isEmpty());
    }

    @Then("verify failed pop up")
    public void verifyFailedPopUp() {
        WaitUtils.waitForElementToBeVisible(driver, By.xpath(LoginPageLocators.FAILED_POP_UP));
        WaitUtils.waitForUrlToContain(driver, "https://voila.id/account/login");
    }

    @Then("verify Sign In Button cannot clickable")
    public void verifySignInButtonCannotClickable() {
        WaitUtils.isElementNotClickable(driver, By.xpath(HomePageLocators.SIGN_IN_BUTTON));
    }
}
