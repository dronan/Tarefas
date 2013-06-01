<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="cabecalho.jsp" />
<a href="novaTarefa"> Adicionar nova terefa </a>

<br><br>
<table>
<tr>
<th>Id</th>
<th>Descricao</th>
<th>Finalizado</th>
<th>Data de finalizacao</th>
<th>Ação</th>
</tr>
<c:forEach items="${tarefas}" var="tarefa">
<tr>
	<td>${tarefa.id}</td>
	<td>${tarefa.descricao}</td>
	<c:if test="${tarefa.finalizado eq false}">
		<td id="tarefa_${tarefa.id}"><a href="#" onclick="finalizaAgora(${tarefa.id})">Finalizar</a></td>
	</c:if>
	<c:if test="${tarefa.finalizado eq true}">
		<td>Finalizado</td>
	</c:if>
	<td id="dataTarefa_${tarefa.id}">
		<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" />
	</td>
	<td><a href="removeTarefa?id=${tarefa.id}">Remover</a> | <a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>