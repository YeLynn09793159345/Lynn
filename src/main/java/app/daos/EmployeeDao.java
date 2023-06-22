package app.daos;

import app.helper.DBHelper;
import app.models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    public int createEmployee(Employee employee){
        int status=0;
        Connection connection= DBHelper.getInstance().getConnection();
        String query="INSERT INTO employee (name,email,phone,city) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1,employee.getName());
            ps.setString(2,employee.getEmail());
            ps.setString(3,employee.getPhone());
            ps.setString(4,employee.getCity());
            status=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return status;
    }

    public List<Employee> getAllEmployee(){
        List<Employee> employees=new ArrayList<>();
        Connection connection=DBHelper.getInstance().getConnection();
        String query="SELECT * FROM employee";
        ResultSet rs;
        try {
            PreparedStatement ps=connection.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
                Employee employee=new Employee();
                employee.setId(rs.getInt("employeeid"));
                employee.setName(rs.getString("name"));
                employee.setEmail(rs.getString("email"));
                employee.setPhone(rs.getString("phone"));
                employee.setCity(rs.getString("city"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public int updateEmployee(Employee emp) {
        int status=0;
        Connection con=DBHelper.getInstance().getConnection();
        String query="UPDATE employee SET name=?,email=?,phone=?,city=? WHERE id=?";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getEmail());
            ps.setString(3, emp.getPhone());
            ps.setString(4, emp.getCity());
            ps.setInt(5, emp.getId());
            status=ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return status;
    }

    public int deleteEmployee(int id) {
        int status=0;
        Connection con=DBHelper.getInstance().getConnection();
        String query="DELETE FROM employee WHERE employeeid=?";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1, id);
            status=ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return status;
    }

    public Employee getEmployeeById(int id) {

        ResultSet rs;
        Employee emp=new Employee();
        Connection con=DBHelper.getInstance().getConnection();
        String query="SELECT * FROM employee WHERE employeeid=?";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()) {
                emp.setId(rs.getInt("employeeid"));
                emp.setName(rs.getString("name"));
                emp.setEmail(rs.getString("email"));
                emp.setPhone(rs.getString("phone"));
                emp.setCity(rs.getString("city"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return emp;
    }

}
