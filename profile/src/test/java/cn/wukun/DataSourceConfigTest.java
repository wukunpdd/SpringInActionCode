package cn.wukun;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class DataSourceConfigTest {

  @RunWith(SpringJUnit4ClassRunner.class)
  @ContextConfiguration(classes = DataSourceConfig.class)
  @ActiveProfiles("dev")
  public static class DevDataSourceTest {
    @Autowired
    private DataSource dataSource;

    @Test
    public void shouldBeEmbeddedDatasource() {
      assertNotNull(dataSource);
      JdbcTemplate jdbc = new JdbcTemplate(dataSource);
      List<String> results = jdbc.query("select id, name from Things", new RowMapper<String>() {
        @Override
        public String mapRow(ResultSet rs, int rowNum) throws SQLException {
          return rs.getLong("id") + ":" + rs.getString("name");
        }
      });

      assertEquals(1, results.size());
      assertEquals("1:A", results.get(0));
    }
  }

  @RunWith(SpringJUnit4ClassRunner.class)
  @ContextConfiguration(classes = DataSourceConfig.class)
  @ActiveProfiles("prod")
  public static class ProductionDataSourceTest {
    @Autowired
    private DataSource dataSource;

    @Test
    public void shouldBeEmbeddedDatasource() {
      // 应该为null，因为JNDI中没有配置数据源
      assertNull(dataSource);
    }
  }

}
