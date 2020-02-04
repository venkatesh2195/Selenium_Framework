package ApplicationLayer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
public class LoginPage {
	WebDriver driver;
	Actions ac;
public LoginPage(WebDriver driver)
{
this.driver=driver;	
}
//OR For Login
@FindBy(id="txtUsername")
WebElement Objusername;
@FindBy(name="txtPassword")
WebElement Objpassword;
@FindBy(xpath="//input[@id='btnLogin']")
WebElement Objlogin;
public void verifyLogin(String username,String password)
{
	ac=new Actions(driver);
	Objusername.sendKeys(username);
	Objpassword.sendKeys(password);
	Objlogin.click();
}
}















