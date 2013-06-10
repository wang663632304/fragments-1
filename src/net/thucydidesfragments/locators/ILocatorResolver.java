package net.thucydidesfragments.locators;

import java.lang.reflect.Field;

import org.openqa.selenium.By;

public interface ILocatorResolver {

	public By resolve(Field field);
	
	public boolean isApplicable(Field field);
	
}