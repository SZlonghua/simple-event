package com.simple.source;


import com.simple.listener.SimpleEventListener;

public interface Subject {

    void add(SimpleEventListener observer);

    void del(SimpleEventListener observer);

    void notifyObservers();

    void operation();
}
