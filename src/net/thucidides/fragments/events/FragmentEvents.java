package net.thucidides.fragments.events;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executors;

public class FragmentEvents {
	
	private static EventBus eventBus;
	
	private FragmentEvents(){}
	
	public static EventBus getEventBus(){
		if(eventBus == null){
			eventBus = new AsyncEventBus(Executors.newCachedThreadPool());
		}
		return eventBus;
	}
}