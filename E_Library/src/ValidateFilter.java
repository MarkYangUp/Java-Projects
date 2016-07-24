
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ValidateFilter
 */
@WebFilter("/*")
public class ValidateFilter implements Filter {

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) res;
		String str=request.getServletPath();
		boolean next=false;
//		System.out.println("-------> "+str);
		
		if(str.startsWith("/Main") || str.startsWith("/assets")|| str.startsWith("/jq") || str.startsWith("/Invalid")||str.equals("/index.jsp")){
		next=true;
		}
		
		if(!next){			
			HttpSession session=request.getSession();			
				if(session.getAttribute("uid")==null){
					response.sendRedirect("Invalid.jsp");
					return;
				}
				next=true;
		}
		

		chain.doFilter(request, response);
		
		response.setContentType("text/html");
		response.setHeader("Cache-control", "no-cache");
		response.addHeader("Cache-Control", "no-store");  
		response.addHeader("Cache-Control", "must-revalidate");
		response.setHeader("pragma", "no-cache");
		System.out.println("<<<<<----"+request.getRequestURI());
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



}
