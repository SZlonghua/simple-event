package com.simple.listener;


import java.util.EventObject;

public class OneSimpleEventListener implements SimpleEventListener {
    public void handEvent(EventObject event) {
        System.out.println("OneEventListener:"+event.getSource());
    }
}
