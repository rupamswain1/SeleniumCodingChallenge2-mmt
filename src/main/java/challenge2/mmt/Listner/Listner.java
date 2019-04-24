package challenge2.mmt.Listner;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.relevantcodes.extentreports.LogStatus;

import challenge.mmt.Report.ExtentReport;

public class Listner implements ITestListener
{

	@Override
	public void onFinish(ITestContext arg0) 
	{
		
		ExtentReport.report.endTest(ExtentReport.logger);
		
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		ExtentReport.logger= ExtentReport.report.startTest(arg0.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		ExtentReport.logger= ExtentReport.report.startTest(arg0.getName());
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		challenge.mmt.Report.LogStatus.fail("Test case failed");
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		challenge.mmt.Report.LogStatus.fail("Test case failed");
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		
		challenge.mmt.Report.LogStatus.pass("Test Case method "+arg0.getMethod().getMethodName()+" started");
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		challenge.mmt.Report.LogStatus.pass("Test Case successfully Passed");
	}

}
