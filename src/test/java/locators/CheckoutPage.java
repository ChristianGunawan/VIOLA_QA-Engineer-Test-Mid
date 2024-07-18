package locators;

public class CheckoutPage {
    public static final String PAYMENT_METHOD_STRING = "//p[contains(text(), 'Payment Method')]";
    public static final String YOUR_ORDER_STRING = "//p[contains(text(), 'Your Order')]";
    public static final String SHIPPING_METHOD_BUTTON = "//div[@data-test-id='CT_Component_ShippingSelector_ButtonShipping']";
    public static final String FIRST_SHIPPING_METHOD_STRING = "(//div[@data-test-id='CT_component_shipping-item-item'])[1]";
    public static final String CONFIRM_BUTTON = "//button[text()='Confirm']";
    public static final String PAYMENT_METHOD_BUTTON = "//p[text()='Payment Method']/following-sibling::*";
    public static final String VIRTUAL_ACCOUNT_BUTTON = "//p[text()='Virtual Account']/ancestor::button";
    public static final String BCA_VA_STRING = "(//div[@data-test-id='CT_component_divider_default'])[3]/parent::*";
    public static final String CONFIRM_PAYMENT_METHOD_BUTTON = "//p[text()='Confirm Payment Method']";
    public static final String PLACE_ORDER_BUTTON = "//button[@data-test-id='CT_Component_btnPlaceOrder']";
    public static final String ORDER_HAS_BEEN_PLACES_STRING = "//p[text()='Order has been placed']";
    public static final String VIRTUAL_ACCOUNT_NUMBER_STRING = "//p[text()='Virtual Account Number']";
    public static final String ORDER_ID_STRING = "//p[text()='Order ID']";
    public static final String CHECK_ORDER_STATUS_BUTTON = "//button[text()='Check Order Status']";
    public static final String CONTINUE_SHOPPING_BUTTON = "//button[text()='Continue Shopping']";
}
