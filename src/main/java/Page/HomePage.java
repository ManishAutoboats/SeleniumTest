package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Helper.WebDriverHelper;

public class HomePage extends WebDriverHelper {
	public By allowCookiesButton = By.cssSelector("button#onetrust-accept-btn-handler");
	public final static By buttonAgeAllow = By.cssSelector("#btn-entry-age-allow");
	public By PersonIcon = By.cssSelector("div.column.desktop-only.customer_action>a");
	public By SignLink = By.cssSelector("div.userLoggout  ul > li:nth-child(1) > a");
	public By BasketCount = By.cssSelector("span.counter-number");
	public By BasketPrice = By.cssSelector("span.cart_details > span");
	public final static By BASKET_ICON = By.cssSelector("a.action.showcart");
	public final static By VIEW_BASKET = By.cssSelector(
			"#minicart-content-wrapper > div > div.actions.minicart-actions > div > a,a.action.viewcart.primary");
	public static final By REMOVE_ITEM_FROM_BASKETPAGE_ICON_UK_CX = By.cssSelector("button.action.primary.remove");
	public static final By CONFIRM_ITEM_REMOVAL_FROM_BASKETPAGE_UK_CX = By.cssSelector("a.action.action-delete");

	public void selectCookieAndAgeGate() {
		waitForExpectedElement(allowCookiesButton, 20);
		waitForExpectedElement(allowCookiesButton, 20).click();
		waitForExpectedElement(buttonAgeAllow, 20);
		waitForExpectedElement(buttonAgeAllow, 20).click();

	}

	public void clickOnPersonIcon() {
		waitForExpectedElement(PersonIcon, 15);
		hoverOnElement(PersonIcon);
		waitForExpectedElement(SignLink, 20).click();

	}

	public boolean isemptyBasket() {
		waitForExpectedElement(BASKET_ICON, 10);
		return waitForExpectedElement(BasketPrice,20).getText().contains("£0.00");

		}
		
	

	public void emptyBasket() {
		if (!isemptyBasket()) {
			try {
				waitForExpectedElement(VIEW_BASKET, 15).click();
			} catch (Exception e) {
				waitForExpectedElement(BASKET_ICON, 15).click();
				waitForExpectedElement(VIEW_BASKET, 15).click();
			}
			while (driver.findElements(REMOVE_ITEM_FROM_BASKETPAGE_ICON_UK_CX).size() != 0) {
				waitForExpectedElement(REMOVE_ITEM_FROM_BASKETPAGE_ICON_UK_CX, 15).click();
				try {
					waitForExpectedElement(CONFIRM_ITEM_REMOVAL_FROM_BASKETPAGE_UK_CX,15).click();
				} catch (Exception ex) {
					clickByElementByQueryJSExecutor(CONFIRM_ITEM_REMOVAL_FROM_BASKETPAGE_UK_CX);
					selectValueFromDropDownByIndex(3, BASKET_ICON);
				}
			}

		}

	}

}
