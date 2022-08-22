package org.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {
    public ExtentReports extent;
    @BeforeTest
    public void config(){
        String path=System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Result");
        reporter.config().setDocumentTitle("Test Results");

        extent=new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Palfi Robert");

    }

    @Test
    public void initialDemo()
    {   ExtentTest test=extent.createTest("Initial Demo");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\palfi\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());

        extent.flush();
    }
}
