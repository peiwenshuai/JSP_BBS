
var boardController = (function(){

	return {
		_pageMove : function(pageIndex){
			location.href = contextPath + "/boardController/board_main.do" + "?pageIndex=" + pageIndex;
		}
	}
})();