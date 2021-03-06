package notice.controller;

import java.io.File;
import java.io.IOException;
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
 * Servlet implementation class UpdateNoticeServlet
 */
@WebServlet(name = "UpdateNotice", urlPatterns = { "/updateNotice" })
public class UpdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//multipart 체크
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "[enctype]확인");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return;
		}
		//파일저장 준비
		//1) 업로드 경로
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root+"upload/notice";
		//2) 파일 크기 지정
		int maxSize = 10*1024*1024;
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "utf-8", new DefaultFileRenamePolicy());
		Notice n = new Notice();
		n.setNoticeNo(Integer.parseInt(mRequest.getParameter("noticeNo")));
		n.setNoticeTitle(mRequest.getParameter("noticeTitle"));
		n.setNoticeContent(mRequest.getParameter("noticeContent"));
		n.setFilename(mRequest.getOriginalFileName("filename"));
		n.setFilepath(mRequest.getFilesystemName("filepath"));
		
		//기존 파일 관리를 위한 값 읽어오기
		String status = mRequest.getParameter("status");
		String oldFilepath = mRequest.getParameter("oldFilepath");
		String oldFilename = mRequest.getParameter("oldFilename");
		if(n.getFilename() == null) { //새로 들어온 파일이 없을 때.
			if(status.equals("stay")) {
				n.setFilename(oldFilename);
				n.setFilepath(oldFilepath);
			}
		}
		int result = new NoticeService().updateNotice(n);
		if(result>0) {
			if(status.equals("delete")) { //새 파일이 들어왔고, 이전 파일 이름이 있을 때.
				File delFile = new File(saveDirectory+"/"+oldFilepath);
				delFile.delete();
			}
			request.setAttribute("msg", "수정 성공 ! ");
		} else {
			request.setAttribute("msg", "수정 실패 ! ");
		}
		request.setAttribute("loc", "/noticeView?noticeNo="+n.getNoticeNo());
		request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
