package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MainPageHelper extends PageBase{
    public MainPageHelper(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "slogan")
    WebElement slogan;

    @FindBy(css = ".mat-button-wrapper .material-icons")
    WebElement homeButton;

    @FindBy(css = "#mat-input-0")
    WebElement fromField;

    @FindBy(css = "#mat-input-1")
    WebElement toField;

    @FindBy(css = ".actions .mat-primary")
    WebElement letsGoButton;

    @FindBy(css = ".actions .mat-accent")
    WebElement clearButton;

    @FindBy(css = "[mattooltip= 'Remove StartPoint']")
    WebElement startPoint;

    @FindBy(css = "[mattooltip= 'Remove EndPoint']")
    WebElement endPoint;

    @FindBy(className = "aside")
    WebElement resultForm;

    @FindBy(css = ".mat-form-field-flex")
    WebElement toFieldClear;

    @FindBy(css =".mat-form-field-flex")
    WebElement fromFieldClear;

    @FindBy(id = "mat-autocomplete-0")
    WebElement submitCityFromDropDownList;

    @FindBy(id = "mat-autocomplete-1")
    WebElement submitCityToDropDownList;

    @FindBy(css = ".mat-expansion-indicator")
    WebElement openDropList;

    @FindBy(tagName = "mat-chip")
    List<WebElement> totalCost;

    @FindBy(css = ".details")
    List<WebElement> routesList;




    public boolean sloganContainText() {
       return slogan.getText().contains("CHEAP TRIP. PAY LESS, VISIT MORE!");
    }

    public boolean isHomeButtonExist() {
        return homeButton.isDisplayed();
    }

    public void inputCityToFieldFrom(String city){
       fromField.sendKeys(city);
       waitUntilElementVisible(submitCityFromDropDownList, 10);
       submitCityFromDropDownList.click();
    }

    public void inputCityToFieldTo(String city){
        toField.sendKeys(city);
        waitUntilElementVisible(submitCityToDropDownList, 10);
        submitCityToDropDownList.click();
    }

    public void clickOnLetsGoButton(){
        letsGoButton.click();
    }

    public boolean isLetsGoButtonExist() {
        return letsGoButton.isDisplayed();
    }

    public void clickOnClearButton() {
        clearButton.click();
    }

    public boolean isClearButtonExist() {
        return clearButton.isDisplayed();
    }

    public void clickOnStartPointIcon() {
        startPoint.click();
    }

    public void clickOnEndPointIcon() {
        endPoint.click();
    }

    public void returnToHomePage() {
        homeButton.click();
    }

    public boolean isResultDisplayed() {
        waitUntilElementVisible(resultForm, 10);
        return resultForm.isDisplayed();
    }

    public boolean isInputCityToFieldToClear() {
      return toFieldClear.isDisplayed();
    }

    public boolean isInputCityToFieldFromClear() {
        return fromFieldClear.isDisplayed();
    }

    public void checkTotalCostOfTheRoute() {
        waitUntilElementVisible(resultForm, 10);
        openDropList.click();
        System.out.println(Double.parseDouble(totalCost.get(0).getText().substring(1)));
        System.out.println(routesList.get(0).findElement(By.xpath("//span[contains(text(),'€')]")).getText().substring(1));









    }
}
