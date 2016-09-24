package com.web.test;

import com.utils.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Cookie 不足 Cookie 构造器是(String,String)类型 2不能保存敏感数据 cookie的升级版是Session
 * session失效：超时,HttpSession.invalidate(),服务器关闭 默认情况下cookie是在浏览器关闭时失效
 * Created by Edward on 2016/9/23.
 */
@Controller
@RequestMapping("/test/cookieSession")
public class TestCookie {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "test/cookieSession/index";
    }

    @ResponseBody
    @RequestMapping(value = "/addCookie",method = RequestMethod.GET)
    public void addCookie(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie = new Cookie("age", "123");//响应头有 Set-Cookie:age=123,当浏览器再次访问任何请求都回在请求头 Cookie(已有的cookie):age=123;
        response.addCookie(cookie);
    }

    @ResponseBody
    @RequestMapping(value = "/getCookie",method = RequestMethod.GET)
    public void getCookie(HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if(null != cookies && cookies.length > 0){
            for (Cookie cookie : cookies){
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println("name:"+name+",value:"+value);
            }
        }else {
            System.out.println("没有cookie信息");
        }

    }

    @ResponseBody
    @RequestMapping(value = "/addSession",method = RequestMethod.GET)
    public void addSession(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();//请求头 Cookie:JSESSIONID=B8857794C7D84A6FF6D038E7C74089A2 sessionId都放在Cookie
        session.setAttribute("user",new User("tom", DateUtils.getCurDate()));
    }

    @ResponseBody
    @RequestMapping(value = "/getSession",method = RequestMethod.GET)
    public void getSession(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println(user.toString());
    }
}
