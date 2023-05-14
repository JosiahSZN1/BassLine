<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">
<title>BassLine - Asynchronous development tools for song writing</title>
</head>
<body>
	<div class="container">
		<h1>BassLine</h1>
		<p>Join our ever-evolving community of diverse song writers!</p>
		<div>
			<div>
				<h2>Create an Account</h2>
				<form:form action="/register" method="POST" modelAttribute="">
					<div class="form-group">
						<form:label path="name">Name: </form:label>
						<form:errors path="name"/>
						<form:input path="name"/>
					</div>
					<div class="form-group">
						<form:label path="email">Email: </form:label>
						<form:errors path="email"/>
						<form:input path="email"/>
					</div>
					<div class="form-group">
						<form:label path="password">Password: </form:label>
						<form:errors path="password"/>
						<form:input path="password"/>
					</div>
					<div class="form-group">
						<form:label path="confirm">Confirm Password: </form:label>
						<form:errors path="confirm"/>
						<form:input path="confirm"/>
					</div>
					<input type="submit" value="Sign Up" class="btn btn-primary"/>
				</form:form>
			</div>
			<div> 
				<h2>Sign In</h2>
				<form:form action="/login" method="POST" modelAttribute="">
					<div class="form-group">
						<form:label path="name">Name: </form:label>
						<form:errors path="name"/>
						<form:input path="name"/>
					</div>
					<div class="form-group">
						<form:label path="email">Email: </form:label>
						<form:errors path="email"/>
						<form:input path="email"/>
					</div>
					<div class="form-group">
						<form:label path="password">Password: </form:label>
						<form:errors path="password"/>
						<form:input path="password"/>
					</div>
					<div class="form-group">
						<form:label path="confirm">Confirm Password: </form:label>
						<form:errors path="confirm"/>
						<form:input path="confirm"/>
					</div>
					<input type="submit" value="Submit" class="btn btn-primary"/>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>