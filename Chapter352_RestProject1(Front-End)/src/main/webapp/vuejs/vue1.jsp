<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--
    	VueJS : 자바스크립트 라이브러리
    	-----AugularJS에서 파생 => 누석 (유지보수)
    	
    	AngularJS === Jquery ====== React ========== VueJS
    	---------	---------		-----	         ------ 가상돔, 양방향, 라이브러리가 많지 않다
    	양방향     		라이브러리가 많아서	장점:속도가 빠름	   	
    				무겁다는 단점		가상돔을 이용하기 때문
    				속도가 느리다		단점:단방향 => class
    									|
    							Hooks (function)
    							---------------- 데이터를 읽어서 화면 (View)
	데이터 관리 <==> 데이터를 출력 ==> MVC (Redux, vuex)
	
	=가상돔 (메모리) => 게임으로 따지면 더블 버퍼링 : 소스 코딩이 올라간다 <==> 실제 메모리(브라우저에서 읽어가는 위치)
     														vue라이브러리 위에 고속 카피
     														
     	String Vs StringBuffer
     	
     	=> 가상돔에 올리는 방법
     		-------------- 메소드(함수)를 지원 => mounted()
     	
     	VueJS공부하려면
     	1. 형식 공부
     	<div>
     		<div id="aaa">
     		 	==
     		 	==
     		 	==
     		</div>
     	</div>
     	<script>
     	new Vue({
     		1. 영역(제어하는 영역) 지정 
     		el : 'css형식' => id:#aaa, class:.aaa  => 이것을 container라고 한다.
     		내가 지정한 태그만 등록이 된다
     		data : { => 멤버변수 지정 => 출력내용에 관련된 변수 
     			1) 목록 : [] (자바에서는 List)
     			2) 객체 : {} (자바에서는 VO) ==> {키:값,키:값}
     										---키에 해당하는 것이 '멤버변수' => 자바스크립트의 객체 => 객체를 표현하는 방법을 줄여서 JSON이라 한다.(JavaScriptObject)
     			3) 문자열 : ''
     			4) 정수 : 1 
     		}
     		methods : {
     			사용자 정의 메소드(함수) : 이벤트 처리(버튼을 클릭하면 어떻게 할건지 그런거)
     		},
     		생명주기 함수 
     		1) beforCreate : Vue객체 생성 전
     		2) created : Vue객체 생성 완료
     		3) beforeMount : 가상돔에 HTML을 올리기 전
     		***4) mounted : 가상돔에 올라간 상태 => $(function(){}) window.onload => 스프링으로부터 데이터를 읽어 온다.
     		-----------------: componentDidMount() : react 
     		5) beforeUpdate : 수정전
     		-----------------:componentWillUpdate()
     		***6) updated : 수정완료 => 내용변경
     		-----------------:componentDidUpdate()
     		7) beforeDestroy : 메모리 해제 전
     		8) destroyed : 메모리 해제 완료
     	})
     	2. 디렉티브 공부 : v-
     				   v-if , v-else : 조건문
     				   v-show : 보여줄것인지 안보여줄 것인지
     				   v-for : 제어문 중 반복문 
     				   v-model : 양방향 통신
     	3. 이벤트 처리 방법 공부 
     					v-on : click
     					v-on : change
     					v-on : keyup
     					v-on : keydown
     	4. 사용자 정의 이벤트 (이벤트 버스 => 실시간 채팅)
     					$emit() : 전송할때 쓰는 형식 
     	5. 스프링 연동 (axios) => 요청 => 데이터 받기
     			axios.get('url').then(res=>{})	
     				  ---------  -------------- res가 결과값 =>{처리}
     					요청
     	6. 라우터(화면 이동) => include
     			router('/','이동') 
     --%>			
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div id="app">
		<h1>{{message}}</h1>
	</div>
	<script>
		new Vue({
			el:'#app',
			data:{
				message:'Hello VueJS'
			},
			beforeCreate:function(){
				console.log("beforeCreate Call...");
			},
			created:function(){
				console.log("created Call...");
			},
			beforeMount:function(){
				console.log("beforeMount Call...");
			},
			mounted:function(){
				console.log("mounted Call...");
			},
			beforeUpdate:function(){
				console.log("beforeUpdate Call...");
			},
			updated:function(){
				console.log("updated Call...");
			},
			beforeDestroy:function(){
				console.log("beforeDestroy Call...");
			},
			destoryed:function(){
				console.log("destoryed Call...");
			},
		})
	</script>
</body>
</html>