<%-- <%@page import="org.json.simple.JSONObject"%> --%>
<%-- <%@page import="org.json.simple.JSONArray"%> --%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="board.ReplyDTO"%>
<%@page import="java.util.List"%>
<%@page import="board.ReplyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int bno=1;
ReplyDAO dao=new ReplyDAO();
List<ReplyDTO> replyList=dao.getReplyList(bno);

// JSONArray arr = new JSONArray();
SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd");
for(int i=0;i<replyList.size();i++){
ReplyDTO dto=replyList.get(i);

// JSONObject object= new JSONObject();
// object.put("no", dto.getNo());
// object.put("riply", dto.getRiply());
// object.put("rdate", dateFormat.format(dto.getRdate()));
//  배열한칸에 json 저장
// arr.add(object);
 }

%>

<%-- <%=arr%> --%>