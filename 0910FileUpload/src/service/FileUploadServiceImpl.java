package service;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileUploadServiceImpl implements FileUploadService {
	
	private FileUploadServiceImpl() {
		
	};
	
	private static FileUploadService fileUploadService;
	
	public static FileUploadService sharedInstance() {
		if(fileUploadService == null) {
			fileUploadService = new FileUploadServiceImpl();
		}
		return fileUploadService;
		
	};
	@Override
	public Map<String, Object> fileUpload(HttpServletRequest request) {
		Map<String, Object> map = null;
		try {
			//읽은 파라미터 저장  - 업로드한 파일의 원래 이름과 업로드된 파일이름을 저장할 map 
			map = new HashMap<>();

			
			request.setCharacterEncoding("utf-8");
			
			//프로젝트 내의 WebContent/upload 
			String uploadpath = request.getServletContext().getRealPath("/upload");
			//파일 업로드를 위한 객체 
			MultipartRequest multi = new MultipartRequest(request, uploadpath, 1024*1024*10, "utf-8", new DefaultFileRenamePolicy());
			
			//파라미터 읽기 
			String name = multi.getParameter("name");
			map.put("name", name);

			
			//업로드 된 파일 이름 가져오기 
			Enumeration <String> files = multi.getFileNames();
			String filename = files.nextElement();
			String uploadname = multi.getFilesystemName(filename);
			
			//원본 이름 가져오기 
			String originalname = multi.getOriginalFileName(filename);
			
			map.put("filename", uploadname);
			map.put("originalname", originalname);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	
		return map;
	}

}
