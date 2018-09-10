package service;

import javax.servlet.http.HttpServletRequest;

import vo.AMember;

public interface UserService {

	public AMember login(HttpServletRequest request);
	public boolean register(HttpServletRequest request);
	public boolean emailCheck(HttpServletRequest request);
}
