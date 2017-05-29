<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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


<title>JSP Board Login Page</title>
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
					<li><a href="boardController/board_main.do">BBS</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<button class="btn dropdown-toggle" type="button" data-toggle="dropdown" style="background-color: #222; color: white; height: 50px">
							접속하기 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="login.jsp">Login</a></li>
							<li><a href="#" data-toggle="modal" data-target="#myModal">회원가입</a></li>
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
	
	
	
	<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Please input your information</h4>
        </div>
        <div class="modal-body">
          <form class="form-horizontal" method="post" action="#">
    <div class="form-group">
      <label class="control-label col-sm-2" for="id">Id:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="id" placeholder="Enter your id">
      </div>
    </div>
    <div class="form-group">
    <label class="control-label col-sm-2">Check ID:</label>
    <div class="col-sm-3">    
    <button type="button" class="btn btn-info" onclick="userRegi._checkIdPro()">Check</button>
        <input type="hidden" id="id_check" value="">
    </div>
    <div class="col-sm-7">    
    	<div class="alert alert-info" id="check_success" style="margin: 0px; padding: 6px; display: none;">
    	<strong>Available!</strong> You can use this id.
  		</div>
  		<div class="alert alert-danger" id="check_fail" style="margin: 0px; padding: 6px; display: none;">
    	<strong>Unavailable!</strong> Please input another id.
  		</div>
    </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Password:</label>
      <div class="col-sm-10">          
        <input type="password" class="form-control" id="pwd" placeholder="Enter password">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="name">name:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="name" placeholder="Enter your name">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="age">age:</label>
      <div class="col-sm-10">
        <input type="number" class="form-control" id="age" placeholder="Enter your age">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="Id">gender:</label>
      <div class="col-sm-10">
        <label class="radio-inline">
          <input type="radio" name="gender" value="남자" checked="checked">Man
        </label>
    <label class="radio-inline">
      <input type="radio" name="gender" value="여자">Woman
    </label>
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="button" class="btn btn-default" onclick="userRegi._regiPro()">Submit</button>
      </div>
    </div>
  </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>

</body>
</html>
<script>
var contextPath = "${pageContext.request.contextPath}";
</script>
<script src="resources/js/login.js"></script>