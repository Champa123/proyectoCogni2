<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/general/template_top.jsp" />

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<br>
<br>
<br>
	<form:form method="post" modelAttribute="tareaForm" action="guardarnuevatarea.html?id=${ID}">
		<form:input path="id" type="hidden" />
		<div class="form-group">
		<label for="titulo">Titulo</label>
		<form:input class="form-control" path="titulo" type="text" />
		</div>
<!-- 		<div class="form-group"> -->
<!-- 		<label for="descripcion">Descripcion</label> -->
<%-- 		<form:textarea class="form-control" path="descripcion" /> --%>
<!-- 		</div> -->
<!-- 		<div class="form-group"> -->
<!-- 		<label for="idUsuarioPrincipal">Usuario Principal</label> -->
<%-- 		<form:select path="idUsuarioPrincipal" id="select-single" class="js-example-basic-single js-states form-control" items="${usuarios}" itemLabel="nombreCompleto" itemValue="id"> --%>
<%-- 		</form:select> --%>
<!-- 		</div> -->
<!-- 		<div class="form-group"> -->
<!-- 		<label for="idUsuarios">Usuarios </label> -->
<%-- 		<form:select id="select-multiple" class="js-example-basic-multiple js-states form-control" multiple="multiple" path="idUsuarios" items="${usuarios}" itemLabel="nombreCompleto" itemValue="id"> --%>
<%-- 		</form:select> --%>
<!-- 		</div> -->
<!-- 		<br> -->
		<div class="form-group">
		<input type="submit" class="btn btn-success" value="Guardar">
		<a href="guardarnuevatarea.html?id=${ID}" 
					class="btn btn-danger">Volver </a>
		</div>
	</form:form>
	

<c:import url="/general/template_bottom.jsp" />