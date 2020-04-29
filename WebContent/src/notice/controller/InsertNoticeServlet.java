package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class InsertNoticeServlet
 */
@WebServlet(name = "InsertNotice", urlPatterns = { "/insertNotice" })
public class InsertNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 변수에 저장
		//entype=multipart/form-data 인지 확인.
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "공지사항 타입 오류 [enctype]");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return;
		}
		//파일업로드 준비
		//1) 파일업로드 경로 지정
		String root = getServletContext().getRealPath("/"); //WebContent의 절대 경로를 가져옴
		String saveDirectory = root+"upload/notice";
		System.out.println(saveDirectory);
		//2) 업로드 파일 크기 지정
		int maxSize = 10*1024*1024;
		//request -> MultipartRequest로 바꿔서 데이터를 꺼냄
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		Notice n = new Notice();
		n.setNoticeTitle(mRequest.getParameter("noticeTitle"));
		n.setNoticeWriter(mRequest.getParameter("noticeWriter"));
		n.setNoticeContent(mRequest.getParameter("noticeContent"));
		n.setFilename(mRequest.getOriginalFileName("filename")); //실제 사용자가 올린 파일명
		n.setFilepath(mRequest.getFilesystemName("filename")); //시스템에 저장되는 파일명 (숫자가 붙은 파일명)
		System.out.println("title : "+n.getNoticeTitle());
		System.out.println("writer : "+n.getNoticeWriter());
		System.out.println("content : "+n.getNoticeContent());
		System.out.println("filename : "+n.getFilename());
		System.out.println("filename : "+n.getFilepath());
		
		
		//3. 비즈니스 로직
		int result = new NoticeService().insertNotice(n);
		//4. 결과 처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result > 0) {
			request.setAttribute("msg", "등록 성공");
		} else {
			request.setAttribute("msg", "등록 실패");
		}
		request.setAttribute("loc", "/noticeList?reqPage=1");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
