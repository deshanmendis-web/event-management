<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>User Page</title>
</head>
<% //In case, if User session is not set, redirect to Login page.
  if((request.getSession(false).getAttribute("User")== null) )
  {
%>
<jsp:forward page="login.jsp"></jsp:forward>
<%} %>
<body>
<center><h2>User's Home</h2></center>
Welcome <%=request.getAttribute("email") %>

<div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>

</body>
</html>