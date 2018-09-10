package dao;

import vo.UploadData;

public interface UploadDao {
	//데이터베이스에서 가장 큰 code를 찾아오는 메소드 
	public int maxCode();
	//실제 데이터 삽입하는 메소드 
	public boolean insertUpload(UploadData uploadData);
}
