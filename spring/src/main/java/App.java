import com.beans.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class App {
    /**
     * 相同点：都可以从容器中获取Bean，都提供了getBean方法~
     * 不同点：
     * 1.ApplicationContext 是 BeanFactory 的子类
     *      BeanFactory只提供了基础访问Bean的方法~
     *      ApplicationContext除了拥有父类的所以功能外，还提供了更多功能
     *      比如：对国际化的支持~资源访问的支持~事件及传播等方面的支持
     * 2.性能上：
     *      BeanFactory是按需加载Bean--懒汉模式
     *      ApplicationContext--饿汉方式，在创建时会将所以Bean都加载起来~
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        //User user = (User) context.getBean("user");
        //User user = context.getBean(User.class);
        User user = context.getBean("user",User.class);

        user.sayHi("刘权新");

//        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));
//        User user1 = (User) factory.getBean("user");
//        user1.sayHi("美羊羊");


    }
}
