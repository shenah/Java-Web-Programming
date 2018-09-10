package service;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.UploadDao;
import dao.UploadDaoImpl;
import vo.UploadData;

public class UploadServiceImpl implements UploadService {
	
	private UploadDao uploadDao;
	private UploadServiceImpl() {
		uploadDao = UploadDaoImpl.sharedInstance();
	}
	private static UploadService uploadService;
	public static UploadService sharedInstance() {
		if(uploadService == null) {
			uploadService = new UploadServiceImpl();
		}
		return uploadService;
	}

	@Override
	public boolean insertUpload(HttpServletRequest request) {
		boolean result = false;
		try {		
			request.setCharacterEncoding("utf-8");
			
			//파일 업로드 작업처리 
			String uploadpath = request.getServletContext().getRealPath("/upload");
			MultipartRequest multi = new MultipartRequest(request, uploadpath, 1024*1024*10, "utf-8", new DefaultFileRenamePolicy());
			
			//가장 큰 code 찾아오기 
			int code = uploadDao.maxCode();
			//description 읽기 
			String description = multi.getParameter("description");
			//업로드된 파일명 찾아오기 
			Enumeration <String> files = multi.getFileNames();//파일 여러 개 선택될 수 있음 
		
			String filename = files.nextElement();
			String uploadname = multi.getFilesystemName(filename);
			//업로드된 파일 크기 가져오기 
			File f = new File(uploadpath + "/" + uploadname);
			int filesize = (int)f.length();
			
			//Dao 만들기 
			UploadData uploadData = new UploadData();
			uploadData.setCode(code);
			uploadData.setDescription(description);
			uploadData.setFilename(uploadname);
			uploadData.setFilesize(filesize);
			result = uploadDao.insertUpload(uploadData);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return result;
		
	}
}
