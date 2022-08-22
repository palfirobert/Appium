import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop extends AppiumConfiguration{
    @Test
    public void testDragAndDrop() throws InterruptedException {
        //automotion

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        RemoteWebElement element= (RemoteWebElement) driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 620,
                "endY", 552
        ));
        Assert.assertEquals(driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText(),"Dropped!");
        Thread.sleep(2000);

    }
}
