package com.simple.event;

import java.util.EventObject;

public class EndEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public EndEvent(Object source) {
        super(source);
    }
}
