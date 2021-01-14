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
        mainPageHelper.isHomeButtonExist();
    }

    @Test(priority = 1, groups = {"functional", "searchResult"})
    public void isSearchResultDisplayedTest() throws InterruptedException {
        mainPageHelper.inputCityToFieldFrom(cityFrom);
        mainPageHelper.inputCityToFieldTo(cityTo);
        mainPageHelper.clickOnLetsGoButton();
        //assert mainPageHelper.isResultDisplayed();
    }

    @Test(priority = 2)
    public void isLetsGoButtonDisplayed(){
        mainPageHelper.isLetsGoButtonExist();
    }

    @Test(priority = 2)
    public void isClearButtonDisplayed(){
        mainPageHelper.isClearButtonExist();
    }

    @Test
    public void isSearchResultDeletedTest() throws InterruptedException {
        mainPageHelper.inputCityToFieldFrom(cityFrom);
        mainPageHelper.inputCityToFieldTo(cityTo);
        mainPageHelper.clickOnClearButton();
    }

    @Test
    public void clearCityByClickingOnStartPointIconTest(){
        mainPageHelper.inputCityToFieldFrom(cityFrom);
        mainPageHelper.clickOnStartPointIcon();
        
    }

    @Test
    public void clearCityByClickingOnEndPointIconTest() throws InterruptedException {
        mainPageHelper.inputCityToFieldTo(cityTo);
        mainPageHelper.clickOnEndPointIcon();
    }





}
