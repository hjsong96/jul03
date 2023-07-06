<%@page import="com.poseidon.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿을 활용한 보드 열기</title>
<style type="text/css">
#tableDiv {
	margin: 0 auto;
	width: 100%;
	height: 500px;
	padding: 10px;
	box-sizing: border-box;
}

table {
	width: 100%;
	height: 100%;
	border-collapse: collapse; /* 줄이 이어진 것처럼 만들어줌 */
}


th {
	background-color: #BA68C8;
	font-weight: bolder;
}

td {
	border-bottom: 1px solid white;
	text-align: center;
}

.td1 {
	width: 10%;
}

.td2 {
	width: 20%;
}

.title {
	text-align: left;
}

.title a{
	text-decoration: none; /* 글자 밑줄 없애기  */
	color: black; /* 글자 검은색 변경  */

}

tr:hover, tr:hover a{
	background-color: #E1BEE7;
	color: white;
	font-weight: bolder;
}
</style>
</head>
<body>
	<%
	//EL태그 말고 자바로 받아보겠습니다.
	String sdata = (String) request.getAttribute("Sdata");
	List<BoardDTO> list = (List<BoardDTO>) request.getAttribute("list");
	%>
	<jsp:include page="menu.jsp" />
	<h1>board</h1>
	${Sdata } = EL태그
	<br> 변환한 값 :
	<%=sdata%>
	<hr>
	<div id="tableDiv">
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>조회수</th>
				<th>쓴날짜</th>
			</tr>
			<%
			for (int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<td class="td1"><%=list.get(i).getBno() %></td>
				<td class="title">
					<a href="./detail?bno=<%=list.get(i).getBno() %>">
						<%=list.get(i).getBtitle() %>
					</a>
				</td>
				<td class="td2"><%=list.get(i).getBwrite() %></td>
				<td class="td1"><%=list.get(i).getBlike() %></td>
				<td class="td2"><%=list.get(i).getBdate() %></td>
			</tr>
				<%
				}
				%>
		</table>
	</div>
	<!-- 글쓰기 버튼 : 로그인 한 사용자만 쓸 수 있어요 -->
	<button onclick="location.href='./write'">글쓰기</button>

</body>
</html>