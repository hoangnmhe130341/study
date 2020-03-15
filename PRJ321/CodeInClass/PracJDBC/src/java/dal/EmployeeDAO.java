/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import com.sun.jndi.ldap.Connection;
import entity.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class EmployeeDAO extends jdbc.SQLServerConnection {

    ArrayList<Employee> list = new ArrayList<>();

    public void addList() {
        String sql = "SELECT        Employee.ID, Employee.name, Employee.dob, Employee.gender, Employee.did, Department.name AS nameD\n"
                + "FROM            Department CROSS JOIN\n"
                + "                         Employee";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("ID"));
                employee.setName(rs.getString("name"));
                employee.setDbo(rs.getDate("dob"));
                employee.setGender(rs.getBoolean("gender"));
                employee.setDid(rs.getInt("did"));
                list.add(employee);
            }

        } catch (Exception e) {
        }
    }

    public ArrayList<Employee> getList() {
        addList();
        return list;
    }

    public void setList(ArrayList<Employee> list) {
        this.list = list;
    }
}
