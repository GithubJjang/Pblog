<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file = "../layout/header.jsp" %>
<div class="container">


<br/><br/>

<c:if test="${sessionScope.principal.id == board.user.id }">
<div align="right">
	<button type="button" class="btn btn-success" onclick="history.back()">되돌아가기</button>
	<button type="button" class="btn btn-warning" onclick="location.href='/board/update/${board.id}'">수정하기</button>
	<button id="btn-board-delete" class="btn btn-danger">삭제하기</button>
</div>
</c:if>



<div class="card">
  <div class="card-header">
   		게시일 : <span id="createDate">${board.user.createDate }</span><br>
	  	글번호 : <span id="id">${board.id }</span>
	  	글쓴이 : <span id="userId">${board.user.username }</span>
	  	조회수 : <span id="count">${board.count }</span>
  </div>
  
  <div class="card-body">
  	  <div class="form-group">
	    <label for="title">Title: </label>
	    <h5>${board.title }</h5>
	  </div>
  </div>
  
  <div class="card-footer">
  	  <div class="form-group">
		 <label for="content">Content: </label>
		 <div>${board.content }</div>
	  </div>
  </div>
  
  <div class="form-group">
  <label for="usr">댓글쓰기:</label>
  <!-- 로그인을 한 경우와 아닌 경우를 나눈다. -->
  <c:choose>
  	<c:when test="${empty sessionScope}">
  		<input type="text" class="form-control" id="reply" placeholder="로그인 후 댓글을 쓰세요.">	
  	</c:when>
  	<c:otherwise>
  		<input type="text" class="form-control" id="content" placeholder="댓글을 쓰세요.">
  		<input type="hidden" id="boardId" value="${board.id }">
  		<button id="btn-board-reply" class="btn btn-secondary">댓글달기</button>
  	</c:otherwise>
  </c:choose> 
</div>

<ul class="nav nav-tabs">

  <li class="nav-item">
    <a class="nav-link active" href="/board/${board.id }">최신순</a>
  </li>
  
  <li class="nav-item">
    <a class="nav-link active" href="/board/${board.id }/Id">아이디순</a>
  </li>
  
  <c:if test=""></c:if>
  <li class="nav-item">
    <a class="nav-link disabled" href="/board/Test" id="Test">Test</a>
  </li>
  
  <li class="nav-item">
    <a class="nav-link disabled" href="#">Disabled</a>
  </li>
  
</ul>

<c:forEach var="reply" items="${reply.content }">
	
	<div class="card">
	  <div class="card-body">
	    <h4 class="card-title">${reply.user.username }/${reply.user.id } /${reply.createDate }</h4>
	    <p class="card-text">${reply.content }</p>
	  </div>
	</div>
	
</c:forEach>

</div>
</div>
<br/><br/>

<script src="/js/board.js"></script>
<script src="/js/reply.js"></script>
</body>
</html>