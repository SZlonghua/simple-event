package com.simple.listener;

import java.util.EventObject;

public class TwoSimpleEventListener implements SimpleEventListener {
    public void handEvent(EventObject event) {
        System.out.println("TwoEventListener:"+event.getSource());
    }
}
