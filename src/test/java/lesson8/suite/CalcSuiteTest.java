package lesson8.suite;


import lesson7.calc_test.CalculatorFuncTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({CalculatorFuncTest.class})
public class CalcSuiteTest {
}
