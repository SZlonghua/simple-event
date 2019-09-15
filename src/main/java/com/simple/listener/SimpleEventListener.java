package com.simple.listener;

import com.simple.event.SimpleEvent;

import java.util.EventListener;

public interface SimpleEventListener extends EventListener {
    void handEvent(SimpleEvent event);
}
