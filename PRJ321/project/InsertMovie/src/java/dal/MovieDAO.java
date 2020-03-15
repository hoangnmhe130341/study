/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Movie;

/**
 *
 * @author hoangnm
 */
public class MovieDAO {

    public void insert(Movie movie) {
        String sql = "INSERT INTO [Movie]\n"
                + "           ([title])\n"
                + "     VALUES\n"
                + "           (?)";
        try (Connection connection = DBContext.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);) {
            connection.setAutoCommit(false);
            ps.setObject(1, movie.getName());
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
        }
    }
}
