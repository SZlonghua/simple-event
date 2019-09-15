package com.simple.source;

import com.simple.event.SimpleEvent;
import com.simple.factoryloader.EventFactoriesLoader;
import com.simple.listener.SimpleEventListener;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractSubject implements Subject {
    protected List<SimpleEventListener> eventListeners = new CopyOnWriteArrayList();
    //protected Map<ActivitiEventType, List<SimpleEventListener>> typedListeners = new HashMap();
    protected Map<String, List<SimpleEventListener>> typedListeners = new HashMap();

    public AbstractSubject() {
        Map<String, List<SimpleEventListener>> stringListMap = EventFactoriesLoader.loadAllListenerIntance(null);
        typedListeners.putAll(stringListMap);
    }

    public void add(SimpleEventListener eventListener) {
        eventListeners.add(eventListener);
    }

    public void del(SimpleEventListener eventListener) {
        eventListeners.remove(eventListener);
    }

    public void addTypedListeners(Map<String,List<SimpleEventListener>> addTypedListeners) {
        typedListeners.putAll(addTypedListeners);
    }

    public void notifyObservers() {
        for(SimpleEventListener eventListener:eventListeners){
            eventListener.handEvent(new SimpleEvent(new Object()));
        }
    }

    public void publish(SimpleEvent simpleEvent) {
        String name = simpleEvent.getClass().getName();
        List<SimpleEventListener> simpleEventListeners = typedListeners.get(name);
        if(simpleEventListeners!=null){
            for(SimpleEventListener simpleEventListener:simpleEventListeners){
                simpleEventListener.handEvent(simpleEvent);
            }
        }
    }

}
