package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.EtcService;
import service.EtcServiceImpl;


public class EtcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private EtcService etcService;
    public EtcController() {
        super();
        etcService = EtcServiceImpl.sharedInstance();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURL = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURL.substring(contextPath.length()+1);
		System.out.println(command);
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		switch(command) {
		
		case "mailsend.do":
			rd = request.getRequestDispatcher("views/emailsend.jsp");
			rd.forward(request, response);
			break;
			
		case "sendmail.do":
			boolean r = etcService.mailSend(request);
			System.out.println(r);
			break;
			
		case "proxy.do":
			String xml =etcService.proxy(request);
			
			request.setAttribute("xml", xml);
			rd = request.getRequestDispatcher("views/proxy.jsp");
			rd.forward(request, response);
			break;
			
		case "push.do":
			etcService.push(request, response);
			break;
			
		}
		
			

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
