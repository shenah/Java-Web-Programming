package test;

import dao.UserDao;
import dao.UserDaoImpl;
import vo.AMember;

public class Main {

	public static void main(String[] args) {
		UserDao userdao = UserDaoImpl.sharedInstance();
		AMember amember = new AMember();
		amember.setEmail("123@naver.com");
		amember.setPw("123456");
		amember.setPhone("1234566");
		amember.setName("관리자");
		amember.setAddr("OIFNVBLO");
		boolean r = userdao.register(amember);
		System.out.println(r);
	}

}
