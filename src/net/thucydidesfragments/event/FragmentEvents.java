package net.thucydidesfragments.event;

import java.util.concurrent.Executors;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

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