<%@page import="board.ReplyDTO"%>
<%@page import="board.ReplyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

//String id=(String)session.getAttribute("id");
//UserDAO dao = new UserDAO();
//UserDTO dto = dao.getUser(id);
//int no = dto.getNo();
int no = 1; // 임시값

int rno=Integer.parseInt(request.getParameter("rno"));
ReplyDAO rdao=new ReplyDAO();
ReplyDTO rdto=rdao.getReply(rno);


if(rdto.getNo()!=no){
%>
<script>
	alert("본인 댓글만 삭제가능합니다");
	history.back();
</script>
<%
} else{

ReplyDAO dao=new ReplyDAO();
dao.deleteReply(rno);
response.sendRedirect("replyForm.jsp");
}
%>