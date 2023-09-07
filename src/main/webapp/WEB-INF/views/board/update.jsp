<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="../layout/header.jsp" %>

<div class="container">

<form>
  <div class="form-group">
    <label for="title">Title</label>
    <input type="text" class="form-control" placeholder="${board.title }" id="title">
  </div>
  
<div class="form-group">
  <label for="content">Content</label>
  <textarea class="form-control summernote" rows="5" id="content">${board.content }</textarea>
</div>

	<input type="hidden" id="id" name="id" value="${board.id }">

</form>
	
	<button id="btn-board-update" class="btn btn-warning">수정하기</button>
	<button type="button" class="btn btn-success" onclick="history.back()">되돌아가기</button>
</div>

<div id="summernote"></div>
    <script>
      $('.summernote').summernote({
        tabsize: 2,
        height: 300
      });
    </script>

<script src="/js/board.js">

</script>