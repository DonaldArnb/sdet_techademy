package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
 
public class DropDownPageLocators {
 
      @FindBy(xpath = "//*[@id='dropdown']")
      public WebElement DropDown;
}