<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
request.setCharacterEncoding("UTF-8"); 
%>
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
<table class="table" style="width: 65%;margin: auto;">
    <thead>
      <tr style="text-align: center">
        <th>No.</th>
        <th>Id.</th>
        <th>Title</th>
        <th>View</th>
      </tr>
    </thead>
    <tbody id="tbodyContent">
    <c:choose>
    	<c:when test="${!empty boardInfoBeanList}">
    		<c:forEach var="item" items="${boardInfoBeanList}" varStatus="status">
    			<tr>
    			<td>${item.boardNum}</td>
    			<td>${item.userId}</td>
    			<td style="cursor: pointer; text-decoration: underline; font-weight: bold;" onClick='boardController._displayBoardContent(${item.boardIdx})'>${item.boardTitle}</td>
    			<td>${item.viewCnt}</td>
    			</tr>
    		</c:forEach>
    	</c:when>
    	<c:otherwise>
    	<tr style="text-align: center;"><td colspan=4>작성된 글이 없습니다.</td></tr>
    	</c:otherwise>
    </c:choose>  
    </tbody>
  </table>
		
</div>
<div id="content-footer" style="width: 65%; margin: auto">
	<div style="float: right;">
		<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Write</button>
	</div>
	<c:if test="${linkPage ne 0}">
	<ul class="pagination" style="margin: auto;">
		<li onclick="boardController._pageMove(1)"><a href="javascript:void(0);"><<</a></li>
		<li onclick="boardController._pageMove(${prevPageIndex})"><a href="javascript:void(0);"><</a></li>
			<c:forEach begin="${prevPageIndex}" end="${nextPageIndex}"  varStatus="status">
   			<c:choose>
   			<c:when test="${pageIndex eq  status.index}">
   			<li class="active" onclick="boardController._pageMove(${status.index})"><a href="javascript:void(0);">${status.index}</a></li>
   			</c:when>
   			<c:otherwise>
   			<li onclick="boardController._pageMove(${status.index})"><a href="javascript:void(0);">${status.index}</a></li>
   			</c:otherwise>
   			</c:choose>
			</c:forEach>
		<li onclick="boardController._pageMove(${nextPageIndex})"><a href="javascript:void(0);">></a></li>
		<li onclick="boardController._pageMove(${linkPage})"><a href="javascript:void(0);">>></a></li>
	</ul>
	</c:if>
</div>

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

<!-- BoardModal -->
<div id="myBoardModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
      	<button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title" id="boardTitle"></h4>
      	<div class="form-group" style="width: 60%">
    	  	<span class="label label-primary">Writer :</span>
    		<input type="text" class="form-control" id="userId" disabled="disabled">
    		<span class="label label-primary">Registration Date :</span>
    		<input type="text" class="form-control" id="regiDate" disabled="disabled">
    		<span class="label label-primary">View :</span>
    		<input type="text" class="form-control" id="viewCnt" disabled="disabled">
  		</div>
        
      </div>
      <div class="modal-body">
        <p id="boardContent"></p>
      </div>
      <div class="modal-footer">      
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>

</body>
</html>
<script type="text/javascript">
var contextPath = "${pageContext.request.contextPath}";
</script>
<script src="${pageContext.request.contextPath}/resources/js/bbs.js"></script>