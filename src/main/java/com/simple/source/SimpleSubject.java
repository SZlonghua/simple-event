package com.simple.source;

public class SimpleSubject extends AbstractSubject {

    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }
}
