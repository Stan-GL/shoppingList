package com.javaguru.shoppinglist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Random;

/*
<servlet>
<servlet-name>HelloServlet</servlet-name>
<servlet-class>com.javaguru.shoppinglist.web.HelloServlet</servlet-class>
</servlet>
<servlet-mapping>
<servlet-name>HelloServlet</servlet-name>
<url-pattern>/hello</url-pattern>
</servlet-mapping>

 @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        String  param = request.getParameter("productname");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h1>" + "Hello!" + "</h1>");
        out.println("<h1>" + "param-productname" + param + "</h1>");
*/
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap modelMap) {
        modelMap.addAttribute("message", "Hello!" + new Random().nextInt(101));
        return "hello";

    }

}
