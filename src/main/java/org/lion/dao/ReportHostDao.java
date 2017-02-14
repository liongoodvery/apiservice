package org.lion.dao;

import org.lion.model.HostQueryModel;
import org.lion.model.ReportHostModel;
import org.lion.utils.CommonUtils;
import org.lion.utils.JdbcUtils;
import org.springframework.util.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                model.getDetailId(), model.getId(), model.getParent(), model.getChildren(), model.getSrc()));

        int[] rets = st.executeBatch();
        if (rets.length != 2) {
            return 0;
        }
        return rets[1];
    }

    public List<HostQueryModel> query(long timestamp, int count, String src) throws SQLException {
        String sql = "";
        if (StringUtils.isEmpty(src)) {
            sql = "SELECT `parent`,`children`,`src` ,`time` FROM lion_ip_detail LEFT JOIN lion_ip  ON lion_ip_detail.ip_id = lion_ip.id  WHERE time < ? ORDER BY time DESC  LIMIT ?";
        } else {
            // FIXME: 2/14/17 does not support src
        }

        Connection connection = JdbcUtils.openConnection();
        PreparedStatement st = connection.prepareStatement("SELECT `parent`,`children`,`src` ,`time` FROM lion_ip_detail LEFT JOIN lion_ip  ON lion_ip_detail.ip_id = lion_ip.id  WHERE time < ? ORDER BY time DESC  LIMIT ?");
        st.setTimestamp(1, new Timestamp(timestamp));
        st.setInt(2, count);
        ResultSet rs = st.executeQuery();
        List<HostQueryModel> models = new ArrayList<>();

        while (rs.next()) {
            String parent = rs.getString(1);
            String children = rs.getString(2);
            String from = rs.getString(3);
            Timestamp t = rs.getTimestamp(4);

            List<String> list = new ArrayList<>();
            HostQueryModel hostQueryModel = new HostQueryModel();
            if (StringUtils.isEmpty(children)) {
                list.add(parent);
            } else {
                String[] ss = children.split("\u0000");
                for (String s : ss) {
                    list.add(parent + s);
                }
            }

            hostQueryModel.setHosts(list);
            hostQueryModel.setTimestamp(t.getTime());
            models.add(hostQueryModel);

        }
        JdbcUtils.closeConnection(rs, st, connection);
        return models;
    }
}
