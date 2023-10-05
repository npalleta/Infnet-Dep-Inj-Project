<!-- erroSalaAula.jsp -->
<html>
<head>
	<head>
		<title>Erro - Registro Escolar</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	</head>
</head>
	<body>
		<div class="container">	
	 		<h1 align="center" style="color: #a94442">
	 			<i>
	 				<strong>
	 					Erro de preenchimento - Sala inválida
	 				</strong>
	 			</i>
	 		</h1><br />
			<div class="alert alert-danger" align="center">
				<strong>${exception.message}</strong>
			</div>
			<button type="button" class="btn btn-default" value="Voltar" onclick="history.back()">Voltar</button>
		</div>
	</body>
</html>