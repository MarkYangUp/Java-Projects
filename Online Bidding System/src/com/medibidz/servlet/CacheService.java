package com.medibidz.servlet;

import javax.servlet.http.HttpServletResponse;

public class CacheService {
public static void off(HttpServletResponse response){
	response.setContentType("text/html");
	response.setHeader("Cache-control", "no-cache");
	response.addHeader("Cache-Control", "no-store");  
	response.addHeader("Cache-Control", "must-revalidate");
	response.setHeader("pragma", "no-cache");

}
}
