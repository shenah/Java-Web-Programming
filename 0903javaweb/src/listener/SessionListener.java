package listener;

import javax.servlet.http.HttpSessionEvent;

public class SessionListener implements javax.servlet.http.HttpSessionListener {

	static int cnt;
	//세션이 생성될 때 호출되는 메소드 - 새로운 사용자가 접속 
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		cnt = cnt + 1;
		System.out.println(cnt + "명 접속 중");

	}

	//
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		cnt = cnt - 1;
		System.out.println("사용자가 접속을 해제했습니다. " + cnt + "명 접속 중");

	}

}
