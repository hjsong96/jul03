<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>    
<head>  
<meta charset="UTF-8">  
<title>톺아보기</title>
	<link rel="stylesheet" type="text/css" href="./css/detail.css">
<script type="text/javascript">
	function update(num) {
		if(confirm("수정하시겠습니까?")) {
			//alert("확인을 눌렀습니다.")
			//location.href="./update?bno=${detail.bno }";
			location.href="./update?bno="+num;
		} 
	}
	function dele(num) {
		if (confirm(num +"번 글을 삭제하시겠습니까?")) {
			location.href="./delete?bno=${detail.bno }&k=&no="+num;
		}
	}
</script>

</head>     
<body>
	<jsp:include page="menu.jsp"/>
	<h2>톺아보기 > 새로운 소식</h2>
	<div class ="content">
		<div class="title">
			${detail.btitle }
			<img alt= "수정" src="./img/update.png" title="수정하기" onclick="update(${detail.bno })">
			<img alt= "삭제" src="./img/delete.png" title="삭제하기" onclick="dele(${detail.bno })">
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

			
			
			
		</div>	
	
	</div>

</body>
</html>