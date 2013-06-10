package net.thucydidesfragments;

import java.lang.reflect.Field;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public class ByNotAvailable extends By {
	
	private final NoSuchElementException exception;
	
	public ByNotAvailable(Field field) {
		exception = new NoSuchElementException(
				String.format("Element [%s] in [%s] is not available.", 
						field.getName(), field.getDeclaringClass().getName()));
	}

	public List<WebElement> findElements(SearchContext context) { throw exception; }
	
	public WebElement findElement(SearchContext context) { throw exception; }
	
}
