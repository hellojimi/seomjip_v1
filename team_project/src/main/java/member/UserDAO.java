package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO {
		public Connection getConnection() throws Exception{			
			Context init=new InitialContext();
			DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
			Connection con=ds.getConnection();
			return con;
			
		}
		
		public UserDTO userCheck(String id, String pass) {
			// 바구니 주소가 저장되는 변수에 null 초기화
			UserDTO dto=null;
			Connection con =null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				//1,2단계 디비연결 메서드 호출
				con = getConnection();
				// 3단계 SQL구문 만들어서 실행할 준비(select    where id=? and pass=?)
				String sql="select * from users where id=? and pass=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, pass);
				//4단계 SQL구문을 실행(select) => 결과 저장
				rs=pstmt.executeQuery();
				//5단계 결과를 출력, 데이터 담기 (select)
				// if next() 다음행 => 리턴값 데이터 있으면 true => 아이디 비밀번호 일치
//				                 => 세션값 생성 "id",id , main.jsp 이동
//				                         데이터 없으면 false => 아이디 비밀번호 틀림
//				                 => script   "아이디 비밀번호 틀림" 뒤로이동
				if(rs.next()){
					//next() 다음행 => 리턴값 데이터 있으면 true => 아이디 비밀번호 일치
				    // => 세션값 생성 "id",id(페이지 상관없이 값을 유지) , main.jsp 이동
					// dto 바구니 객체생성 => 기억장소 할당
					dto=new UserDTO();
					dto.setNo(rs.getInt("no"));
					dto.setId(rs.getString("id"));
					dto.setPass(rs.getString("pass"));
					dto.setUname(rs.getString("uname"));
					dto.setJoindate(rs.getTimestamp("joindate"));
				}else{
					
				}	
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 예외 상관없이 마무리작업 => 객체생성한 기억장소 해제
				if(rs!=null) try { rs.close();} catch (Exception e2) {}
				if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
				if(con!=null) try { con.close();} catch (Exception e2) {}
			}
			return dto;
		}//userCheck()
		
		public UserDTO getUser(String id) {
			UserDTO dto=null;
			Connection con =null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				//1,2 디비연결 메서드
				con=getConnection();
				
				//3단계 SQL구문 만들어서 실행할 준비(select 조건 where id=?)
				String sql="select * from users where id=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);

				//4단계 SQL구문을 실행(select) => 결과 저장
				rs=pstmt.executeQuery();
				//5단계 결과를 출력, 데이터 담기 (select)
				// next() 다음행 => 리턴값 데이터 있으면 true/ 데이터 없으면 false
				//조건이 true 실행문=> 다음행 데이터 있으면 true =>  열접근 출력
				if(rs.next()){
					//next() 다음행 => 리턴값 데이터 있으면 true/ 아이디 일치
					// 바구니 객체생성 => 기억장소 할당
					dto=new UserDTO();
					// set메서드호출 바구니에 디비에서 가져온 값 저장
					dto.setNo(rs.getInt("no"));
					dto.setUname(rs.getString("uname"));
					dto.setId(rs.getString("id"));
					dto.setPass(rs.getString("pass"));
					dto.setBirth(rs.getTimestamp("birth"));
					dto.setTel(rs.getString("tel"));
					dto.setAddress1(rs.getString("address1"));
					dto.setAddress2(rs.getString("address2"));
					dto.setPostnum(rs.getInt("postnum"));
					dto.setEmail(rs.getString("email"));
					dto.setJoindate(rs.getTimestamp("joindate"));
					dto.setUtype(rs.getInt("utype"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				// 예외 상관없이 마무리작업 => 객체생성한 기억장소 해제
				if(rs!=null) try { rs.close();} catch (Exception e2) {}
				if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
				if(con!=null) try { con.close();} catch (Exception e2) {}
			}
			return dto;
		}//getUser()

}
