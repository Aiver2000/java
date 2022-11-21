import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJbdc {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://43.143.138.8:3306/java102?charactorEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("lwz");
        ((MysqlDataSource)dataSource).setPassword("wyjdc");

        Connection connection = dataSource.getConnection();

        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        String sql = "delete from student where id = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);

        int ret = statement.executeUpdate();
        System.out.println(ret);

        statement.close();
        connection.close();

    }
}
