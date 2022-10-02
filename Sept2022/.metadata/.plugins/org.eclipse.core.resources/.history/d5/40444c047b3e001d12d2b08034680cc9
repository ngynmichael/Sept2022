package com.michael.serv;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;



public class SecondServlet extends HttpServlet {



public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException,IOException{
        try{  
  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        HttpSession session=request.getSession(false);  
        String n=(String)session.getAttribute("abc");  
        out.print("Hello "+n);  
     //   session.invalidate();
  
        out.close();  
  
                }catch(Exception e){System.out.println(e);}  
    }



}
