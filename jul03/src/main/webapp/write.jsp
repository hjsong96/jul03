<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
	<link rel= "stylesheet" type="text/css" href="./css/write.css">
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>	
<script type="text/javascript">
//자바스크립트 = ECMAscript ->
function check(){
	let title = document.getElementById("title");
	let textarea = document.getElementById("summernote");
	//alert(title.value);
	if (title.value.length < 5) {
		let div = document.getElementsByClassName("writeDiv")[0];
		div.setAttribute("style","background-color:red");
		
		//alert("제목은 다섯글자 이상이어야 합니다.");
		let span = document.getElementById("span");
		span.innerText = "제목은 다섯 글자 이상이어야 합니다. ";
		//span.innerHTML = "<input value='what?'>";
		span.style.borderBottom = "5px red solid";
		title.style.border = "3px red solid";
		title.focus();
		return false;
	} 
	if (textarea.value.length < 15) {//<p></p>
		alert("본문 내용을 입력하세요.");
		textarea.focus();
		return false;
	} 
}
</script>

</head>
<body>
	<jsp:include page="menu.jsp" />
	<h1>글쓰기</h1>
	<span id="span"></span>
	<div class="writeDiv">
		<form action="./write" method="post">
		<input type="text" id="title" name="title" placeholder="제목을 입력하세요." maxlength="30">
		<textarea id="summernote" name="content" ></textarea> <!-- 뒤쪽으로 넘기기 위해 class id 안씀  -->
		<button onclick="return check()">저장하기</button>
		</form>
		
	</div>
<script type= "text/javascript">
//제이쿼리 JQuery = j
      $('#summernote').summernote({
    	  height: 400
      });
</script>
</body>
</html>