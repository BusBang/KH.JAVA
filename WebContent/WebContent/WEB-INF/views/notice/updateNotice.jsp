<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style>
		#updateFrm {
			width : 1000px;
			margin : 0 auto;
		}
	</style>
	<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
	
</head>
<body>
	<script>
		$(function() {
			$("#fileDelBtn").click(function() {
				$(".delFile").hide();
				$("#file").show();
				$("input[name=status]").val('delete');
				
			});
			
		})
	</script>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<section class="container">
		<form action="/updateNotice" method="post" enctype="multipart/form-data" id="updateFrm">
			<h1>공지사항수정</h1>
			<input type="hidden" name="noticeNo" value="${n.noticeNo }">
			<table class = "table table-bordered">
				<tr>
					<th>제목</th>
					<td>
						<input type="text" class="form-control" name="noticeTitle" value="${n.noticeTitle }">
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${n.noticeWriter }</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>${n.noticeDate }</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<input type="hidden" name="status" value="stay">
						<c:if test="${not empty n.filename }"> <!-- 파일첨부돼있을때, 삭제 버튼을 누르면 첨부 파일이 사라져보이게 delFile 클래스를 이용 -->
							<img src="/img/file.png" width="16px" class="delFile">							
							<input type="file" name = "filename" id="file" style="display:none;"> <!-- 첨부파일이 생기면 생기게할 것. -->
							<span class="delFile">${n.filename }</span> <!-- 파일 이름은 String 타입이 아니기 때문에 변경 가능하게 span으로 만듦 -->
							<button type="button" id="fileDelBtn" class="btn btn-primary btn-sm delFile">파일삭제</button> 
							<input type="hidden" name="oldFilename"  value="${n.filename }">
							<input type="hidden" name="oldFilepath"  value="${n.filepath }">
						</c:if>
						<c:if test="${empty n.filename }">
							<input type="file" name="filename">
						</c:if>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="noticeContent" rows="3" style="width:100%;">${n.noticeContent }</textarea>
					</td>
				</tr>
				<tr>
					<th colspan="2" style="text-align : center">
						<button type="submit" class="btn btn-outline-primary">수정완료</button>
					</th>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>