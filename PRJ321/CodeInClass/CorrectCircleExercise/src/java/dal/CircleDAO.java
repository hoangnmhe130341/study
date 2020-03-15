/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Circle;

/**
 *
 * @author sonnt
 */
public class CircleDAO extends DBContext {
    public ArrayList<Circle> getCircles()
    {
        ArrayList<Circle> circles = new ArrayList<>();
        String sql = "SELECT [id]\n" +
                        "      ,[x]\n" +
                        "      ,[y]\n" +
                        "      ,[radius]\n" +
                        "      ,[speed]\n" +
                        "      ,[r]\n" +
                        "      ,[g]\n" +
                        "      ,[b]\n" +
                        "      ,[isRunning]\n" +
                        "      ,[isUp]\n" +
                        "      ,[isRight]\n" +
                        "  FROM [Circle]";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                Circle c = new Circle();
                c.setId(rs.getInt("id"));
                c.setX(rs.getInt("x"));
                c.setY(rs.getInt("y"));
                c.setRadius(rs.getInt("radius"));
                c.setSpeed(rs.getInt("speed"));
                c.setR(rs.getInt("r"));
                c.setG(rs.getInt("g"));
                c.setB(rs.getInt("b"));
                c.setUp(rs.getBoolean("IsUp"));
                c.setRight(rs.getBoolean("IsRight"));
                c.setRunning(rs.getBoolean("IsRunning"));
                circles.add(c);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CircleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return circles;
    }
    
    
    public void update(Circle circle)
    {
        try {
            String sql = "UPDATE [Circle]\n" +
                    "   SET \n" +
                    "       [x] = ?\n" +
                    "      ,[y] = ?\n" +
                    "      ,[isRunning] = ?\n" +
                    "      ,[isUp] = ?\n" +
                    "      ,[isRight] = ?\n" +
                    " WHERE [id] = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, circle.getX());
            statement.setInt(2, circle.getY());
            statement.setBoolean(3, circle.isRunning());
            statement.setBoolean(4, circle.isUp());
            statement.setBoolean(5, circle.isRight());
            statement.setInt(6, circle.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CircleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
}
