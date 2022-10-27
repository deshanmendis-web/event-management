package login.web;

import login.bean.RegisterBean;
import login.database.RegisterDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SaveUserServlet")
public class SaveUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String email=request.getParameter("email");
        String password=request.getParameter("password");

        RegisterBean e=new RegisterBean();
        e.setEmail(email);
        e.setPassword(password);

        int status= RegisterDao.save(e);
        if(status>0){
            out.print("<p>Record saved successfully!</p>");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }else{
            out.println("Sorry! unable to save record");
        }

        out.close();
    }

}