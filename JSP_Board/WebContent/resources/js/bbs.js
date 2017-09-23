$(document).ready(function () {
	$("#myBoardModal").on('hide.bs.modal', function(){
		window.location.reload();
	});
});


var boardController = (function() {
	return {
		_pageMove : function(pageIndex) {
			location.href = contextPath + "/boardController/board_main.do" + "?pageIndex=" + pageIndex;
		},
		_displayBoardContent : function(idx) {
			
			var param = {boardIdx : idx};

			$.ajax({
				url : contextPath + "/boardController/board_content_read.do",
				type : "post",
				dataType : "json",
				data : param,
				async : false
			}).done(function(data) {
				$("#boardTitle").val(data.boardTitle);
				$("#userId").val(data.userId);
				$("#viewCnt").val(data.viewCnt);
				$("#regiDate").val(data.boardRegiDate);
				$("#boardContent").html(data.boardContent);
				$("#myBoardModal").modal();
			}).fail(function(data) {
				console.log(data);
				alert("해당 게시물을 읽어오는 도중, 에러가 발생했습니다. 관리자에게 문의해 주세요.");
			});


			
		}
	}
})();