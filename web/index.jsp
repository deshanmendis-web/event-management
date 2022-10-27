<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Insert title here</title>
</head>
<body>

<h1>Add New Student</h1>
<form action="SaveServlet" method="post">
  <table>
    <tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
    <tr><td>Password:</td><td><input type="password" name="password"/></td></tr>
    <tr><td>Email:</td><td><input type="email" name="email"/></td></tr>
    <tr><td>Country:</td><td>
      <select name="country" style="width:150px">
        <option value="India">India</option>
        <option value="USA">USA</option>
        <option value="UK">UK</option>
        <option value="Other">Other</option>
      </select>
    </td></tr>
    <tr><td colspan="2"><input type="submit" value="Save Student"/></td></tr>
  </table>
</form>

<br/>
<a href="ViewServlet">View Students</a>

</body>
</html>