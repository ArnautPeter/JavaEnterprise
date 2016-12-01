package lesson7.calc_test;

import com.java.ee.lesson7.calc_test.Calculator;
import custom_runner.CustomRunner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@RunWith(JUnit4.class)
@RunWith(CustomRunner.class)
public class CalculatorFuncTest {

    @BeforeClass
    public static void init() {
        System.out.println("before class");
    }

    @Before
    public void before() {
        System.out.println("before");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after class");
    }

    @After
    public void after() {
        System.out.println("after ");
    }

    @Test
    public void check_sum_method() {

        Calculator calculator = mock(Calculator.class);
        when(calculator.getNumber1()).thenReturn(12);
        when(calculator.getNumber2()).thenReturn(18);
        when(calculator.add()).thenReturn(30);

        Assert.assertEquals(calculator.getNumber1(), 12);
        Assert.assertEquals(calculator.getNumber2(), 18);

        int sum = calculator.add();
        Assert.assertEquals(sum, 30);
        verify(calculator, times(1)).add();
    }

    @Test
    public void spy_collection_test() {

        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 7, 9, 1, 2));

        List<Integer> spy = spy(integers);
        doReturn(-1000).when(spy).get(0);

        Integer firstIntegerElement = spy.get(0);
        Assert.assertTrue(firstIntegerElement == -1000);
        Integer secondIntegerElement = spy.get(1);
        Assert.assertTrue(secondIntegerElement == 2);
    }

    @Test
    public void add_out_variables_test() {
        Calculator calculator = new Calculator();
        int sum = calculator.add(1, 4);
        Assert.assertEquals(sum, 5);
    }
}
