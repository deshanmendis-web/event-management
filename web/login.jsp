<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Login | Event Management System</title>
  <link rel="stylesheet" type="text/css" href="assets/css/login.css">
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css">
</head>
<body>
<div class="bgoverlay"></div>
<div class="container">
  <div class="form sign-in-container">
    <form action="<%=request.getContextPath()%>/login" method="post">
      <h1>Sign in</h1>
      <input type="text" name="email" placeholder="User Email">
      <input type="text" name="password" placeholder="Password">
      <a href="#">Forgot your password?</a>
      <button type="submit">Sign In</button>
    </form>
  </div>
  <div class="overlay-container">
    <div class="overlay">
      <div class="overlay-panel overlay-right">
        <h1>Sign UP</h1>
        <p>Create new Account.</p>
        <button class="signup_btn"><a href="register.jsp">Sign Up</a></button>
      </div>
    </div>
  </div>
</div>
</body>
</html>