package com.poseidon.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poseidon.dao.BoardDAO;
import com.poseidon.dto.BoardDTO;

@WebServlet("/write")
public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Write() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// System.out.println("get 으로 들어옵니다.");
		// 글쓰기 화면 불러오기
		// 로그인 여부를 검사하는 if문

		RequestDispatcher rd = request.getRequestDispatcher("write.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		// 실제 글쓰기 => 글저장하기
		// 한글
		request.setCharacterEncoding("UTF-8");

		// 제목에 들어온 글자수 5개 이상이야?
		// 본문 내용 글자 5글자 이상이야?
		if (request.getParameter("title").length() >= 5 && request.getParameter("content").length() >= 5) 
			{
			BoardDTO dto = new BoardDTO();
			dto.setBtitle(request.getParameter("title"));
			//엔터키 처리 합니다. \n -> <br>
			String content = request.getParameter("content");
			content = content.replace("\n", "<br>");
			// \n \n\r
			//replace 모두 바꿔줘요
			//replaceAll 모두 바꿔줘요. + 정규식
			//replaceFirst 하나만 바꿔요.
			dto.setBcontent(content);
			dto.setBwrite("부탁하는 무지");// 나중에 수정해야 합니다.

			// DAO
			BoardDAO dao = new BoardDAO();
			int result = dao.write(dto);

			System.out.println(result);

			// 저장 완료되면 페이지 이동
			response.sendRedirect("./board");

		} else {
			response.sendRedirect("./write");
		}
	}
}
