<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		
		<style>
			input, textarea {width:auto !important;}
		</style>
		
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<title>Taller 7</title>
		
		<script type="text/javascript">
		
			function validar()
			{
				if(valoresX.value != "" && p.value != "" && valoresY.value != "" && Xk.value != "")				
				{
					return true;
				}
				else
				{
					alert("Faltan campos por diliganciar");
					return false;
				}
			}
		
		</script>
		
	</head>
	<body>
		
		<div class="container">
			<h1 class="text-center">Taller 7</h1>
			<form action="calculo.jsp" method="POST" onsubmit="return validar()">
				<p>					
					<label for="male">valores X</label>
					<textarea  id="valoresX" name="valoresX" class="form-control" rows="12" cols="7"></textarea>

				</p>
				<div class="row">
					<div class="col-md-3">
						<label for="male">Valores Y</label>
						<textarea id="valoresY" name="valoresY" class="form-control" rows="12" cols="7"></textarea>
					</div>
					<div class="col-md-9">
						<label>Ejemplo</label>
						<p>15.0</p>
						<p>69.9</p>
						<p>	6.5</p>
						<p>	22.4</p>
						<p>	28.4</p>
						<p>	65.9</p>
						<p>19.4</p>
						<p>	198.7</p>
						<p>	38.8</p>
						<p>	138.2</p>						
					</div>
				</div>
				<p>
					<input type="text" id="p" name="p" class="form-control"  placeholder="P">
				</p>
				<p>
					<input type="text" id="Xk" name="Xk" class="form-control" placeholder="Xk">
				</p>
				<p>
					<input type="submit" value="Calcular" class="btn btn-default">	
				</p>
			</form>
		</div>
		
	</body>
</html>