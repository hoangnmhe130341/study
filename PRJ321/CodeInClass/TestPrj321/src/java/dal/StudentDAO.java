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
import model.Exam;
import model.Student;
import model.Subject;

/**
 *
 * @author Lenovo
 */
public class StudentDAO extends DBContext {

    public ArrayList<Student> getStudent() {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "SELECT        Student.name, Subject.name AS subName, Exam.score\n"
                + "FROM            Exam INNER JOIN\n"
                + "                         Student ON Exam.sid = Student.id INNER JOIN\n"
                + "                         Subject ON Exam.subid = Subject.id";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Subject sub = Subject.builder().name(rs.getString("subName")).build();
                Student stu = Student.builder().name(rs.getString("name"))
                        .sub(sub)
                        .build();
                Exam ex = Exam.builder().idSub(sub.getId())
                        .idStu(stu.getId())
                        .score(rs.getFloat("score"))
                        .build();
                stu.setEx(ex);
                students.add(stu);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return students;
    }
    
    public static void main(String[] args) {
        ArrayList<Student> v = new StudentDAO().getStudent();
        for (Student student : v) {
            System.out.println(student.getName()+"\n");
        }
    }
}
