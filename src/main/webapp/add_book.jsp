<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
    </style>
</head>
<body>
    <h2>New Book Info</h2>
	<form action="addbook" method="post">
		<div>
			<label for="code">Book Code</label>
			<input type="text" name="code" id="code" required>
		</div>
		<div>
			<label for="name">Book Name</label>
			<input type="text" name="name" id="name" required>
		</div>
		<div>
			<label for="price">Price</label>
			<input type="text" name="price" id="price" required>
		</div>
		<div>
			<label for="price">Author</label>
			<input type="text" name="author" id="price" required>
		</div>
		<div class="d-flex" style="width:30%; gap:10px;">
			<input type="submit"class="btn btn-info text-white"style="min-width: 120px;" value="Create Book">
			<input type="reset"class="btn btn-secondary text-white" value="Reset">
		</div>
	</form>
</body>
</html>