package cn.wukun.dao.impl;

import cn.wukun.dao.DbUserDao;
import cn.wukun.domain.DbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DbUserDaoImpl implements DbUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SQL_INSERT_DBUSER = "insert into user_list (username, mobile, cardnumber) values (?, ?, ?)";
    private static final String SQL_CHECK_DBUSER = "select id,username,mobile,cardnumber from user_list";
    private static final String SQL_FINDBYID_DBUSER = "select id,username,mobile,cardnumber from user_list where id = ?";
    private static final String SQL_UPDATE_DBUSER = "update user_list set username = ?,mobile = ?,cardnumber = ? where id = ?";

    @Override
    public void addDbUser(DbUser dbUser) {
        jdbcTemplate.update(SQL_INSERT_DBUSER, dbUser.getUsername(), dbUser.getMobile(), dbUser.getCardnumber());
    }

    @Override
    public List<DbUser> findAll() {
        return jdbcTemplate.query(SQL_CHECK_DBUSER, new DbUserRowMapper());
    }

    @Override
    public DbUser findById(int id) {
        return jdbcTemplate.queryForObject(SQL_FINDBYID_DBUSER, new DbUserRowMapper(), id);
    }

    public static final class DbUserRowMapper implements RowMapper<DbUser>{
        public DbUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String mobile = rs.getString("mobile");
            String cardnumber = rs.getString("cardnumber");

            DbUser dbUser = new DbUser();
            dbUser.setId(id);
            dbUser.setUsername(username);
            dbUser.setMobile(mobile);
            dbUser.setCardnumber(cardnumber);

            return dbUser;
        }
    }

    public DbUser save(DbUser dbUser){
        if(dbUser.getId() == null){
            int id = insertDbUserAndReturnId(dbUser);
            return jdbcTemplate.queryForObject(SQL_FINDBYID_DBUSER, new DbUserRowMapper(), id);
        }

        jdbcTemplate.update(SQL_UPDATE_DBUSER, dbUser.getUsername(), dbUser.getMobile(), dbUser.getCardnumber(), dbUser.getId());

        return dbUser;
    }

    public int insertDbUserAndReturnId(DbUser dbUser){
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("user_list");
        jdbcInsert.setGeneratedKeyName("id");
        Map<String, Object> map = new HashMap<>();
        map.put("username", dbUser.getUsername());
        map.put("mobile", dbUser.getMobile());
        map.put("cardnumber", dbUser.getCardnumber());
        int id = jdbcInsert.executeAndReturnKey(map).intValue();
        return id;
    }
}
