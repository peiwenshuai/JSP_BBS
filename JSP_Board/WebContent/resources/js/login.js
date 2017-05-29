var userRegi = (function() {

	var userId;
	var userPwd;
	var userName;
	var userAge;
	var userGender;

	return {
		_regiPro : function() {

			if ($("#id_check").val() == 'undefined' || $("#id_check").val() == '') {
				alert("Please click check button(Unavailable! Id)");
				return false;
			}
			if ($("#pwd").val() == 'undefined' || $("#pwd").val() == '') {
				alert("Please input your password");
				return false;
			}

			userId = $("#id").val();
			userPwd = $("#pwd").val();
			userName = $("#name").val();
			userAge = $("#age").val();
			$("input[name='gender']").each(function(index) {
				if ($(this).prop("checked")) {
					userGender = $(this).val();
					return false;
				}
			});

			var param = {
				userId : userId,
				userPwd : userPwd,
				userName : userName,
				userAge : userAge,
				userGender : userGender
			};

			$.ajax({
				url : contextPath + "/loginController/user_register.do",
				type : "post",
				data : param,
				dataType : "text",
			}).done(function(data) {
				alert("User Add Success. Do Login!");
				$("#myModal").modal('hide');
			}).fail(function(data) {
				alert("User Add Fail.");
				$("#myModal").modal('hide');
			});

		},

		_checkIdPro : function() {
			var checkId = $("#id").val();
			if (checkId === 'undefined' || checkId == '') {
				alert("Please input id");
				$("#id").focus();
				return false;
			}
			var param = {
				userId : checkId
			};
			$.ajax({
				url : contextPath + "/loginController/user_id_check.do",
				type : "post",
				data : param,
				dataType : "text",
			}).done(function(data) {
				if (data == 'true') {
					$("#check_success").hide();
					$("#check_fail").show();
					$("#id_check").val('');
				} else {
					$("#check_fail").hide();
					$("#check_success").show();
					$("#id_check").val(checkId);
				}
			}).fail(function(data) {
				console.log(data);
			});

		},
	}

})();