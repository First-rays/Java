package JDBC;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcDemo.getConnection();
            statement = connection.createStatement();
            String sql = "select * from exam_result";
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                BigDecimal chinese = resultSet.getBigDecimal("chinese");
                BigDecimal math = resultSet.getBigDecimal("math");
                BigDecimal english = resultSet.getBigDecimal("english");
                System.out.printf("id=%s, name=%s, chinese=%s, " +
                                "math=%s, english=%s", id, name, chinese,
                        math, english);
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
