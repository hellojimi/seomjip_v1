<%@page import="member.UserDAO"%>
<%@page import="member.UserDTO"%>
<%@page import="products.ProductDTO"%>
<%@page import="products.ProductDAO"%>

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>products/productList.jsp</title>
</head>
<body>

<!-- 헤더파일들어가는 곳 -->
<jsp:include page="../inc/header.jsp" />

<!--  한페이지에 보여줄 글 개수 -->
<%

String id=(String)session.getAttribute("id");

ArrayList<ProductDTO> productList1 = (ArrayList<ProductDTO>)request.getAttribute("productList1");
int currentPage =(Integer)request.getAttribute("currentPage");
int pageBlock =(Integer)request.getAttribute("pageBlock");
int startPage =(Integer)request.getAttribute("startPage");
int endPage =(Integer)request.getAttribute("endPage");
int pageCount =(Integer)request.getAttribute("pageCount");

%>

<!-- 글쓰기 버튼 부분 -->
<h3>products/productList.jsp</h3>



<table border="0" width="64%">
<tbody><tr align="right">
<% 
UserDAO dao = new UserDAO();
UserDTO udto = dao.getUser(id);
if(id!=null){
	if(udto.getUtype()==2){
%>
<td>
<button type="button" onclick="location.href='ProductWriteForm.pr'">
상품등록</button></td>
</tr>
</tbody></table>
<%
	}
}
%>
<!-- 펜션리스트 부분 -->
<table border="1">
<tr><td>상품번호</td>
	<td>펜션이름</td>
	<td>펜션주소</td>
	<td>상세주소</td>
    <td>가격</td>
    <td>펜션사진</td>
    <td>펜션설명</td>
    </tr>
   
<%
for(int i=0; i<productList1.size(); i++){
	ProductDTO dto=productList1.get(i);
%>
    <tr><td><%=dto.getPno() %></td>
    <td>
    <a href="ProductContent.pr?pno=<%=dto.getPno()%>">
    <%=dto.getPname() %>
    </a></td>
    <td><%=dto.getPaddress() %></td>
    <td><%=dto.getPaddress2() %></td>
    <td><%=dto.getPprice() %></td>
	<td><img src="upload/<%=dto.getPpic1() %>" width="200" height="200"></td>
	<td><%=dto.getPexplain() %></td></tr>

	<%
}
%>    

</table>

<!-- 페이징 부분 -->
<% 

if(startPage > pageBlock){
	%>
<a href="ProductList.pr?pageNum=<%=startPage-pageBlock%>">[10페이지 이전]</a>
	<%
}

for(int i=startPage;i<=endPage;i++){
	%>
	<a href="ProductList.pr?pageNum=<%=i%>"><%=i %></a> 
	<%
}

if(endPage < pageCount){
	%>
<a href="ProductList.pr?pageNum=<%=startPage+pageBlock%>">[10페이지 다음]</a>
	<%
}
%>

<!-- 푸터 들어가는 곳 -->
<%-- <jsp:include page="../inc/footer.jsp" /> --%>

</body>
</html>