package reporters;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnExtentReport {
	
	public static void main(String[] args) throws IOException {
	
		//Create Basic HTML file
		ExtentHtmlReporter html = new ExtentHtmlReporter("./reporter/result.html");
		html.setAppendExisting(false);
	
		//Update Existing html file 
		ExtentReports extent  = new ExtentReports();
		extent.attachReporter(html);
		
		//for each Test Cases
		ExtentTest test = extent.createTest("TC001_CreateLead", "Create a new Lead in Leads");
		test.assignAuthor("aniket");
		test.assignCategory("smoke");
	
		//for each steps
		test.pass("The data DemoSalesManager is Entered successfully",
				//for Image
				MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/img.png").build());
		
		test.pass("The data crmsfa is Entered successfully");
		test.pass("The Login Button is clicked successfully");
		
		//Write
		extent.flush();		
	}
}
