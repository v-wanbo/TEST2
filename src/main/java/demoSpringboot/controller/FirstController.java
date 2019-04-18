package demoSpringboot.controller;

import java.net.InetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demoSpringboot.service.UserService;

@RestController
@RequestMapping({ "/user" })
public class FirstController { 
	@Autowired
	private UserService userService;

	/*  14:04  */
	
	@RequestMapping({ "/get" })
	public Object GetUserInfo() {
		return this.userService.GetUserInfo();
	}

	@RequestMapping("/hello")
	public String hello() {
		 // TODO Auto-generated method stub
        InetAddress ia=null;
        try {
            ia=ia.getLocalHost();
            
            String localname=ia.getHostName();
            String localip=ia.getHostAddress();
            System.out.println("本机名称是："+ localname);
            System.out.println("本机的ip是 ："+localip);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return "Hello 项目启动成功了！";
	}
}
