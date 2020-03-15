/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Order;

/**
 *
 * @author hoangnm
 */
public class OrderDAO {

    public boolean add(Order order) {
        String sql = "INSERT INTO [dbo].[Order]\n"
                + "           ([date]\n"
                + "           ,[cid])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?)";
        int check=0;
        try (Connection con = DBContext.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setDate(1, order.getDateOrder());
            ps.setInt(2, order.getCustomer().getId());
            check= ps.executeUpdate();
        } catch (Exception e) {
        }
        return check >0;
    }
}
