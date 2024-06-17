<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  	 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <style>
        body{
            display: flex;
            align-items: center;
            justify-content: center;
            flex-direction: column;
            height: 100vh;
        }
        h2{
            font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
            font-weight: 600;
        }
        form{
            display: flex;
            flex-direction: column;
            gap: 20px;
            width: 35%;
            padding: 20px;
            min-width: 320px;
        }
        input{
            width: 100%;
            padding: 7px;
            border-radius: 10px;
            border:1px solid gray;
        }
        .box{
        	border:1px solid;
        }
    </style>
<body>
<jsp:include page="header.html"></jsp:include>
	<form action="edit" method="post">
	<h5>Update Book Information</h5>
	  <div style ="color:red">${error}</div>
	  <div class="box">
        <div>
			<label>BookCode</label>
			<label>${book.code}</label>
			<input type="hidden" name="code" value="${book.code }" />	
		</div>
		
		<div>
			<label>BookName</label>
			<input type="text" name="name" value="${book.name}" />	
		</div>
        <div>
			<label>AuthorName</label>
			<input type="text" name="author" value="${book.author}" />	
		</div>
		<div>
            <label>PriceBook</label>
			<input type="number" name="price" value="${book.price}"  />	
		</div>
			<div class="d-flex" style="width:30%; gap:10px;">
			<input type="submit"class="btn btn-info text-white"style="min-width: 120px;" value="Create Book">
			<input type="reset"class="btn btn-secondary text-white" value="Reset">
		</div>
		</div>
    	</form>

</body>
</html>