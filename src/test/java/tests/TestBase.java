package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    Logger logger = LoggerFactory.getLogger(TestBase.class);
   // AppiumDriver driver;


   /* @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();//создаем объект
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");//указываем версию Android
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");//Имя OS
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung_Galaxy_S7");//Сообщаем, что будет использоваться эмулятор
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome"); //для запуска браузера
        capabilities.setCapability("ChromedriverExecutable", "C:/Tools/chromedriver");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://lowcoststrip.com/search");

    }*/
   @BeforeMethod(alwaysRun = true)
   public void startTest(Method m, Object[] p){
       logger.info("Start test: " + m.getName());
       if(p.length != 0) {
           logger.info(" --> With data: " + Arrays.asList(p));
       }
   }


    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1200");
        driver = new ChromeDriver(options);
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://lowcoststrip.com/search");
    }

    @AfterMethod
    public void quit(ITestResult result){
        driver.quit();
        if(result.isSuccess()){
            logger.info("Test result: PASSED");
        }else{
            logger.error("Test result: FAILED");
        }
        logger.info("Stop test: " + result.getMethod().getMethodName());
        logger.info("======================================================");
    }




}
