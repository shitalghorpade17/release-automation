package org.fa.automation.pages;

import org.fa.automation.utils.GuiControl;

/**
 * Created by Forgeahead-Shital on 9/14/2017.
 */
public class LoginPage extends BasePage{
    GuiControl txtUsername= new GuiControl(elementMap.get("username"));
    GuiControl txtPassword= new GuiControl(elementMap.get("password"));
     GuiControl btnNext = new GuiControl(elementMap.get("usernameNext"));

   public  void clickOnLoginButton(){
       btnNext.click();
   }
}
