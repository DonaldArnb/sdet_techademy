package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
 
public class HomePageLocators {
 
      @FindBy(xpath = "//*[@href='/abtest']")
      public  WebElement ABTestingLink;
      
      @FindBy(xpath = "//*[@href='/dropdown']")
      public WebElement Dropdown;
 
      @FindBy(xpath = "//*[@href='/frames']")
      public WebElement Frames;
 
}