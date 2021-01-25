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

    @Test(priority = 2, groups = "UI")
    public void isLetsGoButtonDisplayed(){
        assert mainPageHelper.isLetsGoButtonExist();
    }

    @Test(priority = 2, groups = "UI")
    public void isClearButtonDisplayed(){
        assert mainPageHelper.isClearButtonExist();
    }

    @Test(priority = 1, groups = "functional")
    public void isSearchResultDeletedTest(){
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
    public void clearCityByClickingOnEndPointIconTest(){
        mainPageHelper.inputCityToFieldTo(cityTo);
        mainPageHelper.clickOnEndPointIcon();
        assert mainPageHelper.isInputCityToFieldFromClear();
    }

    @Test(priority = 2, groups = "functional")
    public void checkTheTotalCostOfRouteTest(){
        mainPageHelper.inputCityToFieldFrom(cityFrom);
        mainPageHelper.inputCityToFieldTo(cityTo);
        mainPageHelper.clickOnLetsGoButton();
        mainPageHelper.checkTotalCostOfTheRoute();
    }
}
