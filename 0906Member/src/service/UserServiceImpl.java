package service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import dao.UserDao;
import dao.UserDaoImpl;
import vo.AMember;

public class UserServiceImpl implements UserService {
	
	//의존성 설정 
	private UserDao userDao;
	private UserServiceImpl() {
		userDao = UserDaoImpl.sharedInstance();
	}
	
	private static UserService userService;
	
	public static UserService sharedInstance() {
		if(userService == null) {
			userService = new UserServiceImpl();
		}
		return userService;
	}

	@Override
	public AMember login(HttpServletRequest request) {
		//파라미터 전부 읽기
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		//수행할 연산이 있으면 연산을 수행 
		
		//호출할 Dao 메소드의 매개변수를 생성 
		AMember amember = new AMember();
		amember.setEmail(email);
		amember.setPw(pw);
		
		//Dao 메소드 호출 
		AMember user = userDao.login(amember);
		
		//결과 리턴 
		return user;
	}

	@Override
	public boolean register(HttpServletRequest request) {
		//parameter 읽기 전에 인코딩 처리
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		AMember amember = new AMember();
		amember.setEmail(email);
		amember.setPw(pw);
		amember.setName(name);
		amember.setPhone(phone);
		amember.setAddr(addr);
		
		boolean result = userDao.register(amember);
		return result;
	}

	@Override
	public boolean emailCheck(HttpServletRequest request) {
		String email = request.getParameter("email");
		boolean result = userDao.emailCheck(email);
		return result;
	}
}
