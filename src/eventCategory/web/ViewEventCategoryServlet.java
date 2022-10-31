package eventCategory.web;

import eventCategory.bean.eventCategoryBean;
import eventCategory.database.eventCategoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ViewEventCategoryServlet")
public class ViewEventCategoryServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        List<eventCategoryBean> list= eventCategoryDao.getAllCategories();

    }
}
