<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">							
<title>Home</title>								
<style>
	table, tr, td{
		border:1px solid black;
		border-collapse:collapse;
		border-width:medium;
	}
	
	table{	
		width:500px;
	}
</style>
</head>
<body>
	<form action="modify">			<!-- /board/modify? -->
	<table>
		<tr>
			<td>글번호</td>
			<td>${content_view.iId }</td>
		</tr>
		
		<tr>
			<td>조회수</td>
			<td>${content_view.iHit }</td>
		</tr>
		
		<tr>
			<td>이름</td>
			<td><input type="text" name="iName" value="${content_view.iName }" /></td>
		</tr>
		
		<tr>
			<td>제목</td>
			<td><input type="text" name="iTitle" value="${content_view.iTitle }" /></td>
		</tr>
		
		<tr>
			<td>내용</td>
			<td><input type="text" name="iContent" value="${content_view.iContent }" /></td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="submit" value="수정" />
				<a href="list">목록 보기</a>
				<a href="delete?iId=${content_view.iId }">삭제</a>				<!-- 맵핑 확실하지 않음 : 여기서 board를 또 붙히면 board/board/list가 됨 -->
				<a href="reply_view?iId=${content_view.iId }">답변</a>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
