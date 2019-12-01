package JDBC;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class JdbcDemo {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    //driverManager 方法连接数据库
    public  static Connection getConnection() {
        Connection connection = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL,USER,PASSWORD);
            } finally {
                if(connection != null){
                    connection.close();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("连接成功");
        return connection;
    }

    //单例模式
    private static DataSource dataSource = null;

    public static DataSource getDataSource(){
        if(dataSource == null){
            dataSource = new MysqlDataSource();
            ((MysqlDataSource) dataSource).setURL(URL);
            ((MysqlDataSource) dataSource).setUser(USER);
            ((MysqlDataSource) dataSource).setPassword(PASSWORD);
        }
        return dataSource;
    }

    //静态代码块 + 静态变量的方式
    private static DataSource dataSource2 = new MysqlDataSource();
    static {
        ((MysqlDataSource) dataSource2).setURL(URL);
        ((MysqlDataSource) dataSource2).setUser(USER);
        ((MysqlDataSource) dataSource2).setPassword(PASSWORD);

    }

    public static Connection getConnection2(){
        try {
            return dataSource2.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("数据库连接错误！");
        }
    }

   public static void close(Connection conn,
                            Statement st, ResultSet rs){

       try {
           if(rs != null){
               rs.close();
           }
           if(st != null){
               st.close();
           }
           if(conn != null){
               conn.close();
           }
       } catch (SQLException e) {
           e.printStackTrace();
           throw new RuntimeException("数据库释放资源错误");
       }

   }
}
