package Utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import Base.BaseTest;

public class SuiteListeners implements ITestListener, IAnnotationTransformer {

	public void onTestFailure(ITestResult result) {
		String filename = System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator
				+ result.getMethod().getMethodName();
		File f1 = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(f1, new File(filename + ".png"));
		} catch (IOException e) {
			// Handle the exception more gracefully, for example, log it
			e.printStackTrace();
		}
	}

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
}
