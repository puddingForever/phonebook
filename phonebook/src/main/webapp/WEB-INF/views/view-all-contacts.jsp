<%@ include file="./header.jspf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>친구목록</h3>
<hr>
<div class="row">
<c:forEach items="${requestScope.contacts}" var="c">
<div class="card col-md-4">
  <img src="${c.avatar==''?'./assets/images/default-profile.jpg':c.avatar}" class="card-img-top" alt="${c.name}">
  <div class="card-body">
    <h5 class="card-title">${c.name}</h5>
    <p class="card-text">${c.email} ${c.phone }</p>
    <a href="./view-contact-details?id=${c.id}" class="btn btn-link">정보 확인</a>
  </div>
</div>

</c:forEach>
</div>
<%@ include file="./footer.jspf"%>