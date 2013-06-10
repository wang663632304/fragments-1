package net.thucydidesfragments.locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

public class DefaultElementLocator implements ElementLocator {

	private final SearchContext searchContext;
	
	private final By by;
	
	public DefaultElementLocator(SearchContext searchContext, By by) {
		this.searchContext = searchContext;
		this.by = by;
	}

	public WebElement findElement() {
		return searchContext.findElement(by);
	}

	public List<WebElement> findElements() {
		return searchContext.findElements(by);
	}

	public String toString() {
		return by.toString();
	}
}
