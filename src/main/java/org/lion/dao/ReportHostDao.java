package org.lion.dao;

import org.lion.model.ReportHostModel;
import org.lion.utils.CommonUtils;
import org.lion.utils.JdbcUtils;
import org.springframework.util.StringUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by lion on 2/13/17.
 */
public class ReportHostDao {
    public int addReport(ReportHostModel model) throws SQLException {
        Connection connection = JdbcUtils.openConnection();
        Statement st = connection.createStatement();
        if (StringUtils.isEmpty(model.getId())) {
            model.setId(CommonUtils.phaseId());
        }
        if (StringUtils.isEmpty(model.getDetailId())) {
            model.setDetailId(CommonUtils.phaseId());
        }

        if (StringUtils.isEmpty(model.getSrc())) {
            model.setSrc("");
        }

        if (StringUtils.isEmpty(model.getChildren())) {
            model.setChildren("");
        }
        st.addBatch("INSERT INTO lion_ip (id) VALUES ('" + model.getId() + "')");
        st.addBatch(String.format("INSERT INTO lion_ip_detail (id,ip_id,parent,children,src) VALUES ('%s','%s','%s','%s','%s')",
                model.getDetailId(),model.getId(),model.getParent(),model.getChildren(),model.getSrc()));

        int[] rets = st.executeBatch();
        if (rets.length != 2) {
            return 0;
        }
        return rets[1];
    }
}
