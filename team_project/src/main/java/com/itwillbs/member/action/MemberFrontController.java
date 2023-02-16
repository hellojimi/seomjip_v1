package com.itwillbs.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFrontController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberFrontController doGet()");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberFrontController doPost()");
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberFrontController doProcess()");
		
		System.out.println("뽑은 가상주소 : " + request.getServletPath());
		String sPath=request.getServletPath();
		
		Action action = null;
		ActionForward forward=null;
		
		if(sPath.equals("/Main.me")) {
			forward = new ActionForward();
			forward.setPath("main/main.jsp");
			forward.setRedirect(false);			
			
		} else if(sPath.equals("/MemberLogin.me")) {
			forward = new ActionForward();
			forward.setPath("member/login.jsp");
			forward.setRedirect(false);	
			
		} else if(sPath.equals("/MemberLoginPro.me")) {
			action = new MemberLoginPro();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(sPath.equals("/MemberMyList.me")) {
			forward = new ActionForward();
			forward.setPath("member/myList.jsp");
			forward.setRedirect(false);
			
		} else if(sPath.equals("/MemberReview.me")) {
			forward = new ActionForward();
			forward.setPath("member/review.jsp");
			forward.setRedirect(false);	
			
		} else if(sPath.equals("/MemberReviewPro.me")) {
			action = new MemberReviewPro();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	   } else if(sPath.equals("/MemberReviewModifyForm.me")) {
			action = new MemberReviewModifyForm();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	   } else if(sPath.equals("/MemberReviewModifyPro.me")) {
			action = new MemberReviewModifyPro();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	   } else if(sPath.equals("/MemberReviewDelete.me")) {
			action = new MemberReviewDelete();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	   } else if(sPath.equals("/MemberFindId.me")) {
			forward = new ActionForward();
			forward.setPath("member/findId.jsp");
			forward.setRedirect(false);	
			
	   } else if(sPath.equals("/MemberFindIdPro.me")) {
			action = new MemberFindIdPro();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	   } else if(sPath.equals("/MemberFindPass.me")) {
			forward = new ActionForward();
			forward.setPath("member/findPass.jsp");
			forward.setRedirect(false);	
			
	   } else if(sPath.equals("/MemberFindPassPro.me")) {
			action = new MemberFindPassPro();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	   } else if(sPath.equals("/MemberLogout.me")) {
			action = new MemberLogout();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	   }else if(sPath.equals("/MemberMyPage_user.me")) {
			forward = new ActionForward();
			forward.setPath("member/myPage_user.jsp");
			forward.setRedirect(false);	
	   }else if(sPath.equals("/MemberMyPage_owner.me")) {
			forward = new ActionForward();
			forward.setPath("member/myPage_owner.jsp");
			forward.setRedirect(false);	
	   }
		
		
		// ----------------------------------------------
		// 주소 이동
		if(forward!=null) {
			if(forward.isRedirect()==true) {
				response.sendRedirect(forward.getPath());
			}else {
				// forward.isRedirect() == false
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response); // request값 들고감
			}
			
		}// if
		
	} // doProcess

} // MemberFrontController
