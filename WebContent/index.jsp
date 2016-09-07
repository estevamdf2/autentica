<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Inicial JSP</title>
	</head>
<body>
<c:choose>
	<c:when test="${user eq null }">
		<jsp:forward page="acessoNegado.jsp" />
	</c:when>
	<c:otherwise>
	<div class="wrap">
		<div class="navbar navbar-static-top">
			<div class="navbar-inner" id="nav-topo">
				<div class="container">
					<a class="brand" href="#">Meu sistema - JSP</a>
					<ul class="nav pull-right">
						<!-- li class="active"><a href="#">Ajuda<i class="icon help"></i></a></li-->
						<li class="dropdown">
						<form method="get" action="loginServlet" >
							<input name="logout" type="submit" value="Encerrar" style="btn btn-primary" />
						</form>	
						</li>
					</ul>
				</div>
				
			</div>
			<p>Seja bem vindo ${user.nome}</p>
		</div>
	</div>
	
	
	<footer>
		<div class="container">
			<p>Meu sistema, versão 1.0</p>
		</div>
	</footer>
	</c:otherwise>
</c:choose>			
</body>
</html>