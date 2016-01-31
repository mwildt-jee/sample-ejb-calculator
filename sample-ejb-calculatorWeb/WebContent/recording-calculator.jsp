<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
<title>Recording Calculator</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">

		<h1>Recording Calculator</h1>
	
		<c:if test="${not empty calculatorResponse}">
			<h2>Ergebnis</h2>
			<p><c:out value="${calculatorResponse}"></c:out></p>
		</c:if>
		
	
		<h2>Former Operations</h2>
		<ul>
			<c:forEach items="${calculator.getProtocol()}"  var="calOp">
				<li>${calOp}</li>
			</c:forEach>
		</ul>
		
		<h2>Add Operation</h2>
		<form method="POST" class="form" action="RecordingCalculatorAction">
			<div class="form-group">
				<label for="value">Value:</label>
				<input type="text" class="form-control" name="value" id=value/>
			</div>
			<button class="btn btn-primary" type="submit" name="submit" value="add" >Add</button>
			<button class="btn btn-primary" type="submit" name="submit" value="multiply" >Multiply</button>
			<button class="btn btn-primary" type="submit" name="submit" value="divide" >Divide</button>	
		</form>

		<h2>Initialize Calculator</h2>
		<form method="POST" action="RecordingCalculatorClearAction">
			<button class="btn btn-primary" type="submit" name="clear" value="0" >Clear</button>	
		</form>

	</div>

</body>
</html>