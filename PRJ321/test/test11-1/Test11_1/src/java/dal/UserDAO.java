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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoangnm
 */
public class UserDAO {

    public boolean isLoginSucess(String username, String password) {
        String sql = "SELECT [username]\n"
                + "      ,[password]\n"
                + "  FROM [dbo].[user]";
        try (Connection connection = DBContext.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if(username.equalsIgnoreCase(rs.getString("username"))){
                    if(password.equals(rs.getString("password"))){
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
             Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}
