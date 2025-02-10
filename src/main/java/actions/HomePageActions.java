package actions;

import locators.HomePageLocators;
import utils.BaseClass;
import org.openqa.selenium.support.PageFactory;
 
public class HomePageActions {
 
    HomePageLocators homePageLocators;
    public HomePageActions() {
 
        this.homePageLocators = new HomePageLocators();
 
        PageFactory.initElements(BaseClass.getDriver(),homePageLocators);
    }
    
    public String getTitle()
    {
    	
    	return BaseClass.getDriver().getTitle();
    	
    }
    
    public void ABTestingLink() {
    	homePageLocators.ABTestingLink.click();
    }
    
    public void DropDownLink() {
    	homePageLocators.Dropdown.click();
    }
    
    public void FramesLink() {
    	homePageLocators.Frames.click();
    }
    
}