<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1></h1>
		<p></p>
		<div>
			<div>
				<h2></h2>
				<form:form action="" method="POST" modelAttribute="">
					<div class="form-group">
						<form:label path=""></form:label>
						<form:errors path=""></form:errors>
						<form:input path=""/>
					</div>
					<div class="form-group">
						<form:label path=""></form:label>
						<form:errors path=""/>
						<form:input path=""/>
					</div>
					<div class="form-group">
						<form:label path=""></form:label>
						<form:errors path=""/>
						<form:input path=""/>
					</div>
					<div class="form-group">
						<form:label path=""></form:label>
						<form:errors path=""/>
						<form:input path=""/>
					</div>
					<input type="submit" value="Submit" class="btn btn-primary"/>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>