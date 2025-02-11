package utils;
 
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
 
public class BaseClass {
 
     private static BaseClass helperClass;
      
      public static WebDriver driver;
        public final static int TIMEOUT = 5;
           
          BaseClass() {
                
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
         }      
                   
        public static void openPage(String url) {
            driver.get(url);
        }
               
        public static WebDriver getDriver() {
            return driver;              
        }
           
        public static void setUpDriver() {
               
            if (helperClass==null) {
                   
                helperClass = new BaseClass();
            }
        }
           
        public static void tearDown() {
                
            if(driver!=null) {
                 driver.quit();
            }
                
           helperClass = null;
       } 
           
    }