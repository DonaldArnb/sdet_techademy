package actions;

import utils.BaseClass;
 
public class ABTestingPageActions {
 
     public String PageSource() {
    	 return BaseClass.getDriver().getPageSource();
     }
}