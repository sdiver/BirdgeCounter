/**
 *
 * @Title:matchManagerController.java
 *
 * @Package:controller
 *
 * @Description:TODO
 *
 * @author shi sdiver
 *
 * @date 2016年2月26日 下午8:31:10
 *
 * @version V1.0
 *
 */
package controller;

import java.util.Map;

import org.codehaus.jackson.map.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.MatchManagerService;

@Controller

@RequestMapping("/match")

public class matchManagerController {
	
	private static Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	
	private MatchManagerService matchmanagerservice;
	
	@RequestMapping(value = "/matchlist")
	
	public @ResponseBody
	
	JSONPObject matchlist(String callbackparam, int playerid) throws Exception {
		
		logger.debug("TEST");
		
		Map<Object, Object> map = matchmanagerservice.matchlist(playerid);
		
		return new JSONPObject(callbackparam, map);
		
	}
	
	@RequestMapping(value = "/wheretosit")
	
	public @ResponseBody
	
	JSONPObject wheretosit(String callbackparam, int matchid) throws Exception {
		
		logger.debug("TEST");
		
		Map<Object, Object> map = matchmanagerservice.wheretosit(matchid);
		
		return new JSONPObject(callbackparam, map);
		
	}

	@RequestMapping(value = "/sitdown")
	
	public @ResponseBody
	
	JSONPObject sitdown(String callbackparam, int matchid, int deskid, int playerid, int direction) throws Exception {
		
		logger.debug("TEST");
		
		Map<Object, Object> map = matchmanagerservice.sitdown(matchid, deskid, playerid, direction);
		
		return new JSONPObject(callbackparam, map);
		
	}
	
	@RequestMapping(value = "/getup")
	
	public @ResponseBody
	
	JSONPObject getup(String callbackparam, int matchid, int deskid, int playerid) throws Exception {
		
		logger.debug("TEST");
		
		int newplayerid = 0;
		
		Map<Object, Object> map = matchmanagerservice.getup(matchid, deskid, playerid, newplayerid);
		
		return new JSONPObject(callbackparam, map);
		
	}
	
	
}
