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
		<form:form action="${song.id}/chorus/new" method="POST" modelAttribute="newChorus">
			<div class="form-group">
				<form:label path="lineA">Line A: </form:label>
				<form:errors path="lineA"/>
				<form:input path="lineA"/>
			</div>
			<div class="form-group">
				<form:label path="lineB">Line B: </form:label>
				<form:errors path="lineB"/>
				<form:input path="lineB"/>
			</div>
			<div class="form-group">
				<form:label path="lineC">Line C: </form:label>
				<form:errors path="lineC"/>
				<form:input path="lineC"/>
			</div>
			<div class="form-group">
				<form:label path="lineD">Line D: </form:label>
				<form:errors path="lineD"/>
				<form:input path="lineD"/>
			</div>
			<form:hidden path="song" value="${song}"/>
			<input type="submit" value="Save" class="btn btn-primary"/>
		</form:form>
	</div>
</body>
</html>