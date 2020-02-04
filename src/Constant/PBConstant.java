package Constant;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class PBConstant {
public static Properties p;
public static FileInputStream fi;
public static WebDriver driver;
@BeforeMethod
public void setUp()throws Throwable
{
p=new Properties();
fi=new FileInputStream("D:\\December_Selenium\\Selenium_Framework\\PropertyFiles\\PrimusBank.properties");
p.load(fi);
if(p.getProperty("browser").equalsIgnoreCase("chrome"))
{
System.setProperty("webdriver.chrome.driver", "D:\\December_Selenium\\Selenium_Framework\\CommonDrivers\\chromedriver.exe");
driver=new ChromeDriver();
driver.get(p.getProperty("Url"));
driver.manage().window().maximize();
}
else if(p.getProperty("browser").equalsIgnoreCase("firefox"))
{
System.setProperty("webdriver.gecko.driver", "D:\\December_Selenium\\Selenium_Frameworks\\CommonDrivers\\geckodriver.exe");
driver=new FirefoxDriver();
driver.get(p.getProperty("Url"));	
}
else
{
System.out.println("browser not matching");
}
}
@AfterMethod
public void tearDown()
{
	driver.close();
}
}


























