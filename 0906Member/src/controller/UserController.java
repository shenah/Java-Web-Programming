package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import service.UserService;
import service.UserServiceImpl;
import vo.AMember;

@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 의존성 설정
	private UserService userService;

	public UserController() {
		super();
		userService = UserServiceImpl.sharedInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청경로에서 프로젝트 경로를 제거
		String requestURL = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURL.substring(contextPath.length() + 1);
		System.out.println(command);
		// 세션을 사용하는 경우가 많으므로 미리 생성
		HttpSession session = request.getSession();
		boolean r = false;
		switch (command) {
		case "user/login":
			// 서비스 메소드 호출
			AMember result = userService.login(request);
			// 로그인에 실패한 경우
			if (result == null) {
				session.setAttribute("result", result);
				session.setAttribute("msg", "이메일이나 비밀번호가 틀렸습니다.");
			} else {
				session.setAttribute("result", result);
			}
			// 로그인 성공여부에 관계없이 메인 페이지로 redirect
			// 현재 요청이 user/login 이므로 현재 위치는 user
			// 메인으로 갈려면 user 상위로 가야 합니다.
			response.sendRedirect("../");
		break;
		
		case "user/logout":
			session.invalidate();
			response.sendRedirect("../");
		break;
		
		case "user/register":
			RequestDispatcher rd = request.getRequestDispatcher("../member/register.jsp");
			rd.forward(request, response);
			
		break;
		
		case "user/insert":
			r = userService.register(request);
			if(r) {
				session.setAttribute("msgregister", "회원가입에 성공하셨습니다.");
				response.sendRedirect("../");
			}else {
				session.setAttribute("msgregister", "회원가입에 실패하셨습니다.");
				response.sendRedirect("register");//URL 조심 "../member/register.jsp"를 쓰면 디렉토리가 변경 
			}
		break;
		
		case "user/emailcheck":
			r = userService.emailCheck(request);
			//json으로 출력할 때는 리턴받은 데이터를 바로 저장하지 않고 
			//json 객체로 변환해서 저장 
			JSONObject obj = new JSONObject();
			obj.put("result", r);

			session.setAttribute("result", obj);
			response.sendRedirect("../member/emailcheck.jsp");
		
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
