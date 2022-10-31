package register.web;

import register.bean.RegisterBean;
import register.database.RegisterDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SaveUserServlet", value = "/SaveUserServlet")
public class SaveUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String email=request.getParameter("txtEmail");
        String password=request.getParameter("txtPassword");
        int role= Integer.parseInt(request.getParameter("cmbRole"));

        RegisterBean e=new RegisterBean();

        e.setEmail(email);
        e.setPassword(password);
        e.setRole(role);

        int status= RegisterDao.save(e);
        if(status>0){
            out.print("<p>Record saved successfully!</p>");
            //request.getRequestDispatcher("login.jsp").include(request, response);
        }else{
            out.println("Sorry! unable to save record");
            out.println(e);
        }

        out.close();
    }

}