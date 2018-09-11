package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface EtcService {
	public boolean mailSend(HttpServletRequest request);
	//proxy 서버 구축 
	public String proxy(HttpServletRequest request);
	
	//push 
	public void push(HttpServletRequest request,HttpServletResponse response);
	
}
