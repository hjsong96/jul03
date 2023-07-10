package com.poseidon.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poseidon.dao.BoardDAO;

@WebServlet("/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Delete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println(request.getParameter("bno"));
		System.out.println(request.getParameter("k"));
		System.out.println(request.getParameter("no"));
		//데이터베이스에 해당 pk 삭제하기
		//bno 변환하기
		String bno = request.getParameter("bno");
		int converBno = Integer.parseInt(bno);
		BoardDAO dao = new BoardDAO();
		int result = dao.delete(converBno);
		//디스패쳐 = URL 유지하고 화면만 변경합니다. = 값도 보내기
		//리다이렉트 = URL 변경하고 완전히 새로운 페이지로 이동
		//페이지 이동하기
		response.sendRedirect("./board");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
	}

}
