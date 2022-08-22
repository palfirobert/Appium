package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalogue extends AndroidGestures{

    private AndroidDriver driver;

    public ProductCatalogue(AndroidDriver androidDriver)
    {
        super(androidDriver);
        this.driver=androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement buttonCart;

    public void scrollAndSelectItemToAddToCart(String nameOfTheItem)
    {
        scroll(nameOfTheItem);
        int size=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        for(int i=0;i<size;i++)
        {
            if(driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText().equals(nameOfTheItem))
            {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                elementsAddedToTheCart.add(driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText());
            }
        }
    }

    public void goToCart()
    {
        buttonCart.click();
        System.out.println(elementsAddedToTheCart.size());
    }



}
