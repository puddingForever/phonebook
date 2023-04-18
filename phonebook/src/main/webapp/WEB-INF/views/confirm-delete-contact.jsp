<%@ include file="./header.jspf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3 class="text-danger"> 삭제 확인 </h3>
<hr>

<c:if test="${contact==null }">
<h5>유효하지 않은 아이디입니다.</h5>
</c:if>

<c:if test="${contact !=null }">

	<div class="row">
			<div class="col-md-5">
				<img class="img-thumbnail" src="${contact.avatar==''?'./assets/images/default-profile.jpg': contact.avatar}">
			</div>
			
			<div class="col-md-7">
				<table class="table">
					<tr>
						<td>이름</td>
						<td>${contact.name}</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td>${contact.email}</td>
					</tr>
					<tr>
						<td>번호</td>
						<td>${contact.phone}</td>
					</tr>
					<tr>
						<td>아바타</td>
						<td>${contact.avatar}</td>
					</tr>
					<tr>
						<td>주소</td>
						<td>${contact.address}</td>
					</tr>
					<tr>
						<td>국가</td>
						<td>${contact.country}</td>
					</tr>
				</table>
				<p>계정을 탈퇴하면 모든 데이터가 영구적으로 삭제됩니다. </p>
				<p>이 경고사항을 동의하시면 DELETE를 입력해주세요</p>
				<form method="POST">
					<input type="hidden" name="id" value="${contact.id}">
					<div class="form-group row">
						<input type="text" class="col-md-4" name="confirm">
						<button class="btn btn-danger col-md-3">삭제</button>
					</div>
					<h5 class="text-danger">${errMessage}</h5>
				</form>
			</div>
		</div>
</c:if>

<%@ include file="./footer.jspf"%>