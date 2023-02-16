package com.itwillbs.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardDTO;

public class BoardUpdatePro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardUpdatePro execute()");
		
		request.setCharacterEncoding("utf-8");

		int bno=Integer.parseInt(request.getParameter("bno"));
		int no=Integer.parseInt(request.getParameter("no"));
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");

		BoardDTO dto=new BoardDTO();

		dto.setBno(bno);
		dto.setNo(no);
		dto.setBtitle(btitle);
		dto.setBcontent(bcontent);

		BoardDAO dao=new BoardDAO();

		dao.updateBoard(dto);
		
		ActionForward forward=new ActionForward();
		forward.setPath("BoardList.bo");
		forward.setRedirect(true);
		return forward;
	}

}
