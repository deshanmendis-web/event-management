package register.database;

import connection.DBConnection;
import register.bean.RegisterBean;

import java.sql.*;

// Create Register Data Object
public class RegisterDao {

    // Define getConnection method
    public static Connection getConnection(){

        Connection con = null;
        Statement statement = null;

        try{
            con = DBConnection.createConnection();
            statement = con.createStatement();
        }catch(Exception e){System.out.println(e);}
        return con;
    }

    // Define save method to save user data
    public static int save(RegisterBean e){
        int status=0;
        try{
            Connection con= RegisterDao.getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "insert into users(email,password,role) values (?,?,?)");
            ps.setString(1,e.getEmail());
            ps.setString(2,e.getPassword());
            ps.setInt(3,e.getRole());

            status=ps.executeUpdate();

            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }

}
