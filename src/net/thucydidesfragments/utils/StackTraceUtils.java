package net.thucydidesfragments.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StackTraceUtils {
	
	private final static String[] TRASH_PACKAGES = new String[]{
		"sun.reflect", "java.lang.reflect", "java.util.concurrent",
		"org.testng.internal", "org.openqa.selenium", 
		"org.fragments.proxy", "com.astet.utils"
	};
	
	public static Throwable cleanStackTrace(Throwable throwable){
		List<StackTraceElement> effectiveStackTrace = 
				new ArrayList<>(Arrays.asList(throwable.getStackTrace()));
		
		for(StackTraceElement element: throwable.getStackTrace()){
			for(int i=0;i<TRASH_PACKAGES.length && effectiveStackTrace.contains(element);i++){
				if(element.getClassName().startsWith(TRASH_PACKAGES[i])){
					effectiveStackTrace.remove(element);
				}
			}
		}
		
		throwable.setStackTrace(effectiveStackTrace.toArray(new StackTraceElement[0]));
		
		return throwable;
	}
}