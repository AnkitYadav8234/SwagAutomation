package com.sd.utils;

import com.sd.constants.FrameworkConstants;
import com.sd.enums.ConfigProperties;
import com.sd.exceptions.FrameworkException;
import com.sd.exceptions.InvalidPathForPropertyFileException;
import com.sd.exceptions.PropertyFileUsageException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {
    private PropertyUtils() {
    }

    private static Properties properties = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();

    static {
        try {
            properties.load(new FileInputStream(FrameworkConstants.getConfigfilepath()));
            for (Object key : properties.keySet()) {
                    CONFIGMAP.put(String.valueOf(key),properties.getProperty(String.valueOf(key).trim()));
            }
            /*for (Map.Entry<Object,Object> entry:properties.entrySet()){
                CONFIGMAP.put((String) entry.getKey(), (String) entry.getValue());

            }*/
        } catch (FileNotFoundException e) {
            throw new InvalidPathForPropertyFileException("Property file is not found");
        } catch (IOException e) {
            throw new FrameworkException("Something Wrong happen in property Utils");
        }
    }

    public static String get(ConfigProperties key)  {
        if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))){
            throw new PropertyFileUsageException("Property name " + key + "is not found. Please check config properties");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }

   /* public static String getValue(String key) throws Exception {
        if (Objects.isNull(properties.getProperty(key)) || Objects.isNull(key)) {
            throw new Exception("Property name " + key + "is not found. Please check config properties");
        }
        return properties.getProperty(key);
    }*/
}
