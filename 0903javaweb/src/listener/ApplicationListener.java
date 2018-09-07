package listener;
import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;

public class ApplicationListener implements ServletContextListener, ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> arg0, ServletContext arg1) throws ServletException {
		// TODO Auto-generated method stub

	}
	//웹 애플리케이션이 종료될 때 호출되는 메소드 
	//사용한 외부 자원에 대한 연결 해제 작업을 주로 작성합니다.
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("웹 애플리케이션이 종료됩니다.");

	}
	
	//웹 애플리케이션이 시작될 때 호출되는 메소드 
	//서버에서 필요한 자원을 생성하는 작업을 주로 합니다. 
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("웹 애플리케이션을 시작합니다.");

	}

}
