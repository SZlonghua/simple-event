package com.simple.source;

import com.simple.listener.SimpleEventListener;

import java.util.EventObject;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractSubject implements Subject {
    protected List<SimpleEventListener> eventListeners = new CopyOnWriteArrayList();
    //protected Map<ActivitiEventType, List<SimpleEventListener>> typedListeners = new HashMap();
    public void add(SimpleEventListener eventListener) {
        eventListeners.add(eventListener);
    }

    public void del(SimpleEventListener eventListener) {
        eventListeners.remove(eventListener);
    }

    public void notifyObservers() {
        for(SimpleEventListener eventListener:eventListeners){
            eventListener.handEvent(new EventObject(new Object()));
        }
    }

}
