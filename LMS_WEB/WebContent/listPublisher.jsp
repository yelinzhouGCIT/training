<%@page import="com.gcit.training.lws.service.AdministratorService"%>
<%@page import="com.gcit.training.lws.domain.Publisher"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	List<Publisher> pList = new AdministratorService().getPublishers();
	%>
<%@include file="include.html"%>
${result}
<table class="table">
	<tr>
		<th>Publisher Id</th>
		<th>Publisher Name</th>
		<th>Publisher Address</th>
		<th>Publisher Phone</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>

	<%
		for (Publisher p : pList) {
	%>
	<tr>
		<td><%=p.getId()%></td>
		<td><%=p.getName()%></td>
		<td><%=p.getAddress() %></td>
		<td><%=p.getPhoneNumber() %></td>
		<td><button class="btn btn-success"
				href="editPublisher.jsp?publisherIdToEdit=<%=p.getId()%>"
				data-target="#myModal1" data-toggle="modal">Edit</button></td>
		<td><button class="btn btn-danger"
				onclick="javascript:location.href='deletePublisher?publisherId=<%=p.getId()%>';">Delete</button></td>
	</tr>
	<%
		}
	%>
</table>