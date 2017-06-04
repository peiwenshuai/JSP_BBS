<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">

<script src="${pageContext.request.contextPath}/resources/jquery/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>


<style>

.center_div {
    margin: auto;
    width: 45%;
    border: 2px solid green;
    padding: 10px;
}

</style>
<title>Login Fail</title>
</head>
<body>
	<div id="content-header">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="index.jsp">JSP Board Made By. devBae</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="index.jsp">Go to Login Page</a></li>
				</ul>
			</div>
		</nav>
	</div>
	
	<div id="content-body">
		<div class="jumbotron text-center">
  			<h1>Login Fail <img src="resources/images/login_fail.png" alt="fail" width="42" height="42"></h1>
  			<p>Please check your id and password</p> 
		</div>
	</div>

	<div id="content-footer">
	</div>

</body>
</html>