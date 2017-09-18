package org.fa.automation.testscripts;

import org.fa.automation.pages.LoginPage;
import org.testng.annotations.Test;

/**
 * Created by Forgeahead-Shital on 9/15/2017.
 */
public class LoginTest {
    @Test
    public void testLogin(){
        new LoginPage().clickOnLoginButton();
    }
}
