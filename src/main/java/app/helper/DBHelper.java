package app.helper;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBHelper {

    private final String DRIVER="com.mysql.cj.jdbc.Driver";
    private final String URL="jdbc:mysql://localhost:3306/jwd41";
    private final String USERNAME="root";
    private final String PASSWORD="root";


    private  static Connection connection;
    private static DBHelper instance;

    private DBHelper(){
        try {
            Class.forName(DRIVER);
            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public static DBHelper getInstance(){
        if (instance==null){
            instance=new DBHelper();
        }
        return instance;
    }
    public  static Connection getConnection(){
        return connection;

    }
}
