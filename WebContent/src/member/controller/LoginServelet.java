package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

@WebServlet(name = "Login", urlPatterns = { "/login" })
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		//2. 변수에 값 저장
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		//3. 비즈니스 로직
		Member m = new MemberService().selectOneMember(memberId, memberPw);
		//4. 결과 처리
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(m != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", m);
			request.setAttribute("msg", "로그인 성공");
			request.setAttribute("loc", "/");
		}else {
			request.setAttribute("msg", "로그인 실패. 아이디 또는 패스워드를 확인해 주세요.");			
			request.setAttribute("loc", "/loginFrm");
		}
		rd.forward(request, response);
		System.out.println("asdf");
		System.out.println("_");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
