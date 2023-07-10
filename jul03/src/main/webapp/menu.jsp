<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
body {
	margin: 0;
	padding: 0;
	
}

nav {
	width: 100%;
	height: 50px;
	background-color: black;
	overflow: hidden;
	text-align: center;
}


ul, li {
	margin: 0;
	padding: 0;
	
}

li {
	float: left;
	min-width: 30px; /* 최소 크기 가로 30으로 해라  */
	list-style: none;
	height: 50px;	/* 높이와 맞춘다  */
	line-height: 50px; /* 중간으로 오라  */
	background-color: black;
	color: white;
	margin: 0 30px;
	text-align: center;
}

li:hover {
	font-weight: bolder;
	cursor: pointer;
}

li img {
	vertical-align: middle;
}

#menu {
 	font-size: 10pt;
	width: 1000px;
	height: 100%;
	text-align: center;
	margin: 0 auto;
}

li a{
	text-decoration: none;
	color : white;
}
</style>

	<nav>
		<div id="menu">
			<ul>
				<li onclick="location.href='./'"><img src="./apple.png" alt="HOME"></li>
				<li><a href="./main.jsp">Main</a></li>
				<li onclick="location.href='./team'">팀뽑기</li>
				<li onclick="location.href='./board'">게시판</li>
				<li onclick="location.href='./semantic.jsp'">semantic</li>
				<li>Watch</li>
				<li>Vision</li>
			</ul>
		</div>
	</nav>
	