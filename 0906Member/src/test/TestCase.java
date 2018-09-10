package test;

import org.junit.jupiter.api.Test;

import dao.UserDao;
import dao.UserDaoImpl;
import vo.AMember;

public class TestCase {
	@Test
	public void sampleTest() {
		UserDao userdao = UserDaoImpl.sharedInstance();

		System.out.println(userdao.emailCheck("dkkd@naver.com"));
	}
}
