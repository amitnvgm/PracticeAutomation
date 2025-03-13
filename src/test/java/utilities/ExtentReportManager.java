package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.Baseclass;


public class ExtentReportManager implements ITestListener
{
		
	public ExtentSparkReporter sparkReporter; // UI of the report
	public ExtentReports extent; // populate common info in reports 
	public ExtentTest test; // create test case entries in reports and update status of the test methods
	String repName;
	public void onStart(ITestContext context) 
		{
			String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			repName = "Test-Report-" + timestamp + ".html"; 
		    sparkReporter = new ExtentSparkReporter(".\\reports\\"+repName); //specify location of the reports
		    
		    sparkReporter.config().setDocumentTitle("Practice Automation Report"); //Title of Report
		    sparkReporter.config().setReportName(" Practice AutomationTesting"); // Name of Report
		    sparkReporter.config().setTheme(Theme.DARK);
		   
		    
		    extent = new ExtentReports();
		    extent.attachReporter(sparkReporter);
		    
		    extent.setSystemInfo("Application", "OpenCart");
		    extent.setSystemInfo("Module", "Admin");
		    extent.setSystemInfo("Sub-Module", "Customers");
		    extent.setSystemInfo("User name", System.getProperty("user.name"));
		    extent.setSystemInfo("Environment", "QA");
		    
		    String os = context.getCurrentXmlTest().getParameter("os");
		    extent.setSystemInfo("Operating System", os);
		    
		    String browser = context.getCurrentXmlTest().getParameter("browser");
		    extent.setSystemInfo("Browser", browser);
		    
		    List<String> includedgrops=context.getCurrentXmlTest().getIncludedGroups();
		    if(!includedgrops.isEmpty())
		    {
		    	extent.setSystemInfo("Groups", includedgrops.toString());
		    }
		    
		}
		
		
		
		public void onTestSuccess(ITestResult result) 
		{
			test=extent.createTest(result.getTestClass().getName()); //create a new entry in report
			test.assignCategory(result.getMethod().getGroups()); // to display groups in Reports
		    test.log(Status.PASS , result.getName() + " Successfully Executed" );
		}
		
		public void onTestFailure(ITestResult result) 
		{
			test=extent.createTest(result.getTestClass().getName()); //create a new entry in report
			test.assignCategory(result.getMethod().getGroups());
		    test.log(Status.FAIL, result.getName() + " test case failed  ");
		    test.log(Status.INFO,result.getThrowable().getMessage());
		    
		    try
		    {
		    String imgPath = new Baseclass().captureScreen(result.getName());
		    test.addScreenCaptureFromPath(imgPath,"Screenshot on failure");
		    }catch(Exception e)
		    {
		    	e.printStackTrace();
		    }
		    
		    
		}
		
		public void onTestSkipped(ITestResult result) 
		{
			test=extent.createTest(result.getTestClass().getName()); 
			test.assignCategory(result.getMethod().getGroups()); 
			test.log(Status.SKIP, result.getName() + " test case skipped is");
			test.log(Status.INFO,result.getThrowable().getMessage());
		}
		
		public void onFinish(ITestContext context) 
		 {
			    extent.flush();
			    
			    /*
			    String pathofExtentReport = System.getProperty("user.dir")+"\\reports\\" +repName;
			    File extentReport = new File(pathofExtentReport);
			    
			    try 
			    {
					Desktop.getDesktop().browse(extentReport.toURI());
				} 
			    catch (Exception e) 
			    {
					e.printStackTrace();
				}*/
		 }
	}
	

