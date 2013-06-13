package net.fragments.utils;

import net.fragments.IFragmentContext;
import net.fragments.PageWithFragments;
import net.fragments.elements.Fragment;

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
