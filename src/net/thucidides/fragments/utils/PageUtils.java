package net.thucidides.fragments.utils;

import net.thucidides.fragments.Fragment;
import net.thucidides.fragments.IFragmentContext;
import net.thucidides.fragments.PageWithFragments;

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
