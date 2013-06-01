<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="id" required="true" %>
<%@ attribute name="value" required="true" %>  

<input type="text" id="${id}" name="${id}" value="${value}"/>
<script type="text/javascript">
	$("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
	$("#${value}").datepicker({dateFormat: 'dd/mm/yy'});
</script> 