package com.simple.listener;

import java.util.EventListener;
import java.util.EventObject;

public interface SimpleEventListener extends EventListener {
    void handEvent(EventObject event);
}
