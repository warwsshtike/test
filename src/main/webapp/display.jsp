<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
	 <style>
		*{
			margin: 0;
			padding: 0;
		}
		body{
			display: flex;
            align-items: center;
            flex-direction: column;
            height: 100%;
            overflow-y:auto;
			font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
		}
		h1{
			width: 100%;
			display:inline-block;
			padding: 10px;
		}
		.topdiv{
			width:100%;
			display:flex;
		}
		.firstdiv{
			margin:20px;
			width:200px;
			min-width:150px;
		}
		.firstdiv a{
			width:100%;
		}
		table{
			margin:0;
		}
		tr , th{
			min-width:150px;
		}
	</style>
</head>
<body>
<jsp:include page="header.html"></jsp:include>
	<h5>All Books</h5>
	<div>
		<a href="addbook">New Book</a>
	</div>

	<table>
		<tr>
			<th> Code</th>
			<th> Name</th>
			<th> Price</th>
			<th> Author </th>
			<th> Action</th>
		</tr>
		<c:forEach var="book" items="${applicationScope.books}">
			<tr>	
			<td>${book.code}</td>
			<td>${book.name}</td>
			<td>${book.price}</td>
			<td>${book.author}</td>	
			<td>
				<a href="edit?code=${book.code}">Update Book</a>
				<a href="delete?code=${book.code}">Delete Book</a>
			</td>
			</tr>
		</c:forEach>
		
	</table>

</body>
</html> 