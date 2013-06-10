package net.thucydidesfragments.locators;

import java.lang.reflect.Field;


import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.Annotations;


public class DefaultLocatorResolver implements ILocatorResolver {
	
	private static ILocatorResolver instance;
	
	private DefaultLocatorResolver(){}
	
	public static ILocatorResolver getInstance(){
		if(instance == null){
			instance = new DefaultLocatorResolver();
		}
		return instance;
	}
	
	public boolean isApplicable(Field field) { return true; }
	
	public By resolve(Field field) {
		return new Annotations(field).buildBy();
	}
}
