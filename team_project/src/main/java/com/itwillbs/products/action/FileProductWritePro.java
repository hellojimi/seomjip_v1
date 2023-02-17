package com.itwillbs.products.action;

import java.sql.Timestamp;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import products.ProductDAO;
import products.ProductDTO;

public class FileProductWritePro implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FileBoardWritePro execute()");
		// 파일 업로드  프로그램 설치
		// http://www.servlets.com/cos/
		// cos.jar 다운 => WEB-INF - lib - cos.jar
		//객체생성
		// 1. request 
		// 2. 웹서버 업로드 폴더 위치 => webapp - upload 폴더 만들기
		String uploadPath=request.getRealPath("/upload");
		System.out.println(uploadPath);
		// 3. 파일크기  10M
		int maxSize=10*1024*1024;
		// 4. 한글처리
// 5. 업로드 파일이름 동일할때 => 파일이름변경(DefaultFileRenamePolicy)
MultipartRequest multi=new MultipartRequest
(request, uploadPath,maxSize,"utf-8",new DefaultFileRenamePolicy());
		
// multi 업로드 정보 => 디비 저장 
// multi name, subject,content 가져와서 변수에 저장
String pname=multi.getParameter("pname");
String paddress= request.getParameter("paddress");
int ppostnum= Integer.parseInt(request.getParameter("ppostnum"));
String paddress2= request.getParameter("paddress2");
String ptel= request.getParameter("ptel");
int checkin= Integer.parseInt(request.getParameter("checkin"));
int checkout= Integer.parseInt(request.getParameter("checkout"));
int pprice= Integer.parseInt(multi.getParameter("pprice"));
int max_men= Integer.parseInt(request.getParameter("max_men"));
int expiration= Integer.parseInt(request.getParameter("expiration"));
Timestamp reser_date=new Timestamp(System.currentTimeMillis());
String ppic1= multi.getParameter("ppic1");
String ppic2= request.getParameter("ppic2");
String ppic3= request.getParameter("ppic3");
String caution= request.getParameter("caution");
String pexplain= multi.getParameter("pexplain");
// 추가 -> 업로드된 파일이름 정보
//String file=multi.getFilesystemName("file");

// 패키지 board  파일이름 BoardDTO 
// 멤버변수  num, name, subject, content, readcount, date
// set get 만들기
// BoardDTO 객체생성
ProductDTO dto=new ProductDTO();
// set메서드 호출해서 값 저장
dto.setPname(pname);
dto.setPaddress(paddress);
dto.setPpostnum(ppostnum);
dto.setPaddress2(paddress2);
dto.setPtel(ptel);
dto.setCheckin(checkin);
dto.setCheckout(checkout);
dto.setPprice(pprice);
dto.setMax_men(max_men);
dto.setExpiration(expiration);
dto.setReser_date(reser_date);
dto.setPpic1(ppic1);
dto.setPpic2(ppic2);
dto.setPpic3(ppic3);
dto.setCaution(caution);
dto.setPexplain(pexplain);
// file 추가
//dto.setFile(file);

// 패키지 board  파일이름 BoardDAO
// 리턴할형없음 insertBoard(BoardDTO dto) 메서드 정의
// BoardDAO 객체생성
ProductDAO dao= new ProductDAO();
// insertBoard(dto) 메서드 호출 => 첫번째 ?  pstmt.setInt(1, 1));
dao.insertProduct(dto);

// 글목록 list.jsp 
//response.sendRedirect("list.jsp");
ActionForward forward=new ActionForward();
forward.setPath("ProductList.bo");
forward.setRedirect(true);
return forward;

	}
}
