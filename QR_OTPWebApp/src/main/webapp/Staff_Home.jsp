<%@page import="java.sql.ResultSet"%>
<%@page import="com.dataBase.DaoForAll"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;700&display=swap" rel="stylesheet">
<style type="text/css">
	
	body,html{
		 background-color:#23252C;
		 color: white;
		 font-family: 'Inter', sans-serif;
		 width:100%;
		 height: 100%;
		 
	}
	.studentsDetailsTable{
  	
	}
	table, tr,th,td{
  	border: 1px solid white;
  	border-collapse: collapse;
	}
	
	th,td{
  	text-align: center;
	}
	td{
		padding: .5rem;
	}
	
	div{
		text-align: center;
	}
	div>table{
	width: 600px;
  	margin-left: auto;
  	margin-right: auto;
	}
	div>p{
	
		font-size: 1.2rem;
		font-style: italic;
	}
	
</style>
</head>

	<%
  	response.setHeader("Cache-Control","no-cache, no-store ,must-revalidate");
  	%>
   <%
		
		if(session.getAttribute("isStaffLoggedIn") == null)
		{
			response.sendRedirect("Staff_LoginPage.jsp");
		}
	
	%>
<body>
	
		
		<h1>Welcome Staff!</h1>
	<div>
	<p>Student Details  </p>
	<table class="studentsDetailsTable">
	
		<tr bgcolor="#5093E2">
          	<th>First Name</th>
          	<th>Last Name</th>
          	<th>Sap ID</th>
          	<th>Email ID</th>
          	<th>Branch</th>
          	<th>Year</th>
        </tr>
 
	<%
		DaoForAll t1= new DaoForAll(); 
		ResultSet rs1= t1.getStudentsDetails();
	    while (rs1.next()) {
    %>
      	<tr>
        	<td><%=rs1.getString("fname") %></td>
       		<td><%=rs1.getString("lname")%></td>
       		<td><%=rs1.getString("sap_id")%></td>
       		<td><%=rs1.getString("email_id")%></td>
       		<td><%=rs1.getString("dept")%></td>
        	<td><%=rs1.getString("year")%></td>
      	</tr>
	<%
	    }
	%>
	</table>
	</div>
	
	<br>
	<div>
	<p>Attendance Details  </p>
	
	<table class="studentsDetailsTable">
	
		<tr bgcolor="#5093E2">
          	<th>Name</th>
          	<th>Sap ID</th>
          	<th>Attendance</th>
          	<th>Branch</th>
          	<th>Year</th>
        </tr>
 
	<%
		DaoForAll t2= new DaoForAll(); 
		ResultSet rs2= t2.getAllStudentAttendance();
	    while (rs2.next()) {
    %>
      	<tr>
        	<td><%=rs2.getString("name") %></td>
       		<td><%=rs2.getString("sap_id")%></td>
       		<td><%=rs2.getString("attendance_time")%></td>
       		<td><%=rs2.getString("dept")%></td>
        	<td><%=rs2.getString("year")%></td>
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
	
	</div>
</body>
</html>