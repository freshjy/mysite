<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/user.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-3.5.1.js"></script>
<script>
$(function(){
	$('#btn-check-email').click(function(){
		let email=$('#email').val();
		if(email == ''){
			$('#email').focus();
			return;
		}
		
		$.ajax({
			url: '${pageContext.request.contextPath }/api/user/existemail?' + email,
			async:true,
			data:'',
			dataType: 'json',
			success: function(response){
				if(response.result != 'success'){
					consol.error(response.message);
					return;
				}
				
				if(response.data){
					alert("존재 하는 이메일 입니다. 다른 이메일을 사용해 주세요.");
					$("#email")
						.val('')
						.focus();
					return;
				}
				$('#img-check-email').show();
				$('#btn-check-email').hide();
			},
			error: function(XHR, status, e){
				console.error(status + ":" + e);
			}
		});
		
	});
});
</script>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="user">

				<form:form
					modelAttribute="userVo"
					id="join-form"
					name="joinForm"
					method="post"
					action="${pageContext.request.contextPath }/user/join">
					
					<label class="block-label" for="name">이름</label>
					<form:input path="name" />
					<p style="text-align:left; padding:5px 0 0 0; color:#f00">
						<form:errors path="name"/>
					</p>
											
					<label class="block-label" for="email">이메일</label>
					<form:input path="email" /> 
					<img id="img-check-email" style='display:none; width:28px; vertical-align: middle' src='${pageContext.request.contextPath }/assets/images/check.png' />
					<input style='display:;' id="btn-check-email" type='button' value='중복확인' />
					<p style="text-align:left; padding:5px 0 0 0; color:#f00">
						<form:errors path="email"/>
					</p>

					<label class="block-label">패스워드</label>
					<form:password path="password" />
					
					<fieldset>
						<legend>성별</legend>
						<label>여</label> <form:radiobutton path="gender" value="female" checked="checked" />
						<label>남</label> <form:radiobutton path="gender" value="male" />
					</fieldset>
					
					<fieldset>
						<legend>약관동의</legend>
						<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
						<label>서비스 약관에 동의합니다.</label>
					</fieldset>
					
					<input type="submit" value="가입하기">
					
				</form:form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>