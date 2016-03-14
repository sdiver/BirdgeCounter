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

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Map;

import org.codehaus.jackson.map.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.NewGameManagerService;

@Controller
@RequestMapping("/NewGame")

public class NewGameManagerController {
	
	private static Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	
	private NewGameManagerService newgamemanagerservice;
	
	@RequestMapping(value = "/addmatch")
	
	public @ResponseBody
	
	JSONPObject newplayer(String callbackparam,String matchname,int matchteam,int cardsnum, String matchtime) throws Exception {
		
		logger.debug("TEST");
		
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
		
		Date matchbtime = new java.sql.Date(formatter.parse(matchtime).getTime());
		
		Map<Object, Object> map = newgamemanagerservice.addmatch(matchname, matchteam, cardsnum, matchbtime);
		
		return new JSONPObject(callbackparam, map);
	}
	
	@RequestMapping(value = "/listmate")
	
	public @ResponseBody
	
	JSONPObject listmate(String callbackparam) throws Exception {
		
		logger.debug("TEST");
		
		Map<Object, Object> map = newgamemanagerservice.listmate();
		
		return new JSONPObject(callbackparam, map);
	}

	@RequestMapping(value = "/addmate")
	
	public @ResponseBody
	
	JSONPObject addmate(String callbackparam, int matchid, int teamid, int mateid) throws Exception {
		
		logger.debug("TEST");
		
		Map<Object, Object> map = newgamemanagerservice.addmate(matchid, teamid, mateid);
		
		return new JSONPObject(callbackparam, map);
	}
	
	@RequestMapping(value = "/listteammate")
	
	public @ResponseBody
	
	JSONPObject listteammate(String callbackparam, int matchid, int teamid) throws Exception {
		
		logger.debug("TEST");
		
		Map<Object, Object> map = newgamemanagerservice.listteammate(matchid, teamid);
		
		return new JSONPObject(callbackparam, map);
	}
	
	@RequestMapping(value = "/deletemate")
	
	public @ResponseBody
	
	JSONPObject deletemate(String callbackparam, int matchid, int teamid, int mateid) throws Exception {
		
		logger.debug("TEST");
		
		Map<Object, Object> map = newgamemanagerservice.deletemate(matchid, teamid, mateid);
		
		return new JSONPObject(callbackparam, map);
	}
		
}
