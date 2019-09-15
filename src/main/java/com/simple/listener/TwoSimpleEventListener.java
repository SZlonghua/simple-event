package com.simple.listener;

import com.simple.event.SimpleEvent;

import java.util.EventObject;

public class TwoSimpleEventListener implements SimpleEventListener {
    public void handEvent(SimpleEvent event) {
        System.out.println("TwoEventListener:"+event.getSource());
    }
}
