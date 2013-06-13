package net.thucidides.fragments;

import net.thucidides.fragments.elements.Fragment;
import net.thucidides.fragments.locators.DefaultElementLocator;
import org.openqa.selenium.*;
import org.openqa.selenium.internal.WrapsElement;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static net.thucidides.fragments.utils.XPathFunctions.containstext;

public class PageWithFragments implements IFragmentContext, SearchContext, JavascriptExecutor {
	
	/**
	 * Injected with {@link FragmentFactory}
	 */
	private final FragmentFactory fragmentFactory = null;
	
	/**
	 * Injected with {@link FragmentFactory}
	 */
	private final String contextName = null;

    /**
     *  Injected with {@link FragmentFactory}
     */
	private final WebDriver webDriver = null;

    public Object executeScript(String s, Object... objects) {
        return ((JavascriptExecutor)webDriver).executeScript(s, objects);
    }

    public Object executeAsyncScript(String s, Object... objects) {
        return ((JavascriptExecutor)webDriver).executeAsyncScript(s, objects);
    }

    public String getName() { return contextName; }
	
	public WebElement findElement(By by) { return webDriver.findElement(by); }
	
	public List<WebElement> findElements(By by) { return webDriver.findElements(by); }
		
	public Fragment findFragment(By by) {
		return findFragment(by, Fragment.class);
	}
	
	public <E extends Fragment<?>> E findFragment(By by, Class<E> type) {
		return findFragment(by, type, by.toString());
	}
	
	public <E extends Fragment<?>> E findFragment(By by, Class<E> type, String name) {
		return fragmentFactory.createFragment(type, new DefaultElementLocator(webDriver, by), name);
	}
	
	public List<Fragment> findFragments(By by) {
		return findFragments(by, Fragment.class);
	}
	
	public <E extends Fragment<?>> List<E> findFragments(By by, Class<E> type) {
		return findFragments(by, type, by.toString());
	}
	
	public <E extends Fragment<?>> List<E> findFragments(By by, Class<E> type, String name) {
		return fragmentFactory.createList(type, new DefaultElementLocator(webDriver, by), name);
	}
	
	public String getCurrentUrl() { return webDriver.getCurrentUrl(); }

	public String getTitle() { return webDriver.getTitle(); }

	public String getPageSource() { return webDriver.getPageSource(); }

	public void navigateBack() { webDriver.navigate().back(); }

	public void navigateForward() {	webDriver.navigate().forward(); }
	
	public void navigateTo(String url) { webDriver.navigate().to(url); }

	public void navigateTo(URL url) { webDriver.navigate().to(url); }
	
	public void refresh() { webDriver.navigate().refresh(); }
	
	public void setImplicitWait(long time, TimeUnit unit){
		webDriver.manage().timeouts().implicitlyWait(time, unit);
	}
	
	public void addCookie(Cookie cookie) { webDriver.manage().addCookie(cookie); }

	public void deleteCookieNamed(String name) { webDriver.manage().deleteCookieNamed(name); }

	public void deleteCookie(Cookie cookie) { webDriver.manage().deleteCookie(cookie); }

	public void deleteAllCookies() { webDriver.manage().deleteAllCookies(); }

	public Cookie getCookieNamed(String name) { return webDriver.manage().getCookieNamed(name); }
	
	public void switchToFrame(WebElement webElement){
		if(webElement instanceof WrapsElement){
			webElement = ((WrapsElement) webElement).getWrappedElement();
		}
		
		webDriver.switchTo().frame(webElement);
	}
	
	public void switchToPage(){ webDriver.switchTo().defaultContent(); }
	
	public boolean isTextPresent(String text) {
		return webDriver.getPageSource().toLowerCase().contains(text.toLowerCase());
	}
	
	public boolean isTextDisplayed(String text){
		return isTextPresent(text) && isElementVisible(By
				.xpath(String.format("//*[%s]", containstext("text()", text))));
	}
	
	public boolean isValueDisplayed(String value){
		return isTextPresent(value) && isElementVisible(By
				.xpath(String.format("//*[%s]", containstext("@value", value))));
	}

    public boolean isElementVisible(By by){ return findFragment(by).isDisplayed(); }
}
