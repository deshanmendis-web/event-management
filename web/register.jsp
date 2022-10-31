<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Login | Event Management System</title>
  <link rel="stylesheet" type="text/css" href="assets/css/register.css">
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css">
</head>
<body>
<div class="bgoverlay"></div>
<div class="container">
  <div class="form sign-in-container">
    <form action="SaveUserServlet" method="post">
      <h1>Sign UP</h1>
      <input type="email" name="txtEmail" placeholder="User Email">
      <input type="password" name="txtPassword" placeholder="Password">
      <input type="password" placeholder="Retype Password">
      <input type="text" name="cmbRole" value="2" style="display: none">
      <button type="submit">Sign Up</button>
    </form>
  </div>
  <div class="overlay-container">
    <div class="overlay">
      <div class="overlay-panel overlay-right">
        <h1>Sign In</h1>
        <p>Already have an account?</p>
        <button class="signup_btn"><a href="login.jsp">Sign In</a></button>
      </div>
    </div>
  </div>
</div>
</body>
</html>
