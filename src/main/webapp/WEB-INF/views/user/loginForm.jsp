<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ include file = "../layout/header.jsp" %>
<body>
  <div class="container">
	<form>
	  <div class="form-group">
	    <label for="username">ID:</label>
	    <input type="text" class="form-control" placeholder="Enter username" id="username">
	  </div>
	  
	  
	  <div class="form-group">
	    <label for="password">Password:</label>
	    <input type="password" class="form-control" placeholder="Enter password" id="password">
	  </div>  
	</form>
	
	<button id="btn-login" class="btn btn-primary">로그인</button>
	
  </div>
</body>
<script src="/js/user.js"></script>
</html>