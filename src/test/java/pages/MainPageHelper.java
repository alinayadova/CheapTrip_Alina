package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(css = "#mat-expansion-panel-header-2")
    WebElement resultForm;

    @FindBy(css = ".mat-form-field-flex")
    WebElement toFieldClear;

    @FindBy(css =".mat-form-field-flex")
    WebElement fromFieldClear;


    public boolean sloganContainText() {
       return slogan.getText().contains("CHEAP TRIP. PAY LESS, VISIT MORE!");
    }

    public boolean isHomeButtonExist() {
        return homeButton.isDisplayed();
    }

    public void inputCityToFieldFrom(String city){
        fromField.sendKeys(city);
    }

    public void inputCityToFieldTo(String city) throws InterruptedException {
        toField.sendKeys(city);
        Thread.sleep(5000);
    }

    public void clickOnLetsGoButton() throws InterruptedException {
        letsGoButton.click();
        Thread.sleep(5000);
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
        return resultForm.isDisplayed();
    }

    public boolean isInputCityToFieldToClear() {
      return toFieldClear.isDisplayed();
    }

    public boolean isInputCityToFieldFromClear() {
        return fromFieldClear.isDisplayed();
    }
}
