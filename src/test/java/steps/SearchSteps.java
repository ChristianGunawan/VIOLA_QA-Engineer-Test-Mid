package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.HomePageLocators;
import locators.LoginPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CustomWebDriverManager;
import utils.WaitUtils;

public class SearchSteps {
    WebDriver driver = CustomWebDriverManager.getDriver();

    @Given("user click Search")
    public void userClickSearch() {
        driver.get("https://voila.id/");
        WaitUtils.waitForElementToBeClickable(driver, By.xpath(HomePageLocators.SEARCH)).click();
    }

    @When("user input {string}")
    public void userInput(String search) {
        WebElement searchField = WaitUtils.waitForElementToBeVisible(driver, By.xpath(HomePageLocators.SEARCH_INPUT));
        searchField.clear();
        searchField.sendKeys(search);
    }

    @And("user click suggest brand {string}")
    public void userClickSuggestBrand(String search) {
        String adidas = HomePageLocators.SUGGESTED_BRANDS(search);
        WebElement brandElement = WaitUtils.waitForElementToBeVisible(driver, By.xpath(adidas));
        brandElement.click();
    }

    @Then("verify user redirect suggest brand {string} page")
    public void verifyUserRedirectSuggestBrandPage(String search) {
        WaitUtils.waitForUrlToContain(driver, "https://voila.id/brand/"+search);
    }

    @And("user hit enter")
    public void userHitEnter() {
        WebElement searchField = WaitUtils.waitForElementToBeVisible(driver, By.xpath(HomePageLocators.SEARCH_INPUT));
        searchField.sendKeys(Keys.RETURN);
    }

    @Then("verify user see in brand page {string}")
    public void verifyUserSeeInBrandPageAnd(String search) {
        String SEARCH_WORDING_BRAND = HomePageLocators.SEARCH_WORDING_BRAND(search);
        String IMAGE_BRAND = HomePageLocators.IMAGE_BRAND(search);
        String SPAN_BRAND = HomePageLocators.SPAN_BRAND(search);


        WaitUtils.waitForUrlToContain(driver, "https://voila.id/search?q="+search);
        WaitUtils.waitForElementToBeVisible(driver, By.xpath(SEARCH_WORDING_BRAND));
        WaitUtils.waitForElementToBeVisible(driver, By.xpath(IMAGE_BRAND));
        WaitUtils.waitForElementToBeVisible(driver, By.xpath(SPAN_BRAND));
    }

    @And("user click suggest collection {string}")
    public void userClickSuggestCollection(String coll) {
        String adidas = HomePageLocators.SUGGESTED_COLLECTIONS(coll);
        WebElement brandElement = WaitUtils.waitForElementToBeVisible(driver, By.xpath(adidas));
        brandElement.click();
    }

    @Then("verify user redirect suggest collection {string} page")
    public void verifyUserRedirectSuggestCollectionPage(String link) {
        WaitUtils.waitForUrlToContain(driver, "https://voila.id/collections/"+link);
    }

    @And("user click first suggest products")
    public void userClickFirstSuggestProducts() {
        WaitUtils.waitForElementToBeClickable(driver, By.xpath(HomePageLocators.SUGGESTED_PRODUCTS_FIRST_BRAND)).click();
    }

    @Then("verify user redirect product detail page {string} {string}")
    public void verifyUserRedirectProductDetailPage(String link, String search) {
        String BRAND_PDP = HomePageLocators.BRAND_PDP(search);

        WaitUtils.waitForUrlToContain(driver, "https://voila.id/products/"+link);
        WaitUtils.waitForElementToBeVisible(driver, By.xpath(BRAND_PDP));
    }
}
