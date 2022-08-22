import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class Assignment1 extends AppiumConfiguration{
    @Test
    public void testAssignment1() throws InterruptedException {
        //automation
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
        Thread.sleep(1000);

        driver.findElement(AppiumBy.id("android:id/button1")).click();
        driver.findElement(AppiumBy.accessibilityId("Repeat alarm")).click();
        driver.findElement(By.xpath("(//android.widget.CheckedTextView)[2]")).click();
        driver.findElement(By.xpath("(//android.widget.CheckedTextView)[4]")).click();
        driver.findElement(AppiumBy.id("android:id/button1")).click();

        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with ultra long message")).click();



    }
}
