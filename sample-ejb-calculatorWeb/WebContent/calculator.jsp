<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
<title>Calculator</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">

		<h1>Calculator</h1>
		
		<c:if test="${not empty calculatorResponse}">
			<h2>Ergebnis</h2>
			<p><c:out value="${calculatorResponse}"></c:out></p>
		</c:if>
		
		<form method="POST" class="form" action="CalculatorAction">
			<h2>Execute Operation</h2>
			<div class="form-group">
				<label for="value1">Value 1:</label>
				<input type="text" class="form-control" name="value1" id="value1"/>
			</div>
			<div class="form-group">
				<label for="value2">Value 2:</label>
				<input type="text" class="form-control" name="value2" id=value2/>
			</div>
			<button class="btn btn-primary" type="submit" name="submit" value="add" >Add</button>
			<button class="btn btn-primary" type="submit" name="submit" value="multiply" >Multiply</button>
			<button class="btn btn-primary" type="submit" name="submit" value="divide" >Divide</button>	
		</form>
	</div>

</body>
</html>