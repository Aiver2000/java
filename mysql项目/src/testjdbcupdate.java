import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class testjdbcupdate {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://43.143.138.8:3306/java102?charactorEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("lwz");
        ((MysqlDataSource)dataSource).setPassword("wyjdc");

        Connection connection = dataSource.getConnection();

        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        String name = scanner.next();

        String sql = "update student set name = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,name);
        statement.setInt(2,id);
        System.out.println(statement);

        int ret = statement.executeUpdate();
        System.out.println(ret);

        statement.close();
        connection.close();

    }
}
