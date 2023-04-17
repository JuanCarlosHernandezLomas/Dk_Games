package org.example.framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    private static PropertyManager instance;
    private static final  Object lock = new Object();
    private  static String FilePath = System.getProperty("user.dir") + "/src/main/resources/config.properties";

    private Properties properties = new Properties();

    public  static  PropertyManager getInstance(){
        if(instance==null){
            synchronized (lock){
                instance =new PropertyManager();
                instance.loadDate();
            }
        }
        return instance;
    }
    private void loadDate(){
        try{
            properties.load(new FileInputStream((FilePath)));
        }catch (IOException e){
            System.err.println("Class: PropertyManager | Method: loadData | Exception:" +e.getMessage());
        }
    }

    public String getProperty(String aproperty){
        return properties.getProperty(aproperty);

    }
}
