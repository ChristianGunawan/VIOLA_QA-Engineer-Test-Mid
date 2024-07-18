package locators;

public class HomePageLocators {
    public static final String SIGN_IN_BUTTON = "//button[text()='Sign In']";
    public static final String VIOLA_LOGO = "(//img[@alt='voila logo'])[1]";
    public static final String MASSIVE_PRICE_CUT_GOODS = "//p[contains(text(), 'Massive Price Cut')]/parent::*/parent::*/div[2]/div/section/div[1]/ul/li[contains(@id, 'splide02-slide01')]";
    public static final String SEARCH = "//input[@data-test-id='CT-Search']";
    public static final String SEARCH_INPUT = "//input[@data-test-id='CT-Search-Input']";
    public static String SUGGESTED_BRANDS(String brandName) {
        return String.format("//p[text()='%s']", brandName);
    }
    public static String SUGGESTED_COLLECTIONS(String brandName) {
        return String.format("//p[text()='Suggested Collections']/parent::*/div/div/a/div/p[text()='%s']", brandName);
    }
    public static String SEARCH_WORDING_BRAND(String brandName) {
        return String.format("//div[@id='products-result-layout']/parent::*/div/h1/div/p[text()='%s']", brandName);
    }
    public static String IMAGE_BRAND(String brandName) {
        return String.format("//img[@alt='%s']", brandName);
    }
    public static String SPAN_BRAND(String brandName) {
        return String.format("(//span[@class='ellipsis-one-line' and text()='%s'])[1]", brandName);
    }
    public static final String SUGGESTED_PRODUCTS_FIRST_BRAND = "(//p[text()='Suggested Products']/parent::*/div/div/a/div)[1]";
    public static String BRAND_PDP(String brandName) {
        return String.format("(//a[text()='%s'])[1]", brandName);
    }
}


