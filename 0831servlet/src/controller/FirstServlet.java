package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sk/*") // URL과 Servlet 클래스를 매핑시켜주는 어노테이션- URL 수정할 수 있음 

public class FirstServlet extends HttpServlet {
	
	//serialVersionUID- serializable 인터페이스를 implements 한 경우 구분하기 위한 코드 - 없으면 경고
	private static final long serialVersionUID = 1L;
       
    //생성자 
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	//get 방식으로 요청을 했을 때 호출되는 메소드 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//출력할 타입을 설정 
		response.setContentType("text/html; charset=utf-8");
		//출력 객체 만들기 
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<title>서블릿</title></head>");
		out.println("<body>처음 만드는 서브릿</body></html>");
	}

	//post 방식으로 요청을 했을 때 호출되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 처리를 doGet에게 위임 (delegate)
		doGet(request, response);
	}

}
