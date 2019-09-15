package com.simple.util;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

public class PropertiesLoaderUtils {

    public static Properties loadProperties(URL url) throws IOException {
        URLConnection con = url.openConnection();
        Properties props = new Properties();
        props.load(con.getInputStream());
        return props;
    }
}
