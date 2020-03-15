/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Group;

/**
 *
 * @author hoangnm
 */
public class GroupDAO {

    public ArrayList<Group> getGroupByUserName(String username) {
        String sql = "SELECT        [group].id, [group].name\n"
                + "FROM            [group] INNER JOIN\n"
                + "                         user_group ON [group].id = user_group.gid INNER JOIN\n"
                + "                         [user] ON user_group.username = [user].username\n"
                + "						 where [user].username = ?";
        System.out.println(username);
        ArrayList<Group> listG = new ArrayList<>();
        try (Connection connection = DBContext.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Group g = Group.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                listG.add(g);
            }
            return listG;
        } catch (SQLException e) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        return null;
    }

}
