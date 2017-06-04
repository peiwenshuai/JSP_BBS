<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
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
					<a class="navbar-brand" href="../loginController/login_view.do">JSP Board Made By.
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
							<li><a href="../logoutController/logout.do">Logout</a></li>
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
	<div id="content-footer"><button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Write</button></div>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Write BBS</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" method="post" action="../boardController/board_write.do">
  <div class="form-group">
    <label class="control-label col-sm-2" for="title_text">Title:</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="title_text" name="title" placeholder="Enter title">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="content_text">Content:</label>
    <div class="col-sm-10"> 
      <textarea rows="5" cols="5" style="width: 100%; resize: none" id="content_text" name="content"></textarea>
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Write</button>
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
<script src="${pageContext.request.contextPath}/resources/js/bbs_main.js"></script>