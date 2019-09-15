package com.simple.listener;


import com.simple.event.SimpleEvent;

import java.util.EventObject;

public class OneSimpleEventListener implements SimpleEventListener {
    public void handEvent(SimpleEvent event) {
        System.out.println("OneEventListener:"+event.getSource());
    }
}
