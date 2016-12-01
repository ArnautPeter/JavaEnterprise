package lesson8;

import com.java.ee.lesson6.ioc_di2.User;
import com.java.ee.lesson6.ioc_di2.service.UserService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@RunWith(JUnit4.class)
public class UserServiceTest2 {

    static UserService userService;

    @BeforeClass
    public static void init() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-annotation-context.xml");
        userService = context.getBean("userService", UserService.class);

    }

    @Test
    public void get_all_users_test() {
        List<User> allUsers = userService.getAllUsers();
        Assert.assertEquals(allUsers.size(), 4);
    }
}
