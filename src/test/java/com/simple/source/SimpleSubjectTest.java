package com.simple.source;

import com.simple.event.EndEvent;
import com.simple.event.StartEvent;
import com.simple.listener.OneSimpleEventListener;
import com.simple.listener.TwoSimpleEventListener;
import org.junit.Test;



public class SimpleSubjectTest {

    @Test
    public void test(){
        SimpleSubject subject = new SimpleSubject();
        subject.add(new OneSimpleEventListener());
        subject.add(new TwoSimpleEventListener());
        subject.operation();

    }


    @Test
    public void test2(){

        SimpleSubject subject = new SimpleSubject();
        subject.publish(new StartEvent(new Object()));

    }

    @Test
    public void test3(){

        SimpleSubject subject = new SimpleSubject();
        subject.publish(new EndEvent(new Object()));

    }


}