package locators;

public class CartPage {
    public static final String VOUCHER_STRING = "//p[contains(text(), 'Voucher')]";
    public static final String ORDER_SUMMARY_STRING = "//p[contains(text(), 'Order Summary')]";
    public static final String CART_CHECKOUT_BUTTON = "//button[contains(text(), 'Checkout')]";
    public static final String SUBTOTAL_STRING = "//p[contains(text(), 'Order Summary')]/parent::*/parent::div//following-sibling::p";
    public static final String TOTAL_STRING = "//div[@data-test-id='CT_Component_ctaShowHideSubtotal']/p";

}
