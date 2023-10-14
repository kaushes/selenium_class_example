package pom.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class TestNGUtil {

    protected WebDriver driver;

    protected ExtentReports extent = new ExtentReports();
    protected ExtentSparkReporter spark = new ExtentSparkReporter("reports/Spark.html");

    @BeforeTest
    public void createReport(){
        extent.attachReporter(spark);
    }
    @BeforeMethod
    @Parameters({"browser"})
    public void initBrowser(@Optional("chrome") String browser){

        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("wrong browser");
        }
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser(){

        driver.quit();
    }

    @AfterTest
    public void flushReport(){
        extent.flush();
    }
}
