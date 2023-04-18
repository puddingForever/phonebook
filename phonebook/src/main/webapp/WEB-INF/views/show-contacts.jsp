<%@ include file="./header.jspf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h3>Contact details for id ${param.id}</h3>
<hr>

<c:choose>
	
	<c:when test="${requestScope.contact==null}">
		<h5 class="text-danger">${param.id}연락처 정보를 찾을 수 없습니다</h5>
	</c:when> 
	
	<c:otherwise>
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
				
				<a href="./edit-and-update-contact?id=${contact.id}" class="btn btn-primary">수정하기</a>
				<a href="./delete-contact?id=${contact.id}" class="btn btn-outline-danger">삭제하기</a>
			</div>
		</div>
	</c:otherwise>
	
</c:choose>

<%@ include file="./footer.jspf"%>