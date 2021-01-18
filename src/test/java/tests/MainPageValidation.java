package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPageHelper;


public class MainPageValidation extends TestBase{
    MainPageHelper mainPageHelper;
    String cityFrom = "Tel-Aviv";
    String cityTo = "Sochi";


    @BeforeMethod
    public void unitTests(){
        mainPageHelper = PageFactory.initElements(driver, MainPageHelper.class);
    }

    @Test(priority = 2, groups = "UI")
    public void isSloganDisplayedTest() throws InterruptedException {
        Thread.sleep(5000);
        assert mainPageHelper.sloganContainText();
    }

    @Test (priority = 2, groups = "UI")
    public void isHomeButtonDisplayedTest(){
      assert  mainPageHelper.isHomeButtonExist();
    }

    @Test(priority = 1, groups = {"functional", "searchResult"})
    public void isSearchResultDisplayedTest() throws InterruptedException {
        mainPageHelper.inputCityToFieldFrom(cityFrom);
        mainPageHelper.inputCityToFieldTo(cityTo);
        mainPageHelper.clickOnLetsGoButton();
        mainPageHelper.returnToHomePage();
       // assert mainPageHelper.isResultDisplayed();
    }

    @Test(priority = 2, groups = "UI")
    public void isLetsGoButtonDisplayed(){
        assert mainPageHelper.isLetsGoButtonExist();
    }

    @Test(priority = 2, groups = "UI")
    public void isClearButtonDisplayed(){
        assert mainPageHelper.isClearButtonExist();
    }

    @Test(priority = 1, groups = "functional")
    public void isSearchResultDeletedTest() throws InterruptedException {
        mainPageHelper.inputCityToFieldFrom(cityFrom);
        mainPageHelper.inputCityToFieldTo(cityTo);
        mainPageHelper.clickOnClearButton();
        assert mainPageHelper.isInputCityToFieldToClear();
        assert mainPageHelper.isInputCityToFieldFromClear();
    }

    @Test(priority = 1,groups = "functional")
    public void clearCityByClickingOnStartPointIconTest(){
        mainPageHelper.inputCityToFieldFrom(cityFrom);
        mainPageHelper.clickOnStartPointIcon();
        assert mainPageHelper.isInputCityToFieldToClear();
    }

    @Test(priority = 1, groups = "functional")
    public void clearCityByClickingOnEndPointIconTest() throws InterruptedException {
        mainPageHelper.inputCityToFieldTo(cityTo);
        mainPageHelper.clickOnEndPointIcon();
        assert mainPageHelper.isInputCityToFieldFromClear();
    }

    @Test(priority = 1, groups = {"functional", "searchResult"}, dataProvider = "validCities", dataProviderClass = DataProviders.class)
    public void isSearchResultDisplayedFromDataProviderTest(String cityFromFromDataProvider, String cityToFromDataProvider) throws InterruptedException {
        mainPageHelper.inputCityToFieldFrom(cityFromFromDataProvider);
        mainPageHelper.inputCityToFieldTo(cityToFromDataProvider);
        mainPageHelper.clickOnLetsGoButton();
        mainPageHelper.returnToHomePage();
        //assert mainPageHelper.isResultDisplayed();
    }





}
