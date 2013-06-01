<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<c:url var="css" value="resources/css/smoothness"></c:url>
<c:url var="js" value="resources/js"></c:url>

<link type="text/css" href="${css}/jquery-ui-1.10.0.custom.min.css" rel="stylesheet">

<script type="text/javascript" src="${js}/jquery-1.9.0.js"></script>
<script type="text/javascript" src="${js}/jquery-ui-1.10.0.custom.js"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<h1>Lista de tarefas</h1>
<script type="text/javascript">
	function finalizaAgora(id){
		$.post("finalizaTarefa", {'id':id}, function(){
			$("#tarefa_"+id).html("Finalizado");
		});
	}
</script>
<hr>
</body>
</html>