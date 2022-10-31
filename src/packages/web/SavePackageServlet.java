package packages.web;

import packages.bean.PackageBean;
import packages.database.PackageDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SavePackageServlet", value = "/SavePackageServlet")
public class SavePackageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String package_name=request.getParameter("package_name");
        String package_code=request.getParameter("package_code");
        int package_cost= Integer.parseInt(request.getParameter("package_cost"));

        PackageBean e=new PackageBean();

        e.setPackageName(package_name);
        e.setPackageCode(package_code);
        e.setPackageCost(package_cost);

        int status= PackageDao.save(e);

        if(status>0){
            out.print("<p>Record saved successfully!</p>");
            request.getRequestDispatcher("packages.jsp").include(request, response);
        }else{
            out.println("Sorry! unable to save record");
        }

        out.close();
    }
}
