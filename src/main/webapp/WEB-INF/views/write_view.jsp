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
	<form action="write">			<!-- /board/modify? -->
	<table>
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
			<td><input type="text" name="iContent" value="${content_view.iContent } " style="width:300px; height:200px;"  /></td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="submit" value="작성 완료" />
				<a href = "list">목록 보기</a>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
