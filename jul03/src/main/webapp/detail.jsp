<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>    
<head>  
<meta charset="UTF-8">  
<title>톺아보기</title>
	<link rel="stylesheet" type="text/css" href="./css/detail.css">
	
</head>     
<body>
	<jsp:include page="menu.jsp"/>
	<h2>톺아보기 > 새로운 소식</h2>
	<div class ="content">
		<div class="title">
			${detail.btitle }
		</div>
		<div class="wirte">
			<div class="bwrite">
			${detail.bwrite }
			</div>
			<div class="blike">
			<img alt="이미지없음" src="./eye.png">
			${detail.blike }
			</div>
		</div>
		<div class="date">
			<img alt="이미지없음" src="./clock.png">
			${detail.bdate }
		</div>
		<div class="bcontent">
			${detail.bcontent }
			<br>
			<%
			for (int i = 0; i < 100; i++) {%>
				<img alt="이미지없음" src="./muzi.png">
				
				
			<% }%>
			
			
			
		</div>	
	
	</div>

</body>
</html>