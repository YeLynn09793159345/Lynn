package app.daos;

import app.helper.DBHelper;
import app.models.User;
import app.models.UserDetail;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public int createUser(User user){
        int status=0;
        Connection connection= DBHelper.getInstance().getConnection();
        String query="INSERT INTO user (username,password,employeeid) VALUES (?,?,?)";
        try {
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setInt(3,user.getEmployeeid());

            status=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return status;
    }

    public List<UserDetail> getAllUser(){
        List<UserDetail> users=new ArrayList<>();
        Connection connection=DBHelper.getInstance().getConnection();
        String query="SELECT * FROM user INNER JOIN employee ON user.employeeid=employee.id";
        ResultSet rs;
        try {
            PreparedStatement ps=connection.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
                UserDetail userDetail=new UserDetail();
                userDetail.setId(rs.getInt("id"));
                userDetail.setUsername(rs.getString("username"));
                userDetail.setPassword(rs.getString("password"));
                userDetail.setEmployeeid(rs.getInt("employeeid"));
                userDetail.setEmployeename(rs.getString("employeename"));
                userDetail.setEmail(rs.getString("email"));
                userDetail.setPhone(rs.getString("phone"));
                userDetail.setCity(rs.getString("city"));
                users.add(userDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    public int deleteUser(int id) {
        int status=0;
        Connection con=DBHelper.getInstance().getConnection();
        String query="DELETE FROM user WHERE id=?";
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


    }

}
