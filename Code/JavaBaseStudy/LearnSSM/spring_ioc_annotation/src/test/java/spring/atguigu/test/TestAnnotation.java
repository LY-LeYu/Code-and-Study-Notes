package spring.atguigu.test;

import com.atguigu.spring.controller.UserController;
import com.atguigu.spring.dao.UserDao;
import com.atguigu.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {
    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = applicationContext.getBean(UserController.class);
//        System.out.println(userController);
//        UserService userService = applicationContext.getBean(UserService.class);
//        System.out.println(userService);
//        UserDao userDao = applicationContext.getBean(UserDao.class);
//        System.out.println(userDao);
        userController.saveUser();
    }
}
