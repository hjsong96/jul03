<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<script type="text/javascript">
//alert("경고창");
//var let const


alert(my_name);

let my_name = "홍길동"; //호이스팅 문제

//호이스팅
//선언된 변수들이 코드상 실제로 이동하지 않지만 최상위로 올려집니다. 
const num = 100;

// == 값비교
// === 값비교 + 자료형태까지 비교
// 배열
let arr = [0,1,2,3,4,5,6,7,8,9];




</script>
	<link rel= "stylesheet" type="text/css" href="./css/write.css">
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="writeDiv">
	
		<form action="./write" method="post">
		<input type="text" name="title" placeholder="제목을 입력하세요." maxlength="30">
		<textarea name="content"></textarea> <!-- 뒤쪽으로 넘기기 위해 class id 안씀  -->
		<button>저장하기</button>
		</form>
		
	</div>

</body>
</html>