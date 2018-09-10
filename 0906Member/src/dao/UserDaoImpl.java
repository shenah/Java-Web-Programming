package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import vo.AMember;

public class UserDaoImpl implements UserDao {
	//데이터베이스 연결을 위한 변수 
	//여러 개 메소드에서 공동으로 사용하므로 인스턴스 변수로 설정 
	private Connection con;
	private PreparedStatement pstmt; 
	private ResultSet rs;
	
	private UserDaoImpl() {
		//데이터베이스 드라이버 로드는 처음 한번만 하면 되므로 생성자에서 호출 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			
		}
	}
	
	private static UserDao userDao;
	
	public static UserDao sharedInstance() {
		if(userDao == null) {
			userDao = new UserDaoImpl();
		}
		return userDao;
	}

	@Override
	public AMember login(AMember amember) {
		AMember user = null;
		try {
			//con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.101:1521:xe", "user03", "user03");
			
			//context.xml 파일의 내용을 읽어오기 
			
			Context init = new InitialContext();
			//읽어온 내용 중에서 DBCon이라는 이름의 내용을 읽어서 데이터베이스 접속정보를 
			DataSource ds = (DataSource)init.lookup("java:comp/env/DBConn");
			//접속 정보를 이용해서 컨넥션을 빌려오기 
			con = ds.getConnection();
			
			
			//char로 저장된 데이터는 공백이 있으므로 조건에서 공백 제거하기
			pstmt = con.prepareStatement("select email, name from amember where trim(email)=? and trim(pw)=?"); 
			pstmt.setString(1, amember.getEmail().trim());
			pstmt.setString(2, amember.getPw().trim());
			rs = pstmt.executeQuery();
			//rs.next()는 한칸씩 옮기면서 true/false를 리턴 
			if(rs.next()){
				//결과를 저장할 인스턴스 생성 
				user = new AMember();
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(con != null)con.close();
			}catch(Exception e) {}
		}
		//데이터베이스에 입력한 email, pw와 일치한 데이터가 없으면 null이 리턴, 
		//있으면 회원 정보가 저장된 AMember 인스턴스를 리턴 
		System.out.println("리턴한 결과" +user);
		return user;
	}

	@Override
	public boolean register(AMember amember) {
		boolean result = false;
		try {
			//con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.101:1521:xe", "user03", "user03");
			
			//context.xml 파일의 내용을 읽어오기 
			
			Context init = new InitialContext();
			//읽어온 내용 중에서 DBCon이라는 이름의 내용을 읽어서 데이터베이스 접속정보를 
			DataSource ds = (DataSource) init.lookup("java:comp/env/DBConn");
			
			//접속 정보를 이용해서 컨넥션을 빌려오기 
			con = ds.getConnection(); 
			
			pstmt = con.prepareStatement("insert into amember(email, pw, name, phone, addr) values(?,?,?,?,?)");
			pstmt.setString(1, amember.getEmail());
			pstmt.setString(2, amember.getPw());
			pstmt.setString(3, amember.getName());
			pstmt.setString(4, amember.getPhone());
			pstmt.setString(5, amember.getAddr());
			int row = pstmt.executeUpdate();
			if(row > 0) {
				result = true;
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e){}
		}
		return result;
		
	}

	@Override
	public boolean emailCheck(String email) {
		boolean result = false;
		try {
			//con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.101:1521:xe", "user03", "user03");
			
			//context.xml 파일의 내용을 읽어오기 
			
			Context init = new InitialContext();
			//읽어온 내용 중에서 DBCon이라는 이름의 내용을 읽어서 데이터베이스 접속정보를 
			DataSource ds = (DataSource) init.lookup("java:comp/env/DBConn");
			
			//접속 정보를 이용해서 컨넥션을 빌려오기 
			con = ds.getConnection();
			
			pstmt = con.prepareStatement("select email from amember where email =?");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e){}
		}
		return result;
	}
}
