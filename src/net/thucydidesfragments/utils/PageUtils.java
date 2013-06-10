package net.thucydidesfragments.utils;

import net.thucydidesfragments.Fragment;
import net.thucydidesfragments.IFragmentContext;
import net.thucydidesfragments.PageWithFragments;

public class PageUtils {
	
	public static PageWithFragments getParentPage(IFragmentContext context){
		if(context instanceof PageWithFragments){
			return (PageWithFragments) context;
		}
		
		if(context instanceof Fragment){
			return getParentPage(((Fragment<?>)context).getParent());
		}
		
		throw new IllegalArgumentException("Nor page fragment nor page.");
	}
	
}
