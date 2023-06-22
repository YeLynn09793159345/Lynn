package app.daos;

import app.helper.DBHelper;
import app.models.Customer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    public int createCustomer(Customer customer){
        int status=0;
        Connection connection= DBHelper.getInstance().getConnection();
        String query="INSERT INTO customer (name,email,phone,address) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1,customer.getName());
            ps.setString(2,customer.getEmail());
            ps.setString(3,customer.getPhone());
            ps.setString(4,customer.getAddress());
            status=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return status;
    }

    public List<Customer> getAllCustomer(){
        List<Customer> customers=new ArrayList<>();
        Connection connection=DBHelper.getInstance().getConnection();
        String query="SELECT * FROM customer";
        ResultSet rs;
        try {
            PreparedStatement ps=connection.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
                Customer customer=new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getString("phone"));
                customer.setAddress(rs.getString("Address"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public int updateCustomer(Customer com) {
        int status=0;
        Connection con=DBHelper.getInstance().getConnection();
        String query="UPDATE customer SET name=?,email=?,phone=?,Address=? WHERE id=?";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, com.getName());
            ps.setString(2, com.getEmail());
            ps.setString(3, com.getPhone());
            ps.setString(4, com.getAddress());
            status=ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return status;
    }

    public int deleteCustomer(int id) {
        int status=0;
        Connection con=DBHelper.getInstance().getConnection();
        String query="DELETE FROM customer WHERE id=?";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,id);
            status=ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return status;
    }

    public Customer getCustomerById(int id) {

        ResultSet rs;
        Customer com=new Customer();
        Connection con=DBHelper.getInstance().getConnection();
        String query="SELECT * FROM customer WHERE id=?";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next()) {
                com.setId(rs.getInt("id"));
                com.setName(rs.getString("name"));
                com.setEmail(rs.getString("email"));
                com.setPhone(rs.getString("phone"));
                com.setAddress(rs.getString("address"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return com;
    }

}
