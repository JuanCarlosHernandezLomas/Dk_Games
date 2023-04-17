package org.example.framework.data;

import org.example.framework.config.PropertyManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.example.framework.config.Constants.DATA_FOLDER;

public class JSONUtil{
    private static String jsonFile = PropertyManager.getInstance().getProperty("JSONFile");
    private static JSONArray dataObj;
    private static JSONObject contentOBj;

    public static Object[][] getJSONTableArray(String jsonFile, String userType,byte JSONAttributes) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        contentOBj = (JSONObject) parser.parse(new FileReader((DATA_FOLDER +jsonFile)));
        dataObj = (JSONArray) contentOBj.get(userType);

        Object[][] arr= new String[dataObj.size()][JSONAttributes];
                for(byte i=0; i<dataObj.size();i++){
                    JSONObject obj = (JSONObject) dataObj.get(i);
                    arr[i][0] =String.valueOf(obj.get("user"));
                    arr[i][1] =String.valueOf(obj.get("password"));
                    if (JSONAttributes==3){
                        arr[i][2] = String.valueOf(obj.get("error"));
                    }


                }
                return arr;
    }
}
