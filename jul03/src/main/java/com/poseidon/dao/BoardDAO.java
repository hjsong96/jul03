package com.poseidon.dao;
//게시판의 글읽기, 쓰기, 지우기, 수정하기를 담당하는 DAO

//MVC 패턴

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.poseidon.db.DBConnection;
import com.poseidon.dto.BoardDTO;

public class BoardDAO {
	// 게시판 글 읽어오는 메소드
	public List<BoardDTO> boardList() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql = "SELECT * FROM boardview"; // DB랑 동작하면서 가져올 SQL문
		Connection conn = null; // 저장 정보 저장할 conn
		Statement stmt = null;
		ResultSet rs = null;

		conn = DBConnection.getInstance().getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			// execute = 실행 = 참/거짓
			// executeUpdate = 실행 = 영향받은 행 1, 2, 0
			// executeQuery = select = 결과 반환
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBwrite(rs.getString("bwrite"));
				dto.setBdate(rs.getString("bdate"));
				dto.setBlike(rs.getInt("blike"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;

	}
	//상세보기    
	public BoardDTO detail(int bno) {
		BoardDTO dto = new BoardDTO();
		Connection conn = null;
		String sql = "SELECT * FROM board WHERE bno="+bno;
		Statement stmt = null;
		ResultSet rs = null;
		
		//DB 연결
		conn = DBConnection.getInstance().getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				dto.setBno(rs.getInt("bno"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBcontent(rs.getString("bcontent"));
				dto.setBwrite(rs.getString("bwrite"));
				dto.setBdate(rs.getString("bdate"));
				dto.setBlike(rs.getInt("blike"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}
	//글쓰기
	public int write(BoardDTO dto) {
		int result = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO board(btitle, bcontent, bwrite) VALUES (?,?,?)";
		con = DBConnection.getInstance().getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			//물음표에 값 세팅
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcontent());
			pstmt.setString(3, dto.getBwrite());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt !=null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//java -> 서블릿 -> jsp -> 스트럿츠 -> 
		return result;
	}
}
