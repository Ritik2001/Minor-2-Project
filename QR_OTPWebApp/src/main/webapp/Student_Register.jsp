<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;700&display=swap" rel="stylesheet">
<style type="text/css">
	
		body,html{
		 background-color:#1A1B21;
		 color: white;
		 font-family: 'Inter', sans-serif;
		 margin: 0;
		 width:100%;
		 height: 100%;
		 
	}
		*,
		*:before,
		*:after {
  			box-sizing: border-box;
  			position: relative;
		}
	
	.registration_section{
		display: flex;		
		width:100%;
		height: 100%;
	}
	.registration_section >*{
		width:100%;
	}
	
	#formSection{
		background-color: #23252C;	
		display: flex;
		justify-content: center;
		align-items: center;
		padding: 1rem 3rem;
	}
	
	#formBox{
		width: 65% ;
		background-color: white;
		color: black;
		box-shadow: 2px 2px 0px gray;
		border-radius: 1.2rem;
		display: flex;
		flex-direction: column;
		gap: 1.5rem;
		padding: 2rem 2.5rem;
	}
	
	input{
		font-size: 1.2rem;
		font-weight: 400;
		height:2.42rem;
		border-radius: 0.4rem;
	}
	select{
	height:2.42rem;
	}
	input:focus{
	
	    font-size: 1.3rem;
	}
	
	#heading{
		font-size: 2rem;
		font-weight: bold;
		text-align: center;
		margin-bottom: 0px;
	}
	
</style>
</head>

	<%
	if(request.getParameter("isSapID")!=null){
	%>
	<script> alert('SapID should be a 9 digit Number'); </script>
	<%
		}
	%>

<body>
	<section class="registration_section">
		<div id="formSection">

			<form id="formBox" action="registration_process" method="post">
				<p id="heading">Register</p>
				<input type="text" name="FirstName" placeholder="First Name" >
				<input type="text" name="LastName" placeholder="Last Name">
				<input type="text" name="SapID" placeholder="Sap ID">
				<input type="email" name="EmailId" placeholder="Email ID">
				<input type="password" name="Password" placeholder="Password">
				<input type="text" name="Branch" placeholder="Branch">
				<select name="Year" required="">
                  <option value="">Select Your Year</option>
                  <option>First</option>
                  <option>Second</option>
                  <option>Third</option>
                  <option>Final</option>
                </select>
				<input type="date" name="DOB" >
				<button>Register</button>
			</form>
		
		</div>
		<div></div>
	</section>

</body>
</html>