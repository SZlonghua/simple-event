package com.simple.event;

import java.util.EventObject;

public class StartEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public StartEvent(Object source) {
        super(source);
    }
}
