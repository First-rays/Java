package JDBC;

import java.sql.*;

public class Jdbc {
    public static void main(String[] args) {
        Connection conn  = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            //1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root&useUnicode=true&characterEncoding=utf-8");
            //conn = JDBCUtil.getConn();

            //3. 创建statement ， 跟数据库打交道，一定需要这个对象
            st = conn.createStatement();

            //4. 执行查询 ， 得到结果集
            String sql = "select * from product";
            rs = st.executeQuery(sql);
            //5. 遍历查询每一条记录
            while(rs.next()){
                int id = rs.getInt("pid");
                String pname = rs.getString("pname");
                int price = rs.getInt("price");
                System.out.println("id="+id + "===pname="+pname+"==price="+price);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
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
                throw new RuntimeException("数据库错误");
            }

        }
    }
}
