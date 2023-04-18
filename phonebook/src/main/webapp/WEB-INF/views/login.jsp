<%@ include file="./header.jspf" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h3>로그인</h3>
<hr>

<form method="post">
<div class ="form-group row" style="margin: 15px 25px 15px 0px;">
	<label for="email" class="col-md-4">이메일</label>
	<div class="col-md-8">
	<!-- param.email 은 자기 줄의 param 의 email 즉 name="email"을 보여달라는 것임 -->
		<input type="email" class="form-control" name="email" id="email" value="${param.email}">
		<div class="text-danger">${errors.email}</div>
	</div>
</div>
<div class ="form-group row" style="margin: 15px 25px 15px 0px;">
	<label for="password" class="col-md-4">비밀번호</label>
	<div class="col-md-8">
		<input type="password" class="form-control" name="password" id="password">
		<div class="text-danger">${errors.password}</div>
	</div>
</div>
<div class ="form-group row" style="margin: 15px 25px 15px 0px;">
	<label for="" class="col-md-4"></label>
	<div class="col-md-8">
		<button class="btn btn-primary">로그인</button>
		<input type="reset" class="btn btn-link" value="재입력">
	</div>
</div>



</form>
<%@ include file="./footer.jspf" %>
