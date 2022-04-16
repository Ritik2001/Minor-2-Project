<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

	@import url('https://fonts.googleapis.com/css2?family=Inter:wght@300;400;700&display=swap');
* {
  box-sizing: border-box;
}

body {
  margin: 0;
  background-color: #639;
  height: 100vh;
  
}

#root{
  height: 100%;
  background-color: #639;
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: 'Inter',sans-serif;
}
.form{
  display: flex;
  flex-direction: column;
  background-color: white;
  border: 2px solid white;
  border-radius: 1rem;
  box-shadow: 3px 4px lightgray;
  gap: 2rem;
  padding: 5rem 5rem;
  align-items: center;
 
}
 .form>p{
 
 	margin:0;
 	font-size: 2rem;
 	font-weight: 700;
 	font-style: italic;
 }
.inputBar{
  width: 100%;
  font-size: 1.2rem;
  border-radius: 5px;
  text-indent: 4px;
  height: 2.8rem;
  font-family: 'Inter',sans-serif;
}

.submitButton{
  font-size: 1.2rem;
  width: 50%;
  padding: .8rem 1rem ;
  color: white;
  border: none;
  background-color: #639;
  border-radius: 10px;
}
</style>
</head>

	<%
		if(request.getParameter("login")!= null)
		{
	%>
	<script>alert("Login Failed");</script>
	<%		
		}
	%>
<body>
	<div id="root">
	<form class="form" action="Staff_LoginCheck" method="post">
		<p>Faculty Login</p>
        <input 
        type="text"
        placeholder="Faculty ID"
        class="inputBar"
        name="staff_id"
        />
        <input 
        type="password"
        placeholder="Password"
        class="inputBar"
        name="password"
        />
       <!--  <input 
        type="email"
        placeholder="Email"
        class="inputBar"
        name="email"
        />
        --> 
        <button class="submitButton">Login</button>  
    </form>
    </div>
</body>
</html>