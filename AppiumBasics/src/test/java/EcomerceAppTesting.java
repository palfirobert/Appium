import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EcomerceAppTesting extends AppiumConfiguration{
    private List<String>elementsAddedToTheCart=new ArrayList<>();
    private List<String>elementsInTheCart=new ArrayList<>();
    @Test
    public void fillFormAndVerifyToast() throws InterruptedException {  Thread.sleep(4000);
        WebDriverWait waitAtTheStart=new WebDriverWait(driver, Duration.ofSeconds(5));
        waitAtTheStart.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","General Store"));  //aici se asteapta pana apare pagina principala
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        scroll("Bahamas");
        driver.findElement(By.xpath("(//android.widget.TextView)[4]")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Robert");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        scroll("Nike Blazer Mid '77");
        int size=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        for(int i=0;i<size;i++)
        {
            if(driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText().equals("Nike Blazer Mid '77"))
            {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                elementsAddedToTheCart.add(driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText());
            }
        }

        scroll("PG 3");
        size=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        for(int i=0;i<size-1;i++)
        {
            if(driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText().equals("PG 3"))
            {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                elementsAddedToTheCart.add(driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText());
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        int numberOfElementsInCart=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        for(int i=0;i<numberOfElementsInCart;i++)
        {
            elementsInTheCart.add(driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText());
        }
        Assert.assertEquals(elementsAddedToTheCart,elementsInTheCart);
        float sumOfElements=0;
        for(int i=0;i<numberOfElementsInCart;i++)
        {   String numberInStringForm=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
            sumOfElements=sumOfElements+Float.parseFloat(numberInStringForm.substring(1));
        }
        float totalSumOfElements=Float.parseFloat(driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1));
        Assert.assertEquals(sumOfElements,totalSumOfElements);
        driver.findElement(By.xpath("//android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(5000);

        //cand intram in webview trebuie sa schimbam context-ul in webview (era android inainte)
        Set<String> contexts= driver.getContextHandles();
        for(String context:contexts)
            System.out.println(context);
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                "x",523,
                "y",1593
        ));

        //a fost nevoie sa iau chromeDriverul

    }


}
