<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style>
		.table-wrapper {
			width : 1000px;
			margin : 0 auto;
		}
		
	</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>	
	<section class="container">
		<div class="table-wrapper">
			<h1>공지</h1>
			<table class = "table table-bordered">
				<tr>
					<th>제목</th>
					<td>${n.noticeTitle }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${n.noticeWriter }</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<c:if test="${not empty n.filename }">
							<img src="/img/file.png" width="16px">
							<a href="javascript:fileDownload('${n.filename }','${n.filepath}' )">${n.filename }</a>
						</c:if>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${n.contentBr }</td>
				</tr>
				<tr>
					<th style = "text-align : center" colspan="2">
						<c:if test="${not empty sessionScope.member && sessionScope.member.memberId == 'admin'}">
							<a class="btn btn-outline-primary btn sm" href="/updateNoticeFrm?noticeNo=${n.noticeNo }">수정하기</a>
							<a class="btn btn-outline-primary btn sm" href="javascript:void(0);" onclick="deleteNotice('${n.noticeNo }');">삭제하기</a>
						</c:if>
							<a class="btn btn-outline-primary btn sm" href="/noticeList?reqPage=1">목록으로</a>				
					</th>
				</tr>
			</table>
		</div>
	</section>
	<script>
		function fileDownload(filename,filepath) {
			var newFilename = encodeURIComponent(filename);
			var newFilepath = encodeURIComponent(filepath);
			location.href = "/noticeFileDownload?filename="+newFilename+"&filepath="+newFilepath;
		}
		
		function deleteNotice(noticeNo) {
			if(confirm("Really ?")) {
				location.href = "/deleteNotice?noticeNo="+noticeNo;
			}
		}
	</script>
</body>
</html>