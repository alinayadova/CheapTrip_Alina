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

    @FindBy()
    WebElement startPoint;

    @FindBy()
    WebElement endPoint;


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

    public void clickOnLetsGoButton() {
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
}
