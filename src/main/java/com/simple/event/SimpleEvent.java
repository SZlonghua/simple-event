package com.simple.event;

import java.util.EventObject;

public class SimpleEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public SimpleEvent(Object source) {
        super(source);
    }
}
