package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.BaseClass;
 
public class FramesPageActions {
	   
	   
	   public boolean validateLinks(String link_name) {
		    List<WebElement> frames_links = BaseClass.getDriver().findElements(By.tagName("a"));
		    for (WebElement link : frames_links) {
		    	if(link.getText().equals(link_name))
		    		return true;
		    }
			return false;
			
	   }
	    

}