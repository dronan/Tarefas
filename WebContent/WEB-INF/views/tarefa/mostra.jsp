<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="tarefas" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="cabecalho.jsp"/>

<h3>Alterar tarefa - ${tarefa.id }</h3>
<form action="alteraTarefa" method="post">
<input type="hidden" name="id" value="${tarefa.id}" />
Descri��o:<br />
<textarea name="descricao" cols="100" rows="5">${tarefa.descricao}</textarea>
<br />
Finalizado? <input type="checkbox" name="finalizado" value="true" ${tarefa.finalizado? 'checked' : '' } /> <br/>

Data de Finalizacao: <br />
<!-- 
<tarefas:campoData id="dataFinalizacao" value="" />
 -->
<input type="text" name="dataFinalizacao" value="<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" />" />

<br />
<input type="submit" value="alterar" />
</form>
</body>
</html>