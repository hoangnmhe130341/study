/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Room;

/**
 *
 * @author hoangnm
 */
public class RoomDAO {

    public ArrayList<Room> getAll() {
        String query = "SELECT [id]\n"
                + "      ,[name]\n"
                + "  FROM [Room]";
        ArrayList<Room> list = new ArrayList<>();
        try (Connection con = new DBContext().getConnection();
                PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setName(rs.getString("name"));
                list.add(room);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public Room getOne(int id) {
        String query = "SELECT [id]\n"
                + "      ,[name]\n"
                + "  FROM [Room] where id=?";
        ArrayList<Room> list = new ArrayList<>();
        try (Connection con = new DBContext().getConnection();
                PreparedStatement ps = con.prepareStatement(query);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setName(rs.getString("name"));
                return room;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new RoomDAO().getAll().get(0).getName());
    }

    public ArrayList<Room> getAllFreeRoom(Date from, Date to) {
        String query = "SELECT * FROM Room WHERE id NOT IN (select room_id from Schedule where ([from] between ? and ?) or\n"
                + "								([to] between ? and ?))";
        ArrayList<Room> list = new ArrayList<>();
        try (Connection con = new DBContext().getConnection();
                PreparedStatement ps = con.prepareStatement(query);) {
            ps.setDate(1, from);
            ps.setDate(2, to);
            ps.setDate(3, from);
            ps.setDate(4, to);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setName(rs.getString("name"));
                room.setIsFree(true);
                list.add(room);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public ArrayList<Room> getAllBookedRoom(Date from, Date to) {
        String query = "SELECT * FROM Room WHERE id in (select room_id from Schedule where ([from] between ? and ?) or\n"
                + "								([to] between ? and ?))";
        ArrayList<Room> list = new ArrayList<>();
        try (Connection con = new DBContext().getConnection();
                PreparedStatement ps = con.prepareStatement(query);) {
            ps.setDate(1, from);
            ps.setDate(2, to);
            ps.setDate(3, from);
            ps.setDate(4, to);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setName(rs.getString("name"));
                room.setIsFree(true);
                list.add(room);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
