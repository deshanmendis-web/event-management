package eventCategory.web;

import event.database.eventDao;
import eventCategory.bean.eventCategoryBean;
import eventCategory.database.eventCategoryDao;
import student.bean.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SaveEventCategoryServlet", value = "/SaveEventCategoryServlet")
public class SaveEventCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String catagory_name=request.getParameter("catagory_name");
        String catagory_desc=request.getParameter("catagory_desc");

        eventCategoryBean e=new eventCategoryBean();

        e.setCatagory_name(catagory_name);
        e.setCatagory_desc(catagory_desc);

        int status= eventCategoryDao.save(e);
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

        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("eventcategories.jsp");
        dispatcher.forward(request, response);

        out.close();
    }

}

