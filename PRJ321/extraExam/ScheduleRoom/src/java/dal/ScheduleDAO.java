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
import model.Schedule;

/**
 *
 * @author hoangnm
 */
public class ScheduleDAO {

    public ArrayList<Schedule> getAllByRoomId(int id) {
        String query = "SELECT [id]\n"
                + "      ,[room_id]\n"
                + "      ,[from]\n"
                + "      ,[to]\n"
                + "  FROM [Schedule] WHERE room_id = ?";
        ArrayList<Schedule> listS = new ArrayList<>();
        try (Connection con = new DBContext().getConnection();
                PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Schedule s = new Schedule();
                s.setId(rs.getInt("id"));
                s.setRoomId(rs.getInt("room_id"));
                s.setFrom(rs.getDate("from"));
                s.setTo(rs.getDate("to"));
                listS.add(s);
            }
            return listS;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public boolean add(Schedule schedule) {
        String query = "INSERT INTO Schedule(room_id, [from], [to]) VALUES(?, ?, ?)";
        
        int check = 0;
        try (Connection con = new DBContext().getConnection();
                PreparedStatement ps =con.prepareStatement(query);) {
                con.setAutoCommit(false);
                ps.setObject(1, schedule.getRoomId());
                ps.setObject(2, schedule.getFrom());
                ps.setObject(3, schedule.getTo());
                check = ps.executeUpdate();
                con.commit();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
}
