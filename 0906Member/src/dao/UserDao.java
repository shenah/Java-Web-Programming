package dao;

import vo.AMember;

//데이터베이스 작업을 위한 메소드를 선언한 인터페이스 
public interface UserDao {
	
	//로그인 처리를 위한 메소드 
	//매개변수는 아이디와 비밀번호 - 하나로 묶어서 받는다 
	//처리결과는 아이디와 기타 필요한 정보 -> 하나로 묶어서 리턴 
	public AMember login(AMember amember);
	
	//회원가입 처리를 위한 메소드 
	public boolean register(AMember amember);
	
	//회원가입 이메일 중복체크를 위한 메소드
	public boolean emailCheck(String email);
	
	
}
