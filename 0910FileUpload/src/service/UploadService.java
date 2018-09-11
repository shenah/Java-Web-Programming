package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import vo.UploadData;

public interface UploadService {
	public boolean insertUpload(HttpServletRequest request);
	public List<UploadData> uploadList(HttpServletRequest request);
}
