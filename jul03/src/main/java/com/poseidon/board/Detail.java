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

@WebServlet("/detail")
public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Detail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//http://localhost:8080/jul03/detail?bno=1
		System.out.println(request.getParameter("bno"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		//DAO 만들고
		BoardDAO dao = new BoardDAO();
		//DAO 속 detail 을 실행시켜서 DTO 받기
		BoardDTO detail = dao.detail(bno);
		
		//System.out.println(detail.getBno());
		//System.out.println(detail.getBtitle());
		//System.out.println(detail.getBwrite());
		
		//디스패쳐로 보내기(detail.jsp)
		RequestDispatcher rd = request.getRequestDispatcher("detail.jsp");
		request.setAttribute("detail", detail);
		rd.forward(request, response);

		
		
	}

}
