package com.ti.test;

import com.ti.library.TestLibrary;
import org.example.framework.base.BrowserType;
import org.example.framework.base.DriverFactory;
import org.example.framework.config.PropertyManager;
import org.example.framework.util.logs.Log;
import org.example.framework.util.video.VideoRecorder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import static org.example.framework.config.Constants.VIDEO_FOLDER;
import static org.example.framework.util.ui.WaitUtil.driver;

public class BaseTest extends TestLibrary {
    protected static VideoRecorder videoRec;
    String baseURL = "http://localhost/DkGames/";



    @BeforeTest
    @Parameters("browser")
    void setup(String browser){
        videoRec = new VideoRecorder();
        //Arrange
        DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser));
        if(Boolean.parseBoolean(PropertyManager.getInstance().getProperty("video"))){
            videoRec.startRecording(VIDEO_FOLDER);
        }
        DriverFactory.getInstance().getDriver().navigate().to(baseURL);
        Log.info("Test is starting!");





    }
    @AfterTest
    void turnDown() throws Exception {
        Log.info("Test are ending!");
        DriverFactory.getInstance().removeDriver();
        if(videoRec!= null){
            videoRec.stopRecording();
        }
    }
}
