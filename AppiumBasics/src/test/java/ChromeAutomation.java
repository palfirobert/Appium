import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ChromeAutomation extends AppiumConfigurationChrome{

    @Test
    public void testChrome() throws InterruptedException {
         driver.get("https://www.google.com");
         Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()='" + "Read more" + "']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='" + "Read more" + "']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='" + "Accept all" + "']")).click();
         driver.findElement(By.name("q")).sendKeys("Bill Gates is real?");
         driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
         Thread.sleep(3000);
    }
}
