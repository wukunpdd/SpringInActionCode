package cn.wukun.dao.impl;

import cn.wukun.dao.TestDao;
import cn.wukun.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TestDaoImpl implements TestDao {
    @Autowired
    private DataSource dataSource;

    private static final String SQL_INSERT_TEST = "insert into test (user_name) values (?)";
    private static final String SQL_UPDATE_TEST = "update test set user_name = ? where id = ?";
    private static final String SQL_CHECK_TEST = "select id,user_name from test where id = ?";

    @Override
    public void addTest(Test test) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_TEST);
            stmt.setString(1, test.getUserNme());
            stmt.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(stmt != null){
                    stmt.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateTest(Test test) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_TEST);
            stmt.setString(1, test.getUserNme());
            stmt.setInt(2, test.getId());
            stmt.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(stmt != null){
                    stmt.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public Test checkTest(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement(SQL_CHECK_TEST);
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            Test test = null;
            if(rs.next()){
                test = new Test();
                test.setId(rs.getInt("id"));
                test.setUserNme(rs.getString("user_name"));
            }
            return test;
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(stmt != null){
                    stmt.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
