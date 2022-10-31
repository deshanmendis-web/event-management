<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Event Management System</title>

  <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
  <!-- Custom styles -->
  <link href="assets/css/dashboard.css" rel="stylesheet">

</head>
<% //In case, if Admin session is not set, redirect to Login page
  if((request.getSession(false).getAttribute("Admin")== null) )
  {
%>
<jsp:forward page="login.jsp"></jsp:forward>
<%} %>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Event Management System</a>
    </div>
  </div>
</nav>

<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
      <ul class="nav nav-sidebar">
        <li><a href="admin.jsp">Home</a></li>
        <li><a href="events.jsp">Events</a></li>
        <li><a href="eventcatagories.jsp">Event Catagory</a></li>
        <li><a href="packages.jsp">Packages</a></li>
        <li class="active"><a href="users.jsp">Users<span class="sr-only">(current)</span></a></li>
        <li><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></li>
      </ul>
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <h1 class="page-header">Dashboard</h1>

      <div class="flex" style="display: flex; gap: 24px; align-items: center;">
        <h2 class="sub-header">Users</h2>
        <button type="button" class="btn btn-success" style="max-height: 35px;"><a href="adduser.jsp"><i class="fa fa-plus" aria-hidden="true"></i></a></button>
      </div>
      <div class="table-responsive">
        <table class="table table-striped">
          <thead>
          <tr>
            <th>Email</th>
            <th>Password</th>
            <th>Role</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="user" items="${listUser}">

            <tr>
              <td>
                <c:out value="${user.email}" />
              </td>
              <td>
                <c:out value="${user.password}" />
              </td>
              <td>
                <c:out value="${user.role}" />
              </td>
              <td><a href="edit?id=<c:out value='${user.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${user.id}' />">Delete</a></td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>

