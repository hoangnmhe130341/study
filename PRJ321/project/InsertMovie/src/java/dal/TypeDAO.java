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
import model.Type;

/**
 *
 * @author hoangnm
 */
public class TypeDAO {

    public ArrayList<Type> getAll() {
        ArrayList<Type> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "  FROM [Type]";
        try (Connection connection = DBContext.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Type type = new Type();
                type.setId(rs.getInt("id"));
                type.setName(rs.getString("name"));
                list.add(type);
            }
        } catch (SQLException e) {
        }

        return list;

    }

    public static void main(String[] args) {
        System.out.println(new TypeDAO().getAll().get(0));
    }
}
