package TestUtils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.example.CartPage;
import org.example.FormPage;
import org.example.ProductCatalogue;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumConfiguration {
     public AppiumDriverLocalService service;
     public AndroidDriver driver;
     public static DeviceRotation landScape=new DeviceRotation(0,0,90);
     protected FormPage formPage;
     protected ProductCatalogue productCatalogue;
     protected CartPage cartPage;
     @BeforeClass(alwaysRun = true)// in caz de teste selective
    public void initializeAppiumServer()
    {
        service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\palfi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
    }
     @BeforeClass(alwaysRun = true)
    public void openApp() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options=new UiAutomator2Options();

        options.setDeviceName("Pixel 2 API 30");
         //options.setApp("C:\\Java\\isp-labs-2022-palfi-robert-30123\\untitled\\src\\main\\resources\\ApiDemos-debug.apk");
        options.setApp("C:\\Java\\Appium\\AppiumFrameworkDesign\\General-Store.apk");
        options.setChromedriverExecutable("C:\\Users\\palfi\\OneDrive\\Desktop\\Java Android\\chromedriver.exe");
        driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        formPage=new FormPage(driver);
        productCatalogue=new ProductCatalogue(driver);
        cartPage=new CartPage(driver);

    }
@AfterClass(alwaysRun = true)
    public void stopServers()
    {
        driver.quit();
        service.stop();
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
    public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException {
        File source=driver.getScreenshotAs(OutputType.FILE);
        String destinationFile=System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
        FileUtils.copyFile(source,new File(destinationFile));
        return destinationFile;
    }
}
