<%@page import="board.ReplyDAO"%>
<%@page import="board.ReplyDTO"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

request.setCharacterEncoding("utf-8");
int bno = Integer.parseInt(request.getParameter("bno"));
int no = Integer.parseInt(request.getParameter("no"));
String riply = request.getParameter("riply");

// int bno=1;
// int no=1;


Timestamp rdate = new Timestamp(System.currentTimeMillis());

ReplyDTO dto = new ReplyDTO();
dto.setBno(bno);
dto.setNo(no);
dto.setRiply(riply);
dto.setRdate(rdate);


ReplyDAO dao = new ReplyDAO();
dao.insertReply(dto);

%>

<script type="text/javascript">
location.href="BoardCommendUpdatePro.bo?bno=<%=bno%>";
</script>