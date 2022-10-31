package packages.database;

import connection.DBConnection;
import packages.bean.PackageBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PackageDao {
    public static Connection getConnection(){
        Connection con = null;
        Statement statement = null;

        try{
            con = DBConnection.createConnection();
            statement = con.createStatement();
        }catch(Exception e){System.out.println(e);}
        return con;
    }

    public static int save(PackageBean e){
        int status=0;
        try{
            Connection con= PackageDao.getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "insert into packages(package_name,package_code,package_cost) values (?,?,?)");
            ps.setString(1,e.getPackageName());
            ps.setString(2,e.getPackageCode());
            ps.setInt(3,e.getPackageCost());

            status=ps.executeUpdate();

            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }
}
