<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="../layout/header.jsp" %>

<body>

<form action="/action_page.php">

  <div class="form-group">
    <label for="username">Username:</label>
    <input type="text" class="form-control" placeholder="Enter Usernmae" id="username">
  </div>
  
  <div class="form-group">
    <label for="password">Password:</label>
    <input type="password" class="form-control" placeholder="Enter password" id="password">
  </div>
  
  <div class="form-group">
    <label for="email">Email:</label>
    <input type="email" class="form-control" placeholder="Enter password" id="email">
  </div>
</form>
  <button id="btn-save" class="btn btn-primary">회원가입</button>

</body>
<script src="/js/user.js"></script>

</html>