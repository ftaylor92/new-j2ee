package com.fmt.servlet;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Hello world!
 *
 */
@SuppressWarnings("serial")
public class HelloServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException
    {
    	PrintWriter out= resp.getWriter();
    	out.println("Hello Servlet World!");
        
        Map<String, String> mp= new HashMap<String,String>();

        mp.put("one","111");
        mp.put("two","222");

        mp.forEach((k,v)->out.println(k+"="+v));
        
        out.println("java: "+ System.getProperty("java.version"));
    }
}
