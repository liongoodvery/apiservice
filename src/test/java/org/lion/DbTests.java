package org.lion;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.lion.utils.CommonUtils;
import org.lion.utils.JdbcUtils;

import java.sql.Connection;
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
        JdbcUtils.close(connection);
    }

    @After
    public void after() {

    }
}
