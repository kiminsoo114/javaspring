<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['리뷰', '리뷰횟수'],
          ['맛있다',     <c:out value="${vo.good}"/>],
          ['괜찮다',     <c:out value="${vo.soso}"/>],
          ['별로',  <c:out value="${vo.bad}"/>]
        ]);

        var options = {
          title: '리뷰',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
    </script>
</head>
<body>
<div class="wrapper row2">
  <div id="breadcrumb" class="clear"> 
    <!-- ################################################################################################ -->
    <ul>
      <li><a href="#">Home</a></li>
      <li><a href="#">맛집</a></li>
      <li><a href="#">맛집 리스트</a></li>
      <li><a href="#">맛집 상세보기</a></li>
    </ul>
    <!-- ################################################################################################ -->
  </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body -->
    <!-- ################################################################################################ -->
    <div class="content three_quarter first"> 
      <!-- ################################################################################################ -->
      <div class="scrollable">
       <table>
        <tr>
          <c:forTokens items="${vo.poster }" delims="^" var="img">
           <td align="center">
            <img src="${img }" style="width: 100%">
           </td>
          </c:forTokens>
        </tr>
       </table>
      </div>
      <div class="scrollable">
        <table>
          <tbody>
            <tr>
              <td colspan="2">
               <h3>${vo.name }&nbsp;<span style="color:orange">${vo.score }</span></h3>
              </td>
            </tr>
            <tr>
              <th width=20%>주소</th>
              <td width=80%>${addr1 }<br>
                <span style="color:#999">${addr2 }</span>
              </td>
            </tr>
            <tr>
              <th width=20%>전화</th>
              <td width=80%>${vo.tel}</td>
            </tr>
            <tr>
              <th width=20%>음식종류</th>
              <td width=80%>${vo.type }</td>
            </tr>
            <tr>
              <th width=20%>가격대</th>
              <td width=80%>${vo.price }</td>
            </tr>
            <c:if test="${vo.parking!='no' }">
	            <tr>
	              <th width=20%>주차</th>
	              <td width=80%>${vo.parking }</td>
	            </tr>
            </c:if>
            <c:if test="${vo.time!='no' }">
	            <tr>
	              <th width=20%>영업시간</th>
	              <td width=80%>${vo.time }</td>
	            </tr>
            </c:if>
            <c:if test="${vo.menu!='no' }">
	            <tr>
	              <th width=20%>메뉴</th>
	              <td width=80%>
	               <ul>
	                <c:forTokens items="${vo.menu }" delims="원" var="m">
	                  <li>${m }원</li>
	                </c:forTokens>
	               </ul>
	              </td>
	            </tr>
            </c:if>
            <tr>
              <td colspan="2" align="right">
               <a href="javascript:history.back()" class="btn">목록</a>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <div id="comments">
        <div id="piechart_3d" style="width: 700px; height: 500px;"></div>
      </div>
      <!-- ################################################################################################ -->
    </div>
    <!-- ################################################################################################ -->
    <!-- ################################################################################################ -->
    <div class="sidebar one_quarter"> 
      <!-- ################################################################################################ -->
     
	</div>
      <div class="sdb_holder">
        <%-- 잠시 보류 --%>
      </div>
      <!-- ################################################################################################ -->
    </div>
    <!-- ################################################################################################ -->
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>
</body>
</html>