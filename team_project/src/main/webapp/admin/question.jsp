<%@page import="member.UserDTO"%>
<%@page import="member.UserDAO"%>
<%@page import="qna.QnaDTO"%>
<%@page import="qna.QnaDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin/question.jsp</title>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/header.jsp" />
<!-- 헤더들어가는 곳 -->
<%

// request에 저장된 qno 파라미터값 가져오기
// int qno=Integer.parseInt(request.getParameter("qno"));
// // QnaDAO 객체생성
// QnaDAO qdao=new QnaDAO();
// qdao.qCount(qno);

// // QnaDTO dto = dao.getQna(no) 메서드 호출
// QnaDTO qdto = qdao.getQna(qno);  
// // 세션값 가져오기
String id=(String)session.getAttribute("id");
// int no=qdto.getNo();
// UserDAO udao = new UserDAO();
// UserDTO udto = udao.getUserNo(no);
// int status=qdto.getQstatus();
QnaDTO qdto = (QnaDTO)request.getAttribute("qdto");
UserDTO udto = (UserDTO)request.getAttribute("udto");
int qno=(Integer)request.getAttribute("qno");
%>
<h4>question</h4>
<table border="1">
	<tr><td>글번호</td><td><%=qdto.getQno() %></td></tr>
	<tr><td>작성자</td><td><%=udto.getId() %></td></tr>
	<tr><td>글쓴날짜</td><td><%=qdto.getQdate() %></td></tr> 
	<tr><td>조회수</td><td><%=qdto.getQcount() %></td></tr>
	<tr><td>글제목</td><td><%=qdto.getQtitle() %></td></tr>
	<tr><td>글내용</td><td><%=qdto.getQcontent() %></td></tr>
	<tr><td colspan="2">
	
	<input type="button" value="글목록" 
	onclick="location.href='AdminQnaList.ad'">
	
	<!-- 답변이 있을때만 답변확인버튼 보이게 -->
	<%
	if(qdto.getQstatus()==0){
		if(id.equals(udto.getId())){
	%>
	<input type="button" value="답변확인" 
	onclick="location.href='AdminQnaAnswer.ad?qno=<%=qdto.getQno() %>'">
	<%
		}
	}
	%>
	<input type="button" value="답변쓰기" 
	onclick="location.href='AdminAnswerWriteForm.ad?qno=<%=qdto.getQno() %>'">
	</td></tr>
</table>
</body>
</html>