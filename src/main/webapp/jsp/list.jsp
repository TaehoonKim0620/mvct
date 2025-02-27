<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<String> strs = new ArrayList<>();
	strs.add("안녕하세요");
	strs.add("요세하녕안");
	strs.add("하녕안요세");
	out.print("<table border='1'>");

	for (String str : strs) {
		out.print("<tr><td>" + str + "</td></tr>");
	}
	out.print("</table>");
	%>

	<table border="1">
	<%
		for(String str : strs){
		%>
		<tr>
			<td><%=str%></td>
		</tr>
		
		<%
		}
		%>
	</table>
</body>
</html>