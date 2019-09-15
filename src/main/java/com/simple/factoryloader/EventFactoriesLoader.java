package com.simple.factoryloader;


import com.simple.listener.SimpleEventListener;
import com.simple.util.PropertiesLoaderUtils;
import com.simple.util.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class EventFactoriesLoader {

    public static final String FACTORIES_RESOURCE_LOCATION = "META-INF/event.factories";

    private static final Log logger = LogFactory.getLog(EventFactoriesLoader.class);

    public static List<SimpleEventListener> loadListener(Class<?> eventClass, ClassLoader classLoader) {
        ClassLoader classLoaderToUse = classLoader;
        if (classLoaderToUse == null) {
            classLoaderToUse = EventFactoriesLoader.class.getClassLoader();
        }
        List<String> listenerNames = loadListenerNames(eventClass, classLoaderToUse);
        if (logger.isTraceEnabled()) {
            logger.trace("Loaded [" + eventClass.getName() + "] names: " + listenerNames);
        }
        List<SimpleEventListener> result = new ArrayList<SimpleEventListener>(listenerNames.size());
        for (String listenerName : listenerNames) {
            result.add(instantiateListener(listenerName,classLoaderToUse));
        }
        //AnnotationAwareOrderComparator.sort(result);
        return result;
    }

    public static List<String> loadListenerNames(Class<?> factoryClass, ClassLoader classLoader) {
        String factoryClassName = factoryClass.getName();
        return loadListener(classLoader).get(factoryClassName);
    }

    private static Map<String, List<String>> loadListener( ClassLoader classLoader) {

        try {
            Map<String, List<String>> result = new LinkedHashMap<String, List<String>>();
            Enumeration<URL> urls = (classLoader != null ?
                    classLoader.getResources(FACTORIES_RESOURCE_LOCATION) :
                    ClassLoader.getSystemResources(FACTORIES_RESOURCE_LOCATION));
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                Properties properties = PropertiesLoaderUtils.loadProperties(url);
                for (Map.Entry<?, ?> entry : properties.entrySet()) {
                    List<String> factoryClassNames = Arrays.asList(
                            StringUtils.commaDelimitedListToStringArray((String) entry.getValue()));
                    result.put((String) entry.getKey(), factoryClassNames);
                }
            }
            return result;
        }
        catch (IOException ex) {
            throw new IllegalArgumentException("Unable to load factories from location [" +
                    FACTORIES_RESOURCE_LOCATION + "]", ex);
        }
    }

    private static SimpleEventListener instantiateListener(String instanceClassName, ClassLoader classLoader) {
        try {
            Class<?> aClass = classLoader.loadClass(instanceClassName);
            Object inst = aClass.newInstance();
            if(inst instanceof SimpleEventListener){
                return  (SimpleEventListener)inst;
            }
            throw new IllegalArgumentException("Unable to instantiate listener class: " + instanceClassName);
        }
        catch (Throwable ex) {
            throw new IllegalArgumentException("Unable to instantiate listener class: " + instanceClassName, ex);
        }
    }


    private static Map<String, List<SimpleEventListener>> loadListenerIntance( ClassLoader classLoader) {
        Map<String, List<String>> loadListener = loadListener(classLoader);
        Map<String, List<SimpleEventListener>> result = new LinkedHashMap<>();
        for (Map.Entry<String,List<String>> entry : loadListener.entrySet()) {
            List<String> value = entry.getValue();
            List<SimpleEventListener> listeners = value.stream().map(listenerName -> {
                return instantiateListener(listenerName, classLoader);
            }).collect(Collectors.toList());
            result.put(entry.getKey(), listeners);
        }
        return result;
    }

    public static Map<String, List<SimpleEventListener>> loadAllListenerIntance( ClassLoader classLoader) {
        ClassLoader useClassLoader = classLoader;
        if(useClassLoader==null){
            useClassLoader = EventFactoriesLoader.class.getClassLoader();
        }
        return loadListenerIntance(useClassLoader);
    }
}
