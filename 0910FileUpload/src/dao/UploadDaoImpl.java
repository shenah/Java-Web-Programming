package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import vo.UploadData;

public class UploadDaoImpl implements UploadDao {
	private UploadDaoImpl() {
		
	}
	
	private static UploadDao uploadDao;
	public static UploadDao sharedInstance() {
		if(uploadDao == null) {
			uploadDao = new UploadDaoImpl();
		
		}
		return uploadDao;
	}
	
	protected Connection con;
	protected PreparedStatement pstmt; 
	protected ResultSet rs;
	
	//데이터 베이스 접속을 수행해주는 메소드 
	protected void connect() {
		try {
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/DBConn");
		con = ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	protected void close() {
		try {
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();
			if(con != null)con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public int maxCode() {
		int code = 0;
		try{
			connect();
			pstmt=con.prepareStatement("select max(code) from uploaddata");
			rs = pstmt.executeQuery();
			//결과가 1개 - if
			if(rs.next()){
				code = rs.getInt("max(code)");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			close();
		}
		return code;
	}
	@Override
	public boolean insertUpload(UploadData uploadData) {
		boolean result = false;
		try {
			connect();
			pstmt=con.prepareStatement("insert into uploaddata(code, filename, filesize, description) values(?,?,?,?)");
			pstmt.setInt(1, uploadData.getCode()+1);
			pstmt.setString(2, uploadData.getFilename());
			pstmt.setInt(3, uploadData.getFilesize());
			pstmt.setString(4, uploadData.getDescription());
			int r = pstmt.executeUpdate();
			//결과가 1개 - if
			if(r > 0){
				result = true; 
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	@Override
	public List<UploadData>  uploadList() {
		List<UploadData> list = new ArrayList<>();
		try {
			connect();
			pstmt=con.prepareStatement("select * from uploaddata");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UploadData uploadData = new UploadData();
				uploadData.setCode(rs.getInt("code"));
				uploadData.setFilename(rs.getString("filename"));
				uploadData.setDescription(rs.getString("description"));
				uploadData.setFilesize(rs.getInt("filesize"));
				list.add(uploadData);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}
}
