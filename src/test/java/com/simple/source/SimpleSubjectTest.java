package com.simple.source;

import com.simple.listener.OneSimpleEventListener;
import com.simple.listener.TwoSimpleEventListener;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleSubjectTest {

    @Test
    public void test(){
        SimpleSubject subject = new SimpleSubject();
        subject.add(new OneSimpleEventListener());
        subject.add(new TwoSimpleEventListener());
        subject.operation();

    }


}