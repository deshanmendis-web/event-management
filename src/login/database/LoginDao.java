package login.database;

// Import Packages Needed
import java.sql.*;

// Import Login Model
import login.bean.LoginBean;
import connection.DBConnection;

public class LoginDao {
    public String authenticateUser(LoginBean loginBean)
    {
        String email = loginBean.getEmail();
        String password = loginBean.getPassword();
        int role = loginBean.getRole();

        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String emailDB = "";
        String passwordDB = "";
        int roleDB = 0;

        try
        {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select email,password,role from users");

            while(resultSet.next())
            {
                emailDB = resultSet.getString("email");
                passwordDB = resultSet.getString("password");
                roleDB = resultSet.getInt("role");

                if(email.equals(emailDB) && password.equals(passwordDB) && roleDB==1)
                    return "Admin_Role";
                else if(email.equals(emailDB) && password.equals(passwordDB) && roleDB==2)
                    return "User_Role";
                else if(email.equals(emailDB) && password.equals(passwordDB) && roleDB==3)
                    return "Moderator_Role";
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }
}
