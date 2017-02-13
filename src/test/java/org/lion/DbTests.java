package org.lion;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.lion.dao.ReportHostDao;
import org.lion.model.ReportHostModel;
import org.lion.utils.CommonUtils;
import org.lion.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by lion on 2/13/17.
 */
public class DbTests {

    private Connection connection;

    @Before
    public void before() throws SQLException {
        connection = JdbcUtils.openConnection();
        Assert.assertNotNull(connection);
    }
    @Test
    public void test8() throws Exception {
        Statement st = connection.createStatement();
        String sql = "insert into lion_ip (id) VALUES ('" + CommonUtils.phaseId() + "')";
        System.out.println(sql);
        st.execute(sql);
        JdbcUtils.close(st);
    }

    @Test
    public void test37() throws Exception {
        Statement st = connection.createStatement();
        String sql = "select * from lion_ip";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            System.out.println(String.format("%s:%s",rs.getString("id"),rs.getTimestamp("time").getTime()));
        }
        JdbcUtils.close(rs);
        JdbcUtils.close(st);
    }

    @Test
    public void testAddReport() throws Exception {
        ReportHostModel model = new ReportHostModel(null, null, "192.168.1.", null, null);
        System.out.println(new ReportHostDao().addReport(model));
    }
    @After
    public void after() {
        JdbcUtils.close(connection);
    }
}
