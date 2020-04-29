package notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;
import notice.model.vo.NoticePageData;

public class NoticeService {

	public NoticePageData selectList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		//한 페이지 당 게시물 수를 선언 함
		int numPerPage = 10; //10개
		int totalCount = new NoticeDao().totalCount(conn); //총 게시물 수 갖고오기
		//페이지 갯수 만들기. 총 페이지 연산
		int totalPage = 0;
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage;
		} else {
			totalPage = totalCount/numPerPage+1;
		}
		//1->1
		//2->11
		//3->21
		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage*numPerPage;
		//해당페이지 게시물들 조회
		ArrayList<Notice> list = new NoticeDao().selectList(conn,start,end);
		
		//페이지 내비게이션 작성 시작
		String pageNavi = "";
		//페이지 내비게이션 길이
		int pageNaviSize = 5;
		//1 2 3 4 5 -> 1 2 3 4 5
		//6 7 8 9 10 -> 6 7 8 9 10
		//페이지 넘버
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;
		
		//이전 버튼
		if(pageNo != 1) {
			pageNavi += "<a class='btn' href='/noticeList?reqPage="+(pageNo-pageNaviSize)+"'>이전</a>";
		}
		//중간 버튼
		for (int i=0; i<pageNaviSize; i++) {
			if(reqPage == pageNo) {
				pageNavi += "<span class='selectPage'>"+pageNo+"</span>";
			} else {
				pageNavi += "<a class='btn' href='/noticeList?reqPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
			//페이지 수가 전체 페이지 수보다 클 경우, break를 걸어준다.
			if(pageNo>totalPage) {
				break;
			}
		}
		//다음 버튼 (for문에서 ++을 하기 때문에 pageNo만 넣으면 된다.)
		if(pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='/noticeList?reqPage="+(pageNo)+"'>다음</a>";			
		}
		NoticePageData pd = new NoticePageData(list,pageNavi);
		
		
		
		JDBCTemplate.close(conn);
		return pd;
	}

	public int insertNotice(Notice n) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().insertNotice(conn, n);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Notice selectOneNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		Notice n = new NoticeDao().selectOneNotice(conn, noticeNo);
		JDBCTemplate.close(conn);
		return n;
	}

	public int deleteNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().deleteNotice(conn, noticeNo);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateNotice(Notice n) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().updateNotice(conn, n);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
