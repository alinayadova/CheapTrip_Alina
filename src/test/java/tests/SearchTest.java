package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPageHelper;

public class SearchTest extends TestBase{
    MainPageHelper mainPageHelper;
    String cityFrom = "Tel-Aviv";
    String cityTo = "Sochi";


    @BeforeMethod
    public void unitTests(){
        mainPageHelper = PageFactory.initElements(driver, MainPageHelper.class);
    }


    @Test(priority = 1, groups = {"functional", "searchResult"})
    public void isSearchResultDisplayedTest(){
        mainPageHelper.inputCityToFieldFrom(cityFrom);
        mainPageHelper.inputCityToFieldTo(cityTo);
        mainPageHelper.clickOnLetsGoButton();
        assert mainPageHelper.isResultDisplayed();
    }

    @Test(priority = 1, groups = {"functional", "searchResult"}, dataProvider = "validCities", dataProviderClass = DataProviders.class)
    public void isSearchResultDisplayedFromDataProviderTest(String cityFromFromDataProvider, String cityToFromDataProvider){
        mainPageHelper.inputCityToFieldFrom(cityFromFromDataProvider);
        mainPageHelper.inputCityToFieldTo(cityToFromDataProvider);
        mainPageHelper.clickOnLetsGoButton();
        mainPageHelper.returnToHomePage();
        assert mainPageHelper.isResultDisplayed();
    }

    @Test(priority = 1, groups = {"functional", "searchResult"}, dataProvider = "validCitiesUsingCSV", dataProviderClass = DataProviders.class)
    public void isSearchResultDisplayedTestFromDataProviderUsingCSVTest(String cityFromFromDataProvider, String cityToFromDataProvider){
        mainPageHelper.inputCityToFieldFrom(cityFromFromDataProvider);
        mainPageHelper.inputCityToFieldTo(cityToFromDataProvider);
        mainPageHelper.clickOnLetsGoButton();
        mainPageHelper.returnToHomePage();

        Assert.assertTrue(mainPageHelper.isResultDisplayed(),"Search result for cities:" + cityFrom + ", " +cityTo + " cities don't exist in dataBase!");
    }
}
