<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no">

<link rel="stylesheet" href="../resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">

<script src="../resources/jquery/jquery-3.2.1.min.js"></script>
<script src="../resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>


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
					<a class="navbar-brand" href="../index.jsp">JSP Board Made By.
						devBae</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="board_main.do">BBS</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<button class="btn dropdown-toggle" type="button" data-toggle="dropdown" style="background-color: #222; color: white; height: 50px">
							접속하기 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="../loginController/logout.do">Login Out</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</nav>

	</div>
	<div id="content-body">
<table class="table">
    <thead>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>John</td>
        <td>Doe</td>
        <td>john@example.com</td>
      </tr>
      <tr>
        <td>Mary</td>
        <td>Moe</td>
        <td>mary@example.com</td>
      </tr>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@example.com</td>
      </tr>
    </tbody>
  </table>
		
	</div>
	<div id="content-footer"></div>

</body>
</html>