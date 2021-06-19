<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Main Page</title>
</head>
<body>
    <div class="container mt-4">
              
		<h1>All Books</h1>
		<table class="table table-striped table-dark">
		    <thead>
		        <tr>
		            <th>Name</th>
		            <th>Creator</th>
		            <th>Version</th>
		            <th>Action1</th>
		            <th>Action2</th>
		            <th>Action3</th>
		         </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${language}" var="language">
		        <tr>
		            <td><c:out value="${language.name}"/></td>
		            <td><c:out value="${language.creator}"/></td>
		            <td><c:out value="${language.version}"/></td>
		            <td><button class="btn btn-danger"><a href="/delete/${language.id}">Delete</a></button></td>
		            <td><button class="btn btn-danger"><a href="/view/${language.id}">View</a></button></td>
		            <td><button class="btn btn-danger"><a href="/update/${language.id}">Updtate</a></button></td>
		            
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
		<a href="/new">New Book</a>
    </div>
</body>
</html>