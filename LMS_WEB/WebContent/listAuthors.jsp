<%@page import="com.gcit.training.lws.domain.Author"%>
<%@page import="java.util.List"%>
<%@page import="com.gcit.training.lws.service.AdministratorService"%>
<%
	List<Author> authors = new AdministratorService().getAuthors();
%>
<%@include file="include.html"%>
${result}
<table class="table">
	<tr>
		<th>Author Id</th>
		<th>Author Name</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>

	<%
		for (Author a : authors) {
	%>
	<tr>
		<td><%=a.getAuthorId()%></td>
		<td><%=a.getAuthorName()%></td>
		<td><button class="btn btn-success">Edit</button></td>
		<td><button class="btn btn-danger"
				onclick="javascript:location.href='deleteAuthor?authorId=<%=a.getAuthorId()%>';">Delete</button></td>
	</tr>
	<%
		}
	%>
</table>