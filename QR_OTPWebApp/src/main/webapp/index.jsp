<html>

<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;700&display=swap" rel="stylesheet">
<style type="text/css">

	body,html{
		 background-color:#1A1B21;
		 color: white;
		 font-family: 'Inter', sans-serif;
		 margin: 0;
		 width:100%;
		 height: 100%;
		 
	}
	 body{
	 	display: flex;
		flex-direction: column;
	 }
	 body>*{
	 	
	 	width: 100%;
	 	height: 100%
	 }
	.navButton{
		font-size: 1.4em;
		text-decoration: none;
		color: white;
	}
	
	#navBar{
		background-color:#5093E2;
		width: 100%;
		height: 10%;
		display: flex;
		justify-content: flex-end;
		align-items: center;
		gap: 2.4em;
	}
	section{
		display: flex;
		justify-content: center;
		align-items: center;
	}
	
	section>img{
		width: 70%;
	}
	 a:nth-last-child(1){
		margin-right: 2.5em; 
	 }
</style>
</head>
<body>


<nav id="navBar">

	<a class="navButton" href="index.jsp" target="_blank">Home</a>
	<a class="navButton" href="Student_Register.jsp" target="_blank">Register</a>
	<a class="navButton" href="Student_LoginPage.jsp" target="_blank">Student</a>
	<a class="navButton" href="Staff_LoginPage.jsp" target="_blank">Staff</a>
</nav>

<section>
	<img src="img/main.jpg"  />
</section>

</body>
</html>
