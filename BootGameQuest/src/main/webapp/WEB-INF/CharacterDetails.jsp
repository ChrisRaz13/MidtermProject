<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Character Details</title>
</head>
<body>
<header>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">GameQuest</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/">Home</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="GameList">GameList</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="GameDetails">GameDetails</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> Dropdown </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Action</a></li>
						<li><a class="dropdown-item" href="#">Another action</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">Something else here</a></li>
					</ul></li>
			</ul>
			<form class="d-flex" role="search">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>
		</div>
	</div>
</nav>
</header>
	<div class="container-fluid">
		<div class="row">
			<div class="col-12 text-center">
				<h1>GAME TITLE Characters</h1>
				<h3>GAME CHARACTER NAME</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-2">
				<button type="button" class="btn btn-primary my-2">Character
					List</button>
				<button type="button" class="btn btn-primary my-2">Add New
					Character</button>
				<button type="button" class="btn btn-primary my-2">Updated
					This Character</button>
				<button type="button" class="btn btn-primary my-2">Delete
					This Character</button>
			</div>
			<div class="col-8 text-center">
				<div>INSERT CHARACTER IMAGE HERE</div>
				<div>
					<button type="button" class="btn btn-primary my-2">Previous
						Character</button>
					<button type="button" class="btn btn-primary my-2">Next
						Character</button>
				</div>
			</div>
		</div>	
		<div class="row">
			<div class="col-12 text-center">
				<p>CHARACTER DESCRIPTION </p>		
			</div>		
		</div>
		
		<div class="row">
			<div class="col-4 text-center">IMAGE 1</div>		
			<div class="col-4 text-center">IMAGE 2</div>		
			<div class="col-4 text-center">IMAGE 3</div>			
		</div>

	</div>
















	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>