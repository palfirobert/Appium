import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasics extends AppiumConfiguration{
    @Test
    public void AppiumTest() throws MalformedURLException {
     //Appium server open automatically
        initializeAppiumServer();
     //Open the app
        openApp();

     //Automotion
      driver.findElement(AppiumBy.accessibilityId("Preference")).click();
      driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
      driver.findElement(By.id("android:id/checkbox")).click();
      driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
      driver.findElement(By.id("android:id/edit")).sendKeys("Milsugi");
      driver.findElement(By.id("android:id/button1")).click();
      //Stop servers
        stopServers();
    }
}
