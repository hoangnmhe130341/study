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
import model.OrderLine;

/**
 *
 * @author hoangnm
 */
public class OrderLineDAO {

    public boolean add(OrderLine orderLine) {
        String sql = "INSERT INTO [dbo].[Order_line]\n"
                + "           ([oid]\n"
                + "           ,[pid]\n"
                + "           ,[quantity]\n"
                + "           ,[price])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        int check = 0;
        try (Connection connection = DBContext.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setInt(1, orderLine.getOrder().getId());
            ps.setInt(2, orderLine.getProduct().getId());
            ps.setInt(3, orderLine.getQuantity());
            ps.setFloat(4, orderLine.getPrice());
            check = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }
}
