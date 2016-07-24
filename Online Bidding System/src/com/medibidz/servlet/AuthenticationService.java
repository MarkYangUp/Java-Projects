package com.medibidz.servlet;

import javax.servlet.http.HttpSession;

import com.medibidz.entity.UserType;

public class AuthenticationService {
	
	public static AuthStatus checkValidAndAdmin(HttpSession session){
		
		UserType ut=(UserType) session.getAttribute("userType");
		if(ut==null)
			return AuthStatus.INVALID;
		else if(ut==UserType.ADMIN)
			return AuthStatus.VALID;
		
		return AuthStatus.UN_AUTHORIZED;
		
	}
public static AuthStatus checkValidAndUser(HttpSession session){
		
		UserType ut=(UserType) session.getAttribute("userType");
		if(ut==null)
			return AuthStatus.INVALID;
		else if(ut==UserType.FACULTY || ut==UserType.STUDENT)
			return AuthStatus.VALID;
		
		return AuthStatus.UN_AUTHORIZED;
		
	}
}
