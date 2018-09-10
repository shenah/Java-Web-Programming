package service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface FileUploadService {

	public Map<String, Object> fileUpload(HttpServletRequest request);
}
