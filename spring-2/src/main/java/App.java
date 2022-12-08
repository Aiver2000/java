import com.beans.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserController4 userController4 = context.getBean(UserController4.class);
        userController4.sayHi();
//        UserController3 userController3 = context.getBean(UserController3.class);
//        userController3.sayHi();
//        UserController2 userController2 = context.getBean(UserController2.class);
//        UserController userController = context.getBean("userController",UserController.class);
//        userController.sayHi();
//        UserService userService = context.getBean(UserService.class);
//        userService.sayHi();
//        UserRepository repository = context.getBean(UserRepository.class);
//        repository.sayHi();
//        UserConfig userConfig = context.getBean(UserConfig.class);
//        userConfig.sayHi();
//        UserComponent userComponent = context.getBean(UserComponent.class);
//        userComponent.sayHi();
        //User user = context.getBean("user1",User.class);
//        User user = context.getBean("userinfo",User.class);
//        System.out.println(user);

    }
}
