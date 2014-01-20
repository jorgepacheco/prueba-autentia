<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>Spring MVC - Ajax</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <style>
    	body { background-color: #eee; font: helvetica; }
    	#container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; box-shadow: 5px; }
    	.green { font-weight: bold; color: green; }
    	.message { margin-bottom: 10px; }
    	label { width:70px; display:inline-block;}
    	.hide { display: none; }
    	.error { color: red; font-size: 0.8em; }
    </style>
  </head>
  <body>
	
	<div id="container">
	
		<h1>Pruebas</h1>
		<p>Llamar a los servicios rest
		</p>
		
		<h2>Listado Profesores</h2>
		<input type="submit" id="randomPerson" value="Get Profesor" /><br/><br/>
		<div id="personResponse"> </div>
		
		<hr/>
	<hr/>
		
		<h2>Submit new Person</h2>
		<form id="newPersonForm">
			<label for="nameInput">Name: </label>
			<input type="text" name="titulo" id="titulo" />
			<br/>
			
			<label for="ageInput">Id: </label>
			<input type="text" name="id" id="id" />
			<br/>
			
			<label for="ageInput">Horas: </label>
			<input type="text" name="horas" id="horas" />
			<br/>
			
			<label for="ageInput">Nivel: </label>
			<input type="text" name="nivel" id="nivel" />
			<br/>
			<input type="submit" value="Save Person" /><br/><br/>
			<div id="personFormResponse" class="green"> </div>
		</form>
		
<!-- 		<hr/> -->
		
<!-- 		<h2>Submit new Person</h2> -->
<%-- 		<form id="newPersonForm"> --%>
<!-- 			<label for="nameInput">Name: </label> -->
<!-- 			<input type="text" name="name" id="nameInput" /> -->
<!-- 			<br/> -->
			
<!-- 			<label for="ageInput">Age: </label> -->
<!-- 			<input type="text" name="age" id="ageInput" /> -->
<!-- 			<br/> -->
<!-- 			<input type="submit" value="Save Person" /><br/><br/> -->
<!-- 			<div id="personFormResponse" class="green"> </div> -->
<%-- 		</form> --%>
	</div>
	
	
	<script type="text/javascript">
	
		$(document).ready(function() {
			
			$.postJSON = function(url, data, callback) {
			    return $.ajax({
			    'type': 'POST',
			    'url': url,
			    'contentType': 'application/json',
			    'data': data,
			    'dataType': 'json',
			    'success': callback
			    });
			};
			
			// Random Person AJAX Request
			$('#randomPerson').click(function() {
				$.getJSON('${pageContext.request.contextPath}/api/curso?page=1', function(resultado) {
					
					var paginacion = resultado.pagination;
					console.log(paginacion);
					var cursos = resultado.cursos;
					$.each(cursos,function(clave,valor) {
						  console.log('Clave es ' + clave + ' y valor es: ' + valor.titulo);
						  var etiqueta= '<p>' + valor.titulo + '</p>';
						  $('#personResponse').append(etiqueta);
						});
					
				});
			});
			
			$('#newPersonForm').submit(function(e) {
				// will pass the form date using the jQuery serialize function
				console.log($(this).serialize());
				var kk1 = '{"titulo":"Johnny","id":32, "activo":true, "horas": 23, "profesor": {"id": 4, "nombre": "Alex"}, "nivel":"Basico"}';
				
				var kk = '{"activo":true,"profesor":{"id":{"nombre":"Alex","id":1},"nombre":null},"titulo":"zxz","nivel":"Basico",}';
				console.log(kk);
//  				$.postJSON('${pageContext.request.contextPath}/api/curso', kk1, function(response) {
//  					$('#personFormResponse').text(response);
//  				});

 				$.post('${pageContext.request.contextPath}/api/curso', kk1, function(response) {
 					$('#personFormResponse').text(response);
 				},'json');
				
				e.preventDefault(); // prevent actual form submit and page reload
			});
			

			
		});
		
		
		
		


		
	
	</script>
	
  </body>
</html>