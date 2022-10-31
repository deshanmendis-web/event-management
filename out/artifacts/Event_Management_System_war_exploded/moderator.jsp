<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editor Page</title>
</head>
<% //In case, if Editor session is not set, redirect to Login page
    if((request.getSession(false).getAttribute("Editor")== null) )
    {
%>
<jsp:forward page="login.jsp"></jsp:forward>
<%} %>
<body>
<center><h2>Editor's Home</h2></center>

Welcome <%=request.getAttribute("email") %>

<div style="text-align: right"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>

</body>
</html>
