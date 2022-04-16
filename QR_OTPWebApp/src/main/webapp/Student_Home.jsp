<%@page import="com.dataBase.DaoForAll"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

	.homeStudent{
  	width: 600px;
	}
	
	table, tr,th,td{
  	border: 1px solid black;
  	border-collapse: collapse;
	}

	th,td{
  	text-align: center;
	}
	
</style>
</head>
  <%
  response.setHeader("Cache-Control","no-cache, no-store ,must-revalidate");
  %>
  <%
		
		if(session.getAttribute("isUserLoggedIn") == null)
		{
			response.sendRedirect("Student_LoginPage.jsp");
		}
	
	%>
  
<body>
	<h1>Welcome <%= (String)session.getAttribute("Name")%></h1>
	
	<p></p>
	<table class="homeStudent">
		<tr bgcolor="lightblue">
          	<th>SAP ID</th>
          	<th>Name</th>
          	<th>Branch</th>
          	<th>Year</th>
          	<th>Attendance Time</th>
        </tr>
	  
	<%
		String sapid= (String)session.getAttribute("sapid");
		System.out.println("SAP ID: 500075327");
		DaoForAll t= new DaoForAll(); 
		ResultSet rs= t.getStudentAttendanceDetails(sapid);
	    while (rs.next()) {
    %>
      	<tr>
        	<td><%= sapid%></td>
       		<td><%=rs.getString("name")%></td>
       		<td><%=rs.getString("dept")%></td>
        	<td><%=rs.getString("year")%></td>
        	<td><%=rs.getString("attendance_time")%></td>
      	</tr>
	<%
	    }
	%>
	
	</table>
	<br>
	<br>
	<form action="Logout" method="post">
		<button>Log Out</button>
	</form> 
	
</body>
</html>