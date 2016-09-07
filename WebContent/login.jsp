<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
		<title>Autentica - JSP</title>
	</head>
<body>
	
	<div class="wrap">
		<div class="navbar navbar-static-top">
			<div class="navbar-inner" id="nav-topo">
				<div class="container">
					<a class="brand" href="#">Meu sistema</a>
					<ul class="nav pull-right">
						<li class="dropdown">
						</li>
					</ul>
				</div>
			</div>
		</div>
		<form method="post" class="login" id="loginForm" action="loginServlet">
			<fieldset>
				<legend>Login</legend>
				<div class="inputs-block">
					<p>Nome de usuário</p>
					<input id="login" type="text" name="usuario" class="input-large" />
					<p>Senha</p>
					<input  type="password" name="senha"/>
					<br />
					<input type="submit" value="Entrar" style="btn btn-primary" />
				</div>
			</fieldset>
		</form>
	</div>
	<footer>
		<div class="container">
			<p>Meu sistema</p>
		</div>
	</footer>
</body>
</html>