package com.mall4.domain;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;

// DAO :데이터베이스의 데이터에 접근하기 위해 생성하는 객체이다.
public class QnADAO {
	
	//변수 선언 
	//DataSource : DB연결정보를 저장, Connection을 생성, Connection Pool에 등록하고 관리 
	private DataSource dataFactory;
	Connection conn; 
	PreparedStatement pstmt;
	
	//생성자 
	public QnADAO() {
		
		try {
			//???(jdbc 연결할때 필요한 코드?)0
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			System.out.println("QnADAO 생성자 오류");
			e.printStackTrace();
		} 
		
	}
	
	
	//selectAllArticles() 메서드 (게시물 조회 메서드)
	public List<QnAVO> selectAllArticles(){
		//객체를 만들어서 변수에 전달 
		List<QnAVO> QnAList = new ArrayList();
		try {
			//데이터베이스 연결 시작 
			conn = dataFactory.getConnection();
			//쿼리문 작성
			String query = "SELECT b_num, b_item, b_title,"
					+ "b_writer, b_regdate from QnA_board  "
				    + "order siblings by b_num desc";
			//쿼리문 확인
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			//쿼리를 실행한 것을 ResultSet에 담는다. 
			ResultSet rs = pstmt.executeQuery();
			//가져온 값(결과)을 변수에 담기 -> QnAService에 전달 ?
			while(rs.next()) {
			
			int b_num = rs.getInt("b_num");
			String b_item = rs.getString("b_item");
			String b_title = rs.getString("b_title");
			String b_writer = rs.getString("b_writer");
			Date b_regdate = rs.getDate("b_regdate");
			//글 정보를 QnAVO객체의 속성에 저장한다. 		
			QnAVO qna = new QnAVO(); 
			
			qna.setB_num(b_num);
			qna.setB_item(b_item);
			qna.setB_title(b_title);
			qna.setB_writer(b_writer);
			qna.setB_regdate(b_regdate);
			QnAList.add(qna);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("selectAllArticles() 메서드 오류!!");
			e.printStackTrace();
		}
		
		return QnAList;
		
	}
	}
