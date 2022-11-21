import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://43.143.138.8:3306/java102?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("lwz");
        ((MysqlDataSource)dataSource).setPassword("wyjdc");

        Connection connection = dataSource.getConnection();
        int id = scanner.nextInt();
        String name = scanner.next();

        String sql = "insert into student values(?,?)";
        //String sql = "delete from student where id = 1";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.setString(2,name);
        System.out.println(statement);

        int ret = statement.executeUpdate();
        System.out.println(ret);

        statement.close();
        connection.close();
    }
}
