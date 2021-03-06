import lesson7.calc_test.CalculatorFuncTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class JunitCoreRunTest {

    public static void main(String[] args) {

        JUnitCore jUnitCore = new JUnitCore();
        Result run = jUnitCore.run(CalculatorFuncTest.class);
        System.out.println("failure: " + run.getFailures().size());

        jUnitCore.addListener(new RunListener() {
            @Override
            public void testFailure(Failure failure) throws Exception {
                super.testFailure(failure);
            }
        });
    }
}
