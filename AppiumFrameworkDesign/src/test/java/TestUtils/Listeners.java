package TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener { //se baga in testng.xml
    ExtentReports extent=ExtentReportNG.getExtentReport();
    ExtentTest test; //holds information about the particular test (legat de report)
    @Override
    public void onTestStart(ITestResult result) {  //result are informatii despre test
        test=extent.createTest(result.getMethod().getMethodName());  //incepe citirea de catre extent report
    }

    @Override
    public void onTestSuccess(ITestResult result) {
       test.log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
       test.fail(result.getThrowable()); //forteaza sa fie marcat ca o eroare + arata eroarea
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); //inchide citirea
    }
}