<%@ include file="./header.jspf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>${title != null ? title: 'Contact Form' }</h3>
<hr>

<form method="POST">
<div class ="form-group row" style="margin: 15px 25px 15px 0px;">
	<label for="name" class="col-md-4">이름</label>
	<div class="col-md-4">
		<input type="text" class="form-control" name="name" id="name" value="${contact.name}">
		<div class="text-danger">${errors.name}</div>
	</div>
</div>

<div class ="form-group row" style="margin: 15px 25px 15px 0px;">
	<label for="email" class="col-md-4">이메일</label>
	<div class="col-md-8">
		<input type="email" class="form-control" name="email" id="email" value="${contact.email}">
		<div class="text-danger">${errors.email}</div>
	</div>
</div>

<div class ="form-group row" style="margin: 15px 25px 15px 0px;">
	<label for="phone" class="col-md-4">핸드폰 번호</label>
	<div class="col-md-4">
		<input type="text" class="form-control" name="phone" id="phone" value="${contact.phone}">
		<div class="text-danger">${errors.phone}</div>
	</div>
</div>

<div class ="form-group row" style="margin: 15px 25px 15px 0px;">
	<label for="avatar" class="col-md-4">아바타</label>
	<div class="col-md-8">
		<input type="text" class="form-control" name="avatar" id="avatar" value="${contact.avatar}">
		<div class="text-danger">${errors.avatar}</div>
	</div>
</div>


<div class ="form-group row" style="margin: 15px 25px 15px 0px;">
	<label for="address" class="col-md-4">주소</label>
	<div class="col-md-3">
		<input type="text" class="form-control" name="address" id="address" value="${contact.address}">
		<div class="text-danger">${errors.address}</div>
	</div>
</div>



<div class ="form-group row" style="margin: 15px 25px 15px 0px;">
	<label for="country" class="col-md-4">국가</label>
	<div class="col-md-3">
		<input type="text" class="form-control" name="country" id="country" value="${contact.country}">
		<div class="text-danger">${errors.country}</div>
	</div>
</div>


<div class ="form-group row" style="margin: 15px 25px 15px 0px;">
	<label for="" class="col-md-4"></label>
	<div class="col-md-8">
		<button class="btn btn-primary">등록</button>
		<input type="reset" class="btn btn-link" value="리셋">
	</div>
</div>


</form>

<%@ include file="./footer.jspf"%>