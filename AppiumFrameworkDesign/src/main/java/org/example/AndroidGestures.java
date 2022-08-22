package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.ArrayList;
import java.util.List;

public class AndroidGestures{
    public AndroidDriver driver;
    protected static List<String> elementsAddedToTheCart=new ArrayList<>();
    protected static List<String>elementsInTheCart=new ArrayList<>();
    public AndroidGestures(AndroidDriver androidDriver)
    {
        this.driver=androidDriver;
    }

    public void longPress(RemoteWebElement element)
    {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),"duration",2000
        ));
    }

    public void scroll(String name)
    {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+name+"\"));"));
    }

    public void swipe(RemoteWebElement element)
    {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement) element).getId(),"direction", "left",
                "percent", 0.75
        ));
    }
}
