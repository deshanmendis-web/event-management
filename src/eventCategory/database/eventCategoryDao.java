package eventCategory.database;

import connection.DBConnection;
import eventCategory.bean.eventCategoryBean;
import student.bean.Student;
import student.database.StudentDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class eventCategoryDao {
    public static Connection getConnection(){

        Connection con = null;
        Statement statement = null;

        try{
            con = DBConnection.createConnection();
            statement = con.createStatement();
        }catch(Exception e){System.out.println(e);}
        return con;
    }

    public static int save(eventCategoryBean e){
        int status=0;
        try{
            Connection con= eventCategoryDao.getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "insert into event_catagories(catagory_name,catagory_desc) values (?,?)");
            ps.setString(1,e.getCatagory_name());
            ps.setString(2,e.getCatagory_desc());

            status=ps.executeUpdate();

            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }

    public static List<eventCategoryBean> getAllCategories(){
        List<eventCategoryBean> list=new ArrayList<eventCategoryBean>();

        try{
            Connection con= eventCategoryDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from event_catagories");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                eventCategoryBean e=new eventCategoryBean();
                e.setCatagory_name(rs.getString(1));
                e.setCatagory_desc(rs.getString(2));
                list.add(e);
            }
            con.close();
        }catch(Exception e){e.printStackTrace();}

        return list;
    }
}
