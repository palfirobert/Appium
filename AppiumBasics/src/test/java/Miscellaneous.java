import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

public class Miscellaneous extends AppiumConfiguration{
    @Test
    public void testMiscellaneous() throws InterruptedException   // invartire telefon,copy,paste,apasat home,back,enter
    {
        Activity activity=new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
        driver.startActivity(activity);
        //driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        //driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.rotate(landScape);
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        driver.setClipboardText("Milsugi");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.findElement(By.id("android:id/button1")).click();
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        Thread.sleep(2000);
    }
}
