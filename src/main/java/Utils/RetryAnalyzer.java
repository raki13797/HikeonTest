package Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	int Count=0;
	int RetryCount=0;

	public boolean retry(ITestResult result) {
		while(Count<RetryCount)
		{
			Count++;
			return true;
		}
		return false;
	}


}
