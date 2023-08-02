import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryUsage implements IRetryAnalyzer {
    private int retry = 0;
    private static final int totalRetry = 5;

    @Override
    public boolean retry(ITestResult result) {
        if (retry < totalRetry) {
            retry++;
            return true;
        }
        return false;
    }
}