package DriverFactory;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Utilities.ExcelFileUtil;
public class DataDrivenFramework {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	File screen;
	String inputpath="D:\\December_Selenium\\Selenium_Framework\\TestInput\\Employee.xlsx";
	String outputpath="D:\\December_Selenium\\Selenium_Framework\\TestOutput\\Results.xlsx";
	@BeforeTest
	public void adminlogin()
	{
		report=new ExtentReports("./Reports/Emp.html");
		System.setProperty("webdriver.chrome.driver", "D:\\December_Selenium\\Selenium_Framework\\PropertyFiles\\PrimusBank.properties");
		driver=new ChromeDriver();
		driver.get("http://orangehrm.qedgetech.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Qedge123!@#");
		driver.findElement(By.name("Submit")).sendKeys(Keys.ENTER);
	}
	@Test
	public void addEmployee()throws Throwable
	{
		//create reference object for excel methods class
		ExcelFileUtil xl=new ExcelFileUtil(inputpath);
		//count no of rows in a sheet
		int rc=xl.rowCount("Emp");
		//count no of columns in row
		int cc=xl.colCount("Emp");
		Reporter.log("no of rows are::"+rc+"  "+"no of columns in row are::"+cc,true);	
		for(int i=1;i<=rc;i++)
		{
			test=report.startTest("Add Employee");
			test.assignAuthor("Ranga QA Senior Manager");
			test.assignCategory("DataDriven Framework");
			//read firstname column data
			String fname=xl.getCellData("Emp", i, 0);
			String mname=xl.getCellData("Emp", i, 1);
			String lname=xl.getCellData("Emp", i, 2);
			driver.findElement(By.id("menu_pim_viewPimModule")).click();
			Thread.sleep(4000);
			driver.findElement(By.id("btnAdd")).click();
			Thread.sleep(4000);
			driver.findElement(By.name("firstName")).sendKeys(fname);
			driver.findElement(By.name("middleName")).sendKeys(mname);
			driver.findElement(By.name("lastName")).sendKeys(lname);
			driver.findElement(By.id("btnSave")).click();
			if(driver.getCurrentUrl().contains("empNumber"))
			{
				Reporter.log("Emp creation Success",true);
				test.log(LogStatus.PASS, "Emp creation Success");
				//write into resiulst column
				xl.setCelldata("Emp", i, 3, "Pass", outputpath);
			}
			else
			{
screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screen, new File("D:\\December_Selenium\\Selenium_Frameworks\\Screens\\"+i+"emp.png"));
				Reporter.log("Emp creation Fail",true);
				test.log(LogStatus.FAIL, "Emp creation Fail");
				xl.setCelldata("Emp", i, 3, "Fail", outputpath);
			}
			report.endTest(test);
			report.flush();
		}
	}
	@AfterTest
	public void tearDown()
	{
	driver.close();
 }
}
















