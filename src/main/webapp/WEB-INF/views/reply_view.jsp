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
	<form action="reply">			
		<input type="hidden" name="iId" value="${reply_view.iId }" />
		<input type="hidden" name="iGroup" value="${reply_view.iGroup }" />
		<input type="hidden" name="iStep" value="${reply_view.iStep }" />
		<input type="hidden" name="iIndent" value="${reply_view.iIndent }" />
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name="iName" value="${reply_view.iName }" /></td>
		</tr>
		
		<tr>
			<td>제목</td>
			<td><input type="text" name="iTitle" value="${reply_view.iTitle }" /></td>
		</tr>
		
		<tr>
			<td>내용</td>
			<td><input type="text" name="iContent" value="${reply_view.iContent }" style="width:300px; height:200px;"/></td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="submit" value="답변 완료" />
				<a href="list">목록 보기</a>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
