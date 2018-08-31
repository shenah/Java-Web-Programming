package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Register() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//post로 받은 한글 파라미터 읽기 전에 encoding 처리해줘야 한다. 
		
		request.setCharacterEncoding("utf-8");
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		
		System.out.println("email:" + email);
		System.out.println("pw:" + pw);
		System.out.println("name:" + name);
		System.out.println("gender:" + gender);
		
		//결과 페이지에 전송할 데이터를 저장 
		request.getSession().setAttribute("msg", "회원가입에 성공하셨습니다.");
		
		//결과 페이지로 redirect
		response.sendRedirect("output.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
