/**
 *
 * @Title:RegisterController.java
 *
 * @Package:controller
 *
 * @Description:TODO
 *
 * @author shi sdiver
 *
 * @date 2016年2月20日 下午5:15:13
 *
 * @version V1.0
 *
 */
package controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.RegisterManagerService;

@Controller
@RequestMapping("/Register")

public class RegisterController {
	
	@Autowired
	private RegisterManagerService registermanagerservice;
	
	@RequestMapping(value = "/newplayer")
	public @ResponseBody
	JSONPObject newplayer(String callbackparam,String playername,String username,String password) throws Exception {
		
		Map<Object, Object> map = registermanagerservice.newplayer(playername, username, password);
		
		return new JSONPObject(callbackparam, map);
	}

	//jsonp version login
	@RequestMapping(value = "/playerlogin")
	public @ResponseBody
	JSONPObject playerlogin(String callbackparam,String Lusername,String Lpassword) throws Exception {
		
		Map<Object, Object> map = registermanagerservice.playerlogin(Lusername, Lpassword);
		
		return new JSONPObject(callbackparam, map);
	}
	
	//json version login
		@RequestMapping(value = "/playerjsonlogin", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
		public @ResponseBody
		Map<Object, Object> playerjsonlogin(HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			
			String username = request.getParameter("Lusername") ;
			
			String password = request.getParameter("Lpassword") ;
			
			Map<Object, Object> map = registermanagerservice.playerlogin(username, password);
			
			return map;
		}
		
}
