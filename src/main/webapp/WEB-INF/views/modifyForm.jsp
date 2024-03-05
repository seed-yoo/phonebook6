<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	
	<h1>전화번호부</h1>

	<h2>수정폼</h2>

	<p>
		전화번호를 등록하려면<br> 아래 항목을 기입하고 "수정" 버튼을 클릭하세요
	</p>
	
	

	<form action="/phonebook6/modify" method="get">
		
		<div>
			<input type="text" name="personId" value="${ requestScope.pVo.personId }">
		</div>
		<div>
			<label>이름(name)</label> <input type="text" name="name" value="${ requestScope.pVo.name }">
		</div>

		<div>
			<label>핸드폰(hp)</label> <input type="text" name="hp" value="${ requestScope.pVo.hp }">
		</div>

		<div>
			<label>회사(company)</label> <input type="text" name="company" value="${ requestScope.pVo.company }">
		</div>

		<button type="submit">수정</button>
	</form>

	<br>
	<br>
	<a href="/phonebook6/list">리스트페이지로 이동</a>

</body>
</html>