package com.ti.testdata;

import org.example.framework.config.PropertyManager;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.example.framework.data.JSONUtil.getJSONTableArray;

public class DataClass {
    static Object[][] testObjArray;

    private static String jsonFile = PropertyManager.getInstance().getProperty("JSONFile");

    @DataProvider(name = "User")
    public static Object[][] getDataFromJSON() throws IOException, ParseException {
        return getJSONTableArray(jsonFile, "validUser", (byte) 2);
    }
}
