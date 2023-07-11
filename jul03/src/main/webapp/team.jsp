<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>팀뽑기</title>
<style type="text/css">
table {
	margin: 0 auto;
	width: 500px;	
	height: 300px;
}

td {
	text-align: center;
}

.names {
	margin: 5px;
	padding: 5px;
	width: calc(100% - 10px);
	height: 90px;
	background-color: gray;
	box-sizing: borer-box;
}

input, button {
	margin: 0 auto;
	padding: 0px;
	width: calc(100% - 10px);
	height: 30px;
	margin: 5px 0px;
}
</style>
<script type="text/javascript">
function check() {
	//alert("팀 만들기를 눌렀습니다.")
	let names = document.getElementsByName("names")[0];
	//alert(names.value.length);
	//alert(names.value.indexOf(",")); //-1
	if (names.value.indexOf(",") == -1) {
		alert("올바른 값을 입력해주세요.")
		names.value="";
		names.focus();
		return false; //action으로 가는 것을 막기 위해 false 넣어준다. 
	} 
}

</script>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<h1>팀뽑기</h1>
	<div class="names">
		<form action="./team" method="post" onsubmit="return check()">
			<input type="text" name="names" 
				value="구관모,기상민,김민성,김수진,김요한,박지윤,배기주,송다원,송재윤,송화진,안희진,유영조,유종휘,이대원,이상화,이승현,이지선,정대규,정준식,최범식,최지은,표해현,차승리,황선우,박채아">
			<button>팀 만들기</button>
		</form>
	</div>

	<hr>
	<%-- ${list } --%>
	<%
	//서블릿에서 보내온 값 잡기
	List<String> list = (List) request.getAttribute("list");
	%>
	출력 결과 :
	<br>
	<%-- <%=list %> --%>
	<%
	if (list != null) {//에러가 나서 미리 처리하고 가겠습니다. 
						//리스트에 뭔가 있을때 실행해라 
	%>
	<table border="1">
		<tr>
		<th>팀명</th>		
		<th>팀장</th>
		<th colspan="5">팀원</th>
		</tr>
		<%
		for (int i = 0; i < list.size(); i++) {
			if (i % 5 == 0) {
		%>
		<tr>
			<td><%=( i/5 + 1 ) %></td>
			<td><%=list.get(i)%></td>
		<%
		} else if (i % 5 != 0) {
		%>
		<td><%=list.get(i) %></td>
		<%
		}//내부 if
	}//for
}//if
		%>
		</tr>
	</table>
	<hr>
	오늘은 7/10:  훈련과목: 웹표준 기술
</body>
</html>