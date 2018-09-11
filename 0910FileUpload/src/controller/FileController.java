package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.FileUploadService;
import service.FileUploadServiceImpl;
import service.UploadService;
import service.UploadServiceImpl;
import vo.UploadData;


@WebServlet("*.file")
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static FileUploadService fileUploadService;
	private static UploadService uploadService;
	
    public FileController() {
        super();
        fileUploadService = FileUploadServiceImpl.sharedInstance();
        uploadService = UploadServiceImpl.sharedInstance();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURL = request.getRequestURI();
		String contextPath = request.getContextPath(); 
		String command = requestURL.substring(contextPath.length() + 1);
		
		HttpSession session = request.getSession();
		RequestDispatcher rd;
		
		System.out.println(command);
		switch(command) {
		
		case "fileupload.file":
			//단순 페이지 이동이나 서버에서 데이터를 조회한 후 출력할 때 forwarding을 주로 이용.
			rd = request.getRequestDispatcher("views/fileupload.jsp");
			rd.forward(request, response);
			break;
		
		case "upload.file":
			Map <String, Object> map = fileUploadService.fileUpload(request);
			
			//어떤 작업을 수행한 경우는 redirect로 페이지 이동 
			
			/*request.setAttribute("map", map);
			rd = request.getRequestDispatcher("views/result.jsp");
			rd.forward(request, response);*/
			
			session.setAttribute("map", map);
			//보안상 redirect 시 결과 페이지 경로를 숨겨야 하기 때문에 다시 url를 설정하고 controller에서 forwarding하는 방식으로 처리 
			//response.sendRedirect("views/result.jsp");
			response.sendRedirect("uploadresult.file");
			break;
			
		case "uploadresult.file":
			rd = request.getRequestDispatcher("views/result.jsp");
			rd.forward(request, response);
			break;
			
		case "input.file":
			rd = request.getRequestDispatcher("views/input.jsp");
			rd.forward(request, response);
			break;
		case "insert.file": 
			boolean result = uploadService.insertUpload(request);
			if(result == true) {
				response.sendRedirect("./");
			}else {
				response.sendRedirect("input.file");
			}
			break;
		case "list.file":
			List<UploadData> list = uploadService.uploadList(request);
			request.setAttribute("list", list);
			rd = request.getRequestDispatcher("views/list.jsp");
			rd.forward(request, response);
			break;
		 
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 요청 왔을 때 doGet을 호출 - 한 곳에서 모든 요청을 처리하기 위하여 
		doGet(request, response);
	}

}
