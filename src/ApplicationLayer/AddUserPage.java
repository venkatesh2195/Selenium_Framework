package ApplicationLayer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
public class AddUserPage {
	WebDriver driver;
	Actions ac;
	public AddUserPage(WebDriver driver)
	{
		this.driver=driver;
	}
	//define OR
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement ObjAdmin;
	@FindBy(id="menu_admin_UserManagement")
	WebElement Objusermngmnt;
	@FindBy(id="menu_admin_viewSystemUsers")
	WebElement Objuser;
	@FindBy(id="btnAdd")
	WebElement Objadd;
	@FindBy(id="systemUser_employeeName_empName")
	WebElement ename;
	@FindBy(id="systemUser_userName")
	WebElement objusername;
	@FindBy(id="systemUser_password")
	WebElement objpassword;
	@FindBy(id="systemUser_confirmPassword")
	WebElement objcpassword;
	@FindBy(id="btnSave")
	WebElement Objsave;
	public void verifyAdduser(String ename,String username,String password,String cpassword)
			throws Throwable{
		ac=new Actions(driver);
		ac.moveToElement(ObjAdmin).perform();
		Thread.sleep(4000);
		ac.moveToElement(Objusermngmnt).perform();
		Thread.sleep(4000);
		ac.moveToElement(Objuser).click().perform();
		Thread.sleep(4000);
		ac.moveToElement(Objadd).click().perform();
		Thread.sleep(4000);
		this.ename.sendKeys(ename);
		this.objusername.sendKeys(username);
		this.objpassword.sendKeys(password);
		this.objcpassword.sendKeys(cpassword);
		ac.moveToElement(Objsave).click().perform();
		Thread.sleep(5000);
	}
}















