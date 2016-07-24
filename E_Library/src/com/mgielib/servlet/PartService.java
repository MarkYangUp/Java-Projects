package com.mgielib.servlet;

import javax.servlet.http.Part;

public class PartService {
public static String getFileName(Part part){
		String fn=null;
	String partHeader = part.getHeader("content-disposition");
	String [] s=partHeader.split(";");
    for (String e : s) {
    	System.out.println(e);
      if (e.trim().startsWith("filename")) {
    	  //remove " from filename
        fn=e.substring(e.indexOf('=') + 1).trim().replace("\"", "");
        System.out.println("FN="+fn);
        if(fn.indexOf("\\")!=0){
        	fn=fn.substring(fn.lastIndexOf("\\")+1);
        }
      }
    }
	return fn;
}
}
