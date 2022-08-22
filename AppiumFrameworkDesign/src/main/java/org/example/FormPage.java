package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class FormPage extends AndroidGestures{
   AndroidDriver driver;

    public FormPage(AndroidDriver androidDriver) {
        super(androidDriver);
        this.driver=androidDriver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
    private WebElement country;

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    private WebElement shopButton;

    @AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
    private WebElement maleRadioButton;

    @AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleRadioButton;

    public void setNameField(String name) {
        nameField.sendKeys(name);
        driver.hideKeyboard();
    }

    public void waitUntilFirstPageAppears()
    {
        WebDriverWait waitAtTheStart=new WebDriverWait(driver, Duration.ofSeconds(5));
        waitAtTheStart.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","General Store"));
    }
    public void selectCountry(String countryName)
    {
        country.click();
        scroll(countryName);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();

    }
    public void clickShoppingButton()
    {
        shopButton.click();
    }
    public void setGender(GENDER gender)
    {
        if(gender.equals(GENDER.MALE))
            maleRadioButton.click();
        else
            femaleRadioButton.click();
    }

    public List<HashMap<String,String>> getJsonData(String jsonFilePath) throws IOException {
        String jsonContent= FileUtils.readFileToString(new File(jsonFilePath));
        ObjectMapper mapper= new ObjectMapper();
        List<HashMap<String,String>>data=mapper.readValue(jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {
                });
        return data;
    }



}
