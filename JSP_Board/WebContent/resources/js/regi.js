
var userRegi = (function(){
	
	var userId;
	var userPwd;
	var userName;
	var userAge;
	var userGender;
	
	return {
		_regiPro : function () {
			
			userId = $("#id").val();
			userPwd = $("#pwd").val();
			userName = $("#name").val();
			userAge = $("#age").val();
			$("input[name='gender']").each(function(index) {
				if($(this).prop("checked")){
					userGender = $(this).val();
					return false;
				}
			})
		
			//TODO : 폼 유효성 검사 추가해야함.
			
			var param = {userId : userId, userPwd : userPwd, userName : userName, userAge : userAge, userGender : userGender};
			
			$.ajax({
				url : contextPath + "/loginController/user_register.do",
				type : "post",
				data : param,
				dataType : "text",
			}).done(function(data){
				alert("ㅇㅇ?");
			}).fail(function (data) {
				alert("fail");
			});
			
	},
		
	}
	
	
})();