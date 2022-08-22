package org.example;

import TestUtils.AppiumConfiguration;
import io.appium.java_client.android.Activity;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class EcomerceAppTesting extends AppiumConfiguration {

    @Test(dataProvider ="getData")
    public void fillFormAndVerifyToast(HashMap<String,String> input) throws InterruptedException {//String name,GENDER gender,String country
        Thread.sleep(4000);


        formPage.waitUntilFirstPageAppears();
        formPage.setGender(GENDER.valueOf(input.get("gender")));
        formPage.selectCountry(input.get("country"));
        formPage.setNameField(input.get("name"));
        formPage.clickShoppingButton();


        productCatalogue.scrollAndSelectItemToAddToCart("Nike Blazer Mid '77");
        productCatalogue.scrollAndSelectItemToAddToCart("PG 3");
        productCatalogue.goToCart();

        cartPage.verifyIfTheElementsFromTheCartAreTheSameAsTheOnesThatWereAdded();
        cartPage.verifyTheSumInTheCart();
        cartPage.clickCheckBox();
        cartPage.clickProceedButton();


    }

    @DataProvider  //aici se dau valori
    public Object[] getData() throws IOException {
        List<HashMap<String,String>>data=formPage.getJsonData("C:\\Java\\isp-labs-2022-palfi-robert-30123\\AppiumFrameworkDesign\\src\\test\\testData\\eComerceData.json");
        //return new Object[][]{{"Palfi Robert",GENDER.FEMALE,"Argentina"},{"Marius",GENDER.MALE,"Albania"}};
        return new Object[][]{{data.get(0)},{data.get(1)}};

    }

    @BeforeMethod
    public void preSetup()
    {
        Activity activity=new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
        driver.startActivity(activity);
    }


}
