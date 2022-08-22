import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AppiumScroll extends AppiumConfiguration{
    @Test
    public void scrollTest() throws MalformedURLException, InterruptedException {  initializeAppiumServer();
        openApp();
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        scroll("Lists");
        Thread.sleep(3000);
        stopServers();
    }
}
