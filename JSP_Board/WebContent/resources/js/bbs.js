var boardController = (function() {
	return {
		_pageMove : function(pageIndex) {
			location.href = contextPath + "/boardController/board_main.do" + "?pageIndex=" + pageIndex;
		},
		_displayBoardContent : function(idx) {

			$.ajax({
				url : contextPath + "/boardController/board_content_read.do",
				type : "post",
				dataType : "json",
				data : param,
				async : false
			}).done(function(data) {
				
			}).fail(function(data) {
				console.log(data);
			});


			$("#myBoardModal").modal();
		}
	}
})();