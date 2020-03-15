/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author hoangnm
 */
public class MovieTypeDAO {

    public void insert(int mid, int tid) {
        String sql = "INSERT INTO [Movie_Type]\n"
                + "           ([mid]\n"
                + "           ,[tid])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";
        try (Connection connection = DBContext.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);) {
            connection.setAutoCommit(false);
            ps.setObject(1, mid);
            ps.setObject(2, tid);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
        }
    }
}
