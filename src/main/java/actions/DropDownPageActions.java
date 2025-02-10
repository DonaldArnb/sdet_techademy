package actions;

import locators.DropDownPageLocators;
import utils.BaseClass;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
 
public class DropDownPageActions {
	   DropDownPageLocators dropDownPageLocators;
	   Select options;

	   public DropDownPageActions() {
	        this.dropDownPageLocators = new DropDownPageLocators();
	        PageFactory.initElements(BaseClass.getDriver(),dropDownPageLocators);
	    }
	   
	   public void selectOption_1(String x) {
		   options=new Select(dropDownPageLocators.DropDown);
		   options.selectByVisibleText(x);
		   
		   
	   }
	   
	   public String selectedOption() {
		   return options.getFirstSelectedOption().getText();
	   }
	    

}