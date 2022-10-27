package login.bean;

// 1. Create Login Model
public class LoginBean {

    // 2. Define variables for fields of users tabel
    private String email;
    private String password;

    // 3. Create getters and setters to access private variables
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
}
