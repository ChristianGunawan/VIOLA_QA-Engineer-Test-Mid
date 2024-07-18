package steps;

import io.cucumber.java.en.And;
import locators.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import utils.CustomWebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.WaitUtils;

public class TransactionSteps {

    WebDriver driver = CustomWebDriverManager.getDriver();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get("https://voila.id/");
        WaitUtils.waitForElementToBeClickable(driver, By.xpath(HomePageLocators.SIGN_IN_BUTTON)).click();
        WaitUtils.waitForElementToBeVisible(driver, By.xpath(LoginPageLocators.REGIST_HERE));
        WaitUtils.waitForElementToBeClickable(driver, By.xpath(LoginPageLocators.INPUT_EMAIL)).click();
        WaitUtils.waitForElementToBeVisible(driver, By.xpath(LoginPageLocators.INPUT_EMAIL)).sendKeys("gunawancg111@gmail.com");
        WaitUtils.waitForElementToBeClickable(driver, By.xpath(LoginPageLocators.INPUT_PASS)).click();
        WaitUtils.waitForElementToBeVisible(driver, By.xpath(LoginPageLocators.INPUT_PASS)).sendKeys("Password123");
        WaitUtils.waitForElementToBeClickable(driver, By.xpath(HomePageLocators.SIGN_IN_BUTTON)).click();
        WaitUtils.waitForElementToBeVisible(driver, By.xpath(HomePageLocators.VIOLA_LOGO));

        //Assert
        WaitUtils.waitForUrlToBe(driver, "https://voila.id/");
        Assert.assertTrue(driver.findElements(By.xpath(HomePageLocators.SIGN_IN_BUTTON)).isEmpty());
    }

    @When("the user make transaction from homepage")
    public void theUserMakeTransactionFromHomepage() {
        WaitUtils.scrollToElementAndClick(driver, By.xpath(HomePageLocators.MASSIVE_PRICE_CUT_GOODS)).click();
        String expectedUrlStart = "https://voila.id/products/";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.startsWith(expectedUrlStart));
    }

    @And("the user click add to bag button")
    public void theUserClickAddToBagButton() {
        WaitUtils.scrollToElementAndClick(driver, By.xpath(PdPPageLocators.ADD_TO_CART_BUTTON)).click();
    }

    @And("the user click cart button")
    public void theUserClickCartButton() {
        WaitUtils.scrollToElementAndClick(driver, By.xpath(PdPPageLocators.CART_BUTTON)).click();

        //ASSERT
        WaitUtils.waitForElementToBeVisible(driver, By.xpath(PdPPageLocators.ADD_TO_CART_BUTTON));
        WaitUtils.waitForElementToBeVisible(driver, By.xpath(PdPPageLocators.CART_BUTTON));
        Assert.assertEquals("https://voila.id/cart", driver.getCurrentUrl());

        WebElement subtotalElement = WaitUtils.scrollToElement(driver, By.xpath(PdPPageLocators.ADD_TO_CART_BUTTON));
        WebElement totalElement = WaitUtils.scrollToElement(driver, By.xpath(PdPPageLocators.CART_BUTTON));
        String subtotalString = subtotalElement.getText();
        String totalString = totalElement.getText();
        Assert.assertEquals(totalString, subtotalString);
    }

    @And("the user click checkout button")
    public void theUserClickCheckoutButton() {
        WaitUtils.waitForElementToBeVisible(driver, By.xpath(CartPage.VOUCHER_STRING));
        WaitUtils.waitForElementToBeVisible(driver, By.xpath(CartPage.ORDER_SUMMARY_STRING));

        WaitUtils.waitForElementToBeClickable(driver, By.xpath(CartPage.CART_CHECKOUT_BUTTON)).click();
        WaitUtils.waitForUrlToBe(driver, "https://voila.id/checkout");
    }

    @And("the user fill address label, name, phone number, city, and full address")
    public void theUserFillAddressLabelNamePhoneNumberCityAndFullAddress() {
        WaitUtils.waitForElementToBeVisible(driver, By.xpath(CheckoutPage.PAYMENT_METHOD_STRING));
        WaitUtils.waitForElementToBeVisible(driver, By.xpath(CheckoutPage.YOUR_ORDER_STRING));
    }


    @And("the user choose shipping method")
    public void theUserChooseShippingMethod() {
        WaitUtils.waitForElementToBeClickable(driver, By.xpath(CheckoutPage.SHIPPING_METHOD_BUTTON)).click();
        WaitUtils.waitForElementToBeClickable(driver, By.xpath(CheckoutPage.FIRST_SHIPPING_METHOD_STRING)).click();
        WaitUtils.waitForElementToBeClickable(driver, By.xpath(CheckoutPage.CONFIRM_BUTTON)).click();

    }

    @And("the user choose payment method")
    public void theUserChoosePaymentMethod() {
        WaitUtils.waitForElementToBeClickable(driver, By.xpath(CheckoutPage.PAYMENT_METHOD_BUTTON)).click();
        WaitUtils.waitForElementToBeClickable(driver, By.xpath(CheckoutPage.VIRTUAL_ACCOUNT_BUTTON)).click();
        WaitUtils.waitForElementToBeClickable(driver, By.xpath(CheckoutPage.BCA_VA_STRING)).click();
    }

    @Then("the user click place order button")
    public void theUserClickPlaceOrderButton() {
        WaitUtils.waitForElementToBeClickable(driver, By.xpath(CheckoutPage.CONFIRM_PAYMENT_METHOD_BUTTON)).click();
        WaitUtils.waitForElementToBeClickable(driver, By.xpath(CheckoutPage.PLACE_ORDER_BUTTON)).click();

        WaitUtils.waitForElementToBeVisible(driver, By.xpath(CheckoutPage.ORDER_HAS_BEEN_PLACES_STRING));
        WaitUtils.waitForElementToBeVisible(driver, By.xpath(CheckoutPage.VIRTUAL_ACCOUNT_NUMBER_STRING));
        WaitUtils.waitForElementToBeVisible(driver, By.xpath(CheckoutPage.ORDER_ID_STRING));
        WaitUtils.waitForElementToBeVisible(driver, By.xpath(CheckoutPage.CHECK_ORDER_STATUS_BUTTON));
        WaitUtils.waitForElementToBeVisible(driver, By.xpath(CheckoutPage.CONTINUE_SHOPPING_BUTTON));

        String expectedBaseUrl = "https://voila.id/checkout/payment?order-reference=";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(expectedBaseUrl, currentUrl.startsWith(expectedBaseUrl));    }
}
