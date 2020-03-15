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
import model.Product;

/**
 *
 * @author hoangnm
 */
public class ProductDAO extends DBContext {

    public ArrayList<Product> getAll(){
        ArrayList<Product> listP = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[price]\n"
                + "  FROM [dbo].[product]";
        try (Connection connection = DBContext.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);) {
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Product p = Product.builder().id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .price(rs.getFloat("price"))
                    .build();
            listP.add(p);
        }

        return listP;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
