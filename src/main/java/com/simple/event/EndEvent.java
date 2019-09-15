package com.simple.event;

public class EndEvent extends SimpleEvent {
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
