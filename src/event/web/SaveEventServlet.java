package event.web;

import event.bean.eventBean;
import event.database.eventDao;
import eventCategory.bean.eventCategoryBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "SaveEventServlet", value = "/SaveEventServlet")
public class SaveEventServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String event_name=request.getParameter("txtEventName");
        String venue=request.getParameter("txtEventVenue");
        Date event_date= Date.valueOf(request.getParameter("dateEventDate"));
        Boolean isactive= Boolean.valueOf(request.getParameter("txtIsActive"));
        Integer categoryid = Integer.parseInt(request.getParameter("cmbEventCategory"));
        System.out.println(event_name);
        eventBean e=new eventBean();

        e.setEventName(event_name);
        e.setVenue(venue);
        e.setEventDate(event_date);
        e.setIsActive(isactive);
        e.setCatagoryId(categoryid);

        int status= eventDao.save(e);
        if(status>0){
            out.print("<p>Record saved successfully!</p>");
            request.getRequestDispatcher("events.jsp").include(request, response);
        }else{
            out.println("Sorry! unable to save record");
        }

        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        List<eventCategoryBean> list= eventDao.getAllCategories();

        for(eventCategoryBean e:list){
            out.print("<option value="+e.getCategoryid()+">"+e.getCatagory_name()+"</option>");
        }

        out.close();
    }

}