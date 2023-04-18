<%@include file="./header.jspf" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>회원가입</h3>


<hr>

<form  method ="Post">

<div class ="form-group row" style="margin: 15px 25px 15px 0px;">
	<label for="name" class="col-md-4">닉네임</label>
	<div class="col-md-8">
		<input type="text" class="form-control" name="name" id="name">
		<div class="text-danger">${errors.name}</div>
	</div>
</div>

<div class ="form-group row" style="margin: 15px 25px 15px 0px;">
	<label for="email" class="col-md-4">이메일</label>
	<div class="col-md-8">
		<input type="email" class="form-control" name="email" id="email">
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
	<label for="c_password" class="col-md-4">비밀번호 확인</label>
	<div class="col-md-8">
		<input type="password" class="form-control" name="c_password" id="c_password">
		<div class="text-danger">${errors.cPassword}</div>
	</div>
</div>
<div class ="form-group row" style="margin: 15px 25px 15px 0px;">
	<label for="" class="col-md-4"></label>
	<div class="col-md-8">
		<button class="btn btn-primary">회원가입</button>
		<input type="reset" class="btn btn-link" value="리셋">
	</div>
</div>
</form>

<%@include file="./footer.jspf" %>