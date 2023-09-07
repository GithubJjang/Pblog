<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="layout/header.jsp" %>
<!-- 현재경로 views/layout/ -->
<body>
	<!-- Board.Content를 Iterator를 한다. -->
	<c:forEach var="board" items="${boards.content}">
		<div class="card">
			<div class="card-body">
				 <h4 class="card-title"><a href="/board/${board.id }" class="card-link">${board.title }</a></h4>
				 <p class="card-text">작성자 &nbsp;${board.user.username }</p>
				 <p class="card-text">${board.content }</p>
				 <p class="card-text">조회수 ${board.count }</p>		 
			</div>
		</div>
	</c:forEach>
	

	<ul class="pagination">
	
	 <c:choose>
	 	<c:when test="${boards.first == true }">
	 		<li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
	 	</c:when>
	 	<c:otherwise>
	 		<li class="page-item "><a class="page-link" href="/?page=${boards.number - (boards.number % boards.size + 1) }">Previous</a></li>
	 	</c:otherwise>
	 </c:choose>
		
	  <c:forEach begin="${boards.number - (boards.number%boards.size) }" end="${boards.number - (boards.number%boards.size) + boards.size - 1  }" var="num">
	  	<li class="page-item"><a class="page-link" href="/?page=${num }">${num+1 }</a></li>
	  </c:forEach>
	  
	 <c:choose>
	 	<c:when test="${boards.last == true }">
	 		<li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
	 	</c:when>
	 	<c:otherwise>
	 		<li class="page-item"><a class="page-link" href="/?page=${boards.size - (boards.number%boards.size) + boards.number }">Next</a></li>
	 	</c:otherwise>
	 </c:choose>
	</ul>
	
</body>
</html>