package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProjectDao {
    public void save(Project project){
        //通过此方法将项目信息存储到数据库中
        // 1. 数据库连接
        Connection connection = DBUtil.getConnection();
        // 2.构造PreparedStatement，拼装sql语句
        PreparedStatement Statement = null;
        String sql = "insert into project values (?,?,?,?,?,?,?)";
        try {
            Statement = connection.prepareStatement(sql);
            Statement.setString(1,project.getName());
            Statement.setString(2,project.getUrl());
            Statement.setString(3,project.getDescription());
            Statement.setInt(4,project.getStarCount());
            Statement.setInt(5,project.getForkCount());
            Statement.setInt(6,project.getOpenIssueCount());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            Statement.setInt(7, Integer.parseInt(simpleDateFormat.format(System.currentTimeMillis())));
            int ret = Statement.executeUpdate();
            if(ret != 1){
                System.out.println("数据没有插入成功！");
                return;
            }
            System.out.println("数据插入成功！");



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,Statement,null);
        }
    }

    public List<Project> selectProjectByDate(String date) {
        List<Project> projects = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select name, url,description,starCount,forkCount," +
                "openIssueCount from project where date =? order by starCount desc";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,date);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Project project = new Project();
                project.setName(resultSet.getString("name"));
                project.setUrl(resultSet.getString("url"));
                project.setDescription(resultSet.getString("description"));
                project.setStarCount(resultSet.getInt("starCount"));
                project.setForkCount(resultSet.getInt("forkCount"));
                project.setOpenIssueCount(resultSet.getInt("openIssueCount"));
                projects.add(project);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return projects;

    }

    public static void main(String[] args) {
        ProjectDao projectDao = new ProjectDao();
        List<Project> projects = projectDao.selectProjectByDate("20200331");
        System.out.println(projects);
    }

}
