package login.database;

import login.bean.RegisterBean;
import login.database.RegisterDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegisterDao {
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management?useSSL=false", "root", "");
        }catch(Exception e){System.out.println(e);}
        return con;
    }
    public static int save(RegisterBean e){
        int status=0;
        try{
            Connection con= RegisterDao.getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "insert into users(email,password) values (?,?)");
            ps.setString(1,e.getEmail());
            ps.setString(2,e.getPassword());

            status=ps.executeUpdate();

            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }

}
