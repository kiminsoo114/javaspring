<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="container">
		<input type=text size=20 v-model="msg"><!-- 입력 -->
		<h1>{{msg}}</h1><!-- 출력 : 입력과 출력을 동시에 한다하여 양방향 통신이라고 한다 : 검색 -->
	</div>
	<script>
	new Vue({
		el:'.container',
		data:{
			msg:''
		}
	})
	</script>
</body>
</html>