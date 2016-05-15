<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="conceptosAvanzados.*" %>
<%@ page import="java.util.ArrayList" %>


<%
	CalcularIndicadores objectoCalculo = new CalcularIndicadores();	
	objectoCalculo.setValoresX(request.getParameter("valoresX"));
	objectoCalculo.setValoresY(request.getParameter("valoresY"));
	objectoCalculo.setXk(Double.parseDouble(request.getParameter("Xk")));
	objectoCalculo.setP(Double.parseDouble(request.getParameter("p")));
	objectoCalculo.calcularIndicadores();
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<title>Taller 7</title>
	</head>
	<body>
		<div class="container">
			<h1 class="text-center">Taller 7</h1>
			<h3 class="text-center">Resultado</h3>
			<p>
				rxy: <%= objectoCalculo.getR() %>
			</p>
			<p>
				r^2: <%= objectoCalculo.getR2() %>
			</p>
			<p>
				Significancia: <%= objectoCalculo.getSignificancia() %>
			</p>
			<p>
				B0: <%= objectoCalculo.getB0() %>
			</p>
			<p>
				B1: <%= objectoCalculo.getB1() %>
			</p>
			<p>
				yk: <%= objectoCalculo.getYk() %>
			</p>
			<p>
				Rango: <%= objectoCalculo.getRango() %>
			</p>
			<p>
				UPI: <%= objectoCalculo.getUPI() %>
			</p>
			<p>
				LPI: <%= objectoCalculo.getLPI() %>
			</p>
			<input type="button" value="Regresar" class="btn btn-default" onclick="history.back()">
		</div>
	</body>
</html>