package Utility;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import resources.BaseClassTest;
import resources.Constants;

public class TestListener extends BaseClassTest implements ITestListener,Constants {

	@Override
	public void onTestStart(ITestResult result) {
		File srcFile=new File("./OnStart/yash.png");
		TakesScreenshot img=(TakesScreenshot)driver;
		try {
			FileUtils.copyFile(img.getScreenshotAs(OutputType.FILE), srcFile);
		} catch (WebDriverException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getName(); 
		try{ 
			Robot r=new Robot(); 
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();	
			Rectangle screenRect=new Rectangle(d); 
			BufferedImage img = r.createScreenCapture(screenRect); 
			SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss"); 
			String now = s.format(new Date()); 
			ImageIO.write(img, "png",new File(SUCCESS_PHOTO_PATH+testName+now+".png")); 
			Reporter.log("Success TestCase is:"+result.getName(),true);
		} 
		catch(Exception e){ }
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName(); 
		try{ 
			Robot r=new Robot(); 
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();	
			Rectangle screenRect=new Rectangle(d); 
			BufferedImage img = r.createScreenCapture(screenRect); 
			SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss"); 
			String now = s.format(new Date()); 
			ImageIO.write(img, "png",new File(FAIL_PHOTO_PATH+testName+now+".png")); 
			Reporter.log("Failed TestCase is:"+result.getName(),true);
		} 
		catch(Exception e){ }
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
