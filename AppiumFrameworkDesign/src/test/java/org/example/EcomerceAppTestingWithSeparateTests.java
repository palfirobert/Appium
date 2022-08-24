package org.example;

import TestUtils.AppiumConfiguration;
import io.appium.java_client.android.Activity;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class EcomerceAppTestingWithSeparateTests extends AppiumConfiguration {
// ca sa pornesti toate testele se face cu testng.xml in eclipse
    @Test(priority = 1,dataProvider = "dataForFormPage",groups = {"Smoke"}) //groups se foloseste pentru anumite teste ce trb rulate in testNg_Smoke.xml
    public void formPageTest(String name,GENDER gender,String country) throws InterruptedException {
        Thread.sleep(4000);


        //formPage.waitUntilFirstPageAppears();
        preSetup();    // prima data incearca toate variantele de la data provider apoi trece la urmatorul test
        formPage.setGender(gender);
        formPage.selectCountry(country);
        formPage.setNameField(name);
        formPage.clickShoppingButton();
    }

    @Test(priority = 2)
    public void productCatalogueTest()
    {
        productCatalogue.scrollAndSelectItemToAddToCart("NikeBlazer Mid '77");
        productCatalogue.scrollAndSelectItemToAddToCart("PG 3");
        productCatalogue.goToCart();
    }


    @Test(priority = 3)
    public void cartPageTest()
    {
        cartPage.verifyIfTheElementsFromTheCartAreTheSameAsTheOnesThatWereAdded();
        cartPage.verifyTheSumInTheCart();
        cartPage.clickCheckBox();
        cartPage.clickProceedButton();
    }

    @DataProvider(name="dataForFormPage")  //aici se dau valori
    public Object[] getData() throws IOException {

        return new Object[][]{{"Palfi Robert",GENDER.FEMALE,"Argentina"},{"Marius",GENDER.MALE,"Albania"}};


    }


    public void preSetup()
    {
        Activity activity=new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
        driver.startActivity(activity);
    }



}
