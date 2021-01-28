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
	
	.num, .hit{
		width:40px;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<td class="num">번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td class="hit">히트</td>
		</tr>	
		
		<c:forEach items="${list }" var="list">
		<tr>
			<td class="num">${list.iId }</td>
			<td>${list.iName }</td>
			<td>
				<c:forEach begin="1" end="${list.iIndent }">[re:]</c:forEach>		
				<a href="content_view?iId=${list.iId }">${list.iTitle }</a>			
			</td>
			<td>${list.iDate }</td>
			<td class="hit">${list.iHit }</td>
		</tr>
		</c:forEach>
		
		<tr>
			<td colspan="5"><a href="write_view">글 작성</a></td>
		</tr>
	</table>
</body>
</html>

