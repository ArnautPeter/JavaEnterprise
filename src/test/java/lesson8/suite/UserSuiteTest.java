package lesson8.suite;

import lesson8.UserServiceTest;
import lesson8.UserServiceTest2;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({UserServiceTest.class, UserServiceTest2.class})
public class UserSuiteTest {


}
