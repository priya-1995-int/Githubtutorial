/**
 * 
 */
package pages;

import org.openqa.selenium.By;

/**
 * @author Naveen.S
 *
 */
public class LoginPage extends BasePage{

	By username= By.id("user_login");
	By password= By.id("user_password");
	By signinbutton= By.name("submit");
	
	public void doLogin(String uname,String pword)
	{
		enterText(username,uname);
		enterText(password,pword);
		performClick(signinbutton);
	}
}
