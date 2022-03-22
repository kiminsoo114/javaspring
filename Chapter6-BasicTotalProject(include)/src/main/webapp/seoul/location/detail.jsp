<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="container">
    <h1 class="text-center">${vo.title } 상세보기</h1>
    <div class="row">
      <table class="table">
        <tr>
          <td class="text-center">
           <img src="${vo.poster }" style="width:800px;height:350px">
          </td>
        </tr>
      </table>
      <table class="table">
        <tr>
          <td colspan="5" class="text-right">
           <a href="/main/seoul/location/list.do"
             class="btn btn-sm btn-danger">목록</a>
          </td>
        </tr>
      </table>
      <h3>주소:${vo.address }</h3>
    </div>
  </div>
</body>
</html>