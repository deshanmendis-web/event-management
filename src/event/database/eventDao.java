package event.database;

import connection.DBConnection;
import event.bean.eventBean;
import eventCategory.bean.eventCategoryBean;
import eventCategory.database.eventCategoryDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class eventDao {
    public static Connection getConnection(){

        Connection con = null;
        Statement statement = null;

        try{
            con = DBConnection.createConnection();
            statement = con.createStatement();
        }catch(Exception e){System.out.println(e);}
        return con;
    }

    public static int save(eventBean e){
        int status=0;
        try{
            Connection con= eventDao.getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "insert into events(event_name,venue,event_date,isactive,catagoryid) values (?,?,?,?,?)");
            ps.setString(1,e.getEventName());
            ps.setString(2,e.getVenue());
            ps.setDate(3, e.getEventDate());
            ps.setBoolean(4,e.getIsActive());
            ps.setInt(5,e.getCatagoryId());

            status=ps.executeUpdate();

            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return status;
    }

    public static List<eventCategoryBean> getAllCategories(){
        List<eventCategoryBean> list=new ArrayList<eventCategoryBean>();

        try{
            Connection con= eventCategoryDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select catagory_name from event_catagories");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                eventCategoryBean e=new eventCategoryBean();
                e.setCatagory_name(rs.getString(1));
                list.add(e);
            }
            con.close();
        }catch(Exception e){e.printStackTrace();}

        return list;
    }

    public static List<eventBean> getAllevents(){
        List<eventBean> list=new ArrayList<eventBean>();

        try{
            Connection con= eventDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from events");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                eventBean e=new eventBean();
                e.setEventName(rs.getString(1));
                e.setVenue(rs.getString(2));
                e.setEventDate(rs.getDate(3));
                e.setIsActive(rs.getBoolean(4));
                e.setCatagoryId(rs.getInt(5));
                list.add(e);
            }
            con.close();
        }catch(Exception e){e.printStackTrace();}

        return list;
    }
}
