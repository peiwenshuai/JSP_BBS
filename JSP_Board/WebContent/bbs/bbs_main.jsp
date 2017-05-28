<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">

<link rel="stylesheet" href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">

<script src="resources/jquery/jquery-3.2.1.min.js"></script>
<script src="resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>


<style>

.center_div {
    margin: auto;
    width: 45%;
    border: 2px solid;
    padding: 10px;
    border-color: gray;
    border-radius : 15px;
}

</style>
<title>BBS Main</title>
</head>
<body>

<div id="content-header">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="index.jsp">JSP Board Made By.
						devBae</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Main</a></li>
					<li><a href="#">BBS</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<button class="btn btn-primary dropdown-toggle" type="button"
							data-toggle="dropdown">
							접속하기 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li class="active"><a href="login.jsp">Login</a></li>
							<li><a href="#">회원가입</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</nav>

	</div>
	<div id="content-body">

		<div class="row center_div">
			<div class="col-xs-6" style="margin: auto; padding: 10px; float: none">
				<form id="login-form" method="post" action="loginController/login.do">
					<div class="form-group">
						<label for="userId">ID :</label> 
						<input type="text" class="form-control" id="userId" name="userId">
					</div>
					<div class="form-group">
						<label for="userPwd">Password :</label> 
						<input type="password" class="form-control" id="userPwd" name="userPwd">
					</div>
					<div class="checkbox">
						<label><input type="checkbox"> Remember ID</label>
					</div>
					<button type="submit" class="btn btn-default">Login</button>
				</form>
			</div>
		</div>


	</div>
	<div id="content-footer"></div>

</body>
</html>