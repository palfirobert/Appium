package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage extends AndroidGestures{
    private AndroidDriver driver;
    private int numberOfElementsInCart;
    public CartPage(AndroidDriver androidDriver) throws InterruptedException {
        super(androidDriver);
        this.driver=androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
        Thread.sleep(1000);

    }

    private void addElementsFromTheCart()
    {

        numberOfElementsInCart=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for(int i=0;i<numberOfElementsInCart;i++)
        {
            elementsInTheCart.add(driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText());
        }

    }
    @AndroidFindBy(xpath = "//android.widget.CheckBox")
    private WebElement checkBox;

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
    private WebElement proceedButton;

    public void verifyIfTheElementsFromTheCartAreTheSameAsTheOnesThatWereAdded()
    {   addElementsFromTheCart();

        Assert.assertEquals(elementsAddedToTheCart,elementsInTheCart);
    }

    public void verifyTheSumInTheCart()
    {
        float sumOfElements=0;
        for(int i=0;i<numberOfElementsInCart;i++)
        {   String numberInStringForm=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
            sumOfElements=sumOfElements+Float.parseFloat(numberInStringForm.substring(1));
        }
        float totalSumOfElements=Float.parseFloat(driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1));
        Assert.assertEquals(sumOfElements,totalSumOfElements);
    }

    public void clickCheckBox()
    {
        checkBox.click();
    }
    public  void clickProceedButton()
    {
        proceedButton.click();
    }



}
