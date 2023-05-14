<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form:form action="/song/new" method="POST" modelAttribute="newSong">
			<div class="form-group">
				<form:label path="title">Title: </form:label>
				<form:errors path="title"/>
				<form:input path="title"/>
			</div>
			<input type="submit" value="Save" class="btn btn-primary"/>
		</form:form>
	</div>
</body>
</html>