<%@page import="member.UserDTO"%>
<%@page import="member.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>qna/a_writeForm.jsp</title>
</head>
<body>
<%
String id=(String)session.getAttribute("id");

UserDAO rdao=new UserDAO();
UserDTO rdto=rdao.getUser(id);
int no = rdto.getNo();
%>

<h1>답변</h1>
	<form action="a_writePro.jsp" method="post"> 
		<input type="hidden" name="no" value="<%=no%>">
			<table border="1">
				<tr><td>작성자</td>
				<td><input type="text" name="name" value="<%=id %>" readonly></td></tr>
				<tr><td>내용</td>
				<td><textarea name="qcontent" rows="10" cols="20"></textarea></td></tr>
				<tr><td colspan="2"><input type="submit" value="글쓰기"></td></tr>
			</table>
	</form>
</body>
</html>