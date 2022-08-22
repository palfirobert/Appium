import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AppiumLongPress extends AppiumConfiguration {
    @Test
    public void AppiumTest() throws MalformedURLException, InterruptedException {
        initializeAppiumServer();
        openApp();

        //automotion
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        RemoteWebElement element= (RemoteWebElement) driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        longPress(element);
        Thread.sleep(2000);

        //Verificare daca este afisat

        //met 1
        String menuText=driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals(menuText,"Sample menu");

        //met 2
        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());


        //NOTE: -asert se foloseste la teste

        stopServers();
    }
}
