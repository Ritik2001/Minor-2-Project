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
	
		width: 100%;
		height: 100vh;
		margin: 0;
		
	}
	
	*,
	*:before,
	*:after {
  			box-sizing: border-box;
		}
		
	.Banner { 
		padding-top: 2.2rem;
		width: 100%; 
		background: url(img/Banner-bg.jpg) top center no-repeat; 
		height: 400px; 
		background-size: cover; 
		}
		
	.Banner>h1{
		color: white;
		font-weight: 600;
		font-family: Arial;
		font-size: 36px;
		text-align: center;
		margin: 0;
	}
	.verifyContainer{
		color: white;
		width: 100%;
		height: 100%;
		border: 1px solid black;
		padding-left: .5rem;
		padding-bottom: .5rem; 
		background: url(img/Get-bg.jpg) top center no-repeat; 
		background-size: cover;
	}
	
	.verifyContainer>h2{
		text-align: center;
		font-family: 'Inter', sans-serif;
	}
	form{
	 width: 100%;
	 height: 100%;
	}
	
</style>
</head>

	<%
	if(request.getParameter("VerificationFailed")!=null){
	%>
	<script> alert("Invalid OTP and QRCode , Verification Failed!!"); </script>
	<%
		}
	%>

<body>

	<div class="Banner">
		
	<h1> E-Authentication System with QR Code & OTP </h1>
	
	</div>
	
	<div class="verifyContainer">
		<h2>QR-Code and OTP Verification</h2>
		<form action="verify" method="post" enctype="multipart/form-data">
	
			<p>Enter the OTP sent to your registered emailID: </p>
			<input type="text" name="otp"/><br>
			<p>Upload your QR:</p>
			<input type="file" name="qr"/><br><br>
			<button>Verify E-Authentication</button>
		</form>
	</div>
	
</body>
</html>