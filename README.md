# 제주도 펜션 예약 플랫폼 섬집

### 호스팅 사이트 : http://itwillbs8.cafe24.com/sumzip/Main.me
#### 개발 도구 : Eclipse, Workbench
#### 사용언어 : Java(OpenJDK 11.0.2), MySQL(8.0.17), JavaScript
#### 라이브러리 : jQuery(3.6.4)
#### 웹어플리케이션 도구 : JSP MVC Model2

---

#### 프로젝트 기간 : 1월 30일 ~ 2월 28일
#### 역할 : PPT
#### 담당 기능 : 리뷰 페이지

### 🛠개발 코드💻

#### 리뷰 페이지
* Model
  - 리뷰 DAO [ReviewDAO.java](https://github.com/hellojimi/seomjip_v1/blob/master/team_project/src/main/java/member/ReviewDAO.java)
  - 리뷰 DTO [ReviewDTO.java](https://github.com/hellojimi/seomjip_v1/blob/master/team_project/src/main/java/member/ReviewDTO.java)
  - 마이페이지 리뷰 리스트 [MemberMyList.java](https://github.com/hellojimi/seomjip_v1/blob/master/team_project/src/main/java/com/itwillbs/member/action/MemberMyList.java)
  - 리뷰 작성 [MemberReviewPro.java](https://github.com/hellojimi/seomjip_v1/blob/master/team_project/src/main/java/com/itwillbs/member/action/MemberReviewPro.java)
  - 리뷰 수정 [MemberReviewModifyForm.java](https://github.com/hellojimi/seomjip_v1/blob/master/team_project/src/main/java/com/itwillbs/member/action/MemberReviewModifyForm.java), 
             [MemberReviewModifyPro.java](https://github.com/hellojimi/seomjip_v1/blob/master/team_project/src/main/java/com/itwillbs/member/action/MemberReviewModifyPro.java)
  - 리뷰 삭제 [MemberReviewDelete.java](https://github.com/hellojimi/seomjip_v1/blob/master/team_project/src/main/java/com/itwillbs/member/action/MemberReviewDelete.java)
  - 숙소 리뷰 [ProductContent.java (L33-L37&L56)](https://github.com/hellojimi/seomjip_v1/blob/master/team_project/src/main/java/com/itwillbs/products/action/ProductContent.java#L33-L37), 
             [ProductReviewList.java](https://github.com/hellojimi/seomjip_v1/blob/master/team_project/src/main/java/com/itwillbs/products/action/ProductReviewList.java)

* View
  - 마이페이지 리뷰 리스트 [myList.jsp](https://github.com/hellojimi/seomjip_v1/blob/master/team_project/src/main/webapp/member/myList.jsp)
  - 리뷰 작성 [review.jsp](https://github.com/hellojimi/seomjip_v1/blob/master/team_project/src/main/webapp/member/review.jsp)
  - 리뷰 수정 [reviewModify.jsp](https://github.com/hellojimi/seomjip_v1/blob/master/team_project/src/main/webapp/member/reviewModify.jsp)
  - 리뷰 삭제 [reviewDelete.jsp](https://github.com/hellojimi/seomjip_v1/blob/master/team_project/src/main/webapp/member/reviewDelete.jsp)
  - 숙소 리뷰 [productContent.jsp (L171-L172)](https://github.com/hellojimi/seomjip_v1/blob/master/team_project/src/main/webapp/products/productContent.jsp#L171-L172), 
             [productReviewList.jsp](https://github.com/hellojimi/seomjip_v1/blob/master/team_project/src/main/webapp/products/productReviewList.jsp)
  
* Controller
  - 컨트롤러 [MemberFrontController.java (L53-L96)](https://github.com/hellojimi/seomjip_v1/blob/master/team_project/src/main/java/com/itwillbs/member/action/MemberFrontController.java#L53-L96)
 

