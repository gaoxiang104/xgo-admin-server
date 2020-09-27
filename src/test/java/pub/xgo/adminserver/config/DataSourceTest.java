package pub.xgo.adminserver.config;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@SpringBootTest
@RunWith(SpringRunner.class)
public class DataSourceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceTest.class);
    @Autowired
    DataSource dataSource;

    @Test
    public void springDataSoucreTest() {
        LOGGER.info("dataSource instanceof HikariDataSource : {}"
                , dataSource instanceof HikariDataSource);
//        System.out.println(dataSource instanceof HikariDataSource);

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT database() as 'db'");
            while (resultSet.next()) {
                LOGGER.info("db name : {}", resultSet.getString("db"));
//                System.out.println("db name : {}" + resultSet.getString("db"));
            }
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
