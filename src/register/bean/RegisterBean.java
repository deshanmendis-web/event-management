package register.bean;

// Create Registration Bean Class
public class RegisterBean {

    // Create Variables to define columns of users table
    private String email,password;
    private int role;

    // Create getters and setters to access private variables
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
