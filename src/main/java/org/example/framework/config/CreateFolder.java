package org.example.framework.config;


import org.example.framework.base.FrameworkException;
import org.example.framework.util.logs.Log;

import java.io.File;

public class CreateFolder {
    public static String createFolder(String folderName) throws FrameworkException {
        File dir = new File (folderName);
        if(!dir.exists()){
            Log.info("creating directorY:" +dir.getName());
        try {
            dir.mkdir();
            Log.info("Foler created!");
        }catch (SecurityException se ){
            throw  new FrameworkException("Class CreateFolder| Method sreateFolder | Exception: "+se.getMessage());
        }
        }
        return  dir.toString();
    }
}
