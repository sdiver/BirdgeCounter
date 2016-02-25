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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.NewGameManagerService;

@Controller
@RequestMapping("/NewGame")

public class NewGameManagerController {
	
	@Autowired
	private NewGameManagerService newgamemanagerservice;
	
	@RequestMapping(value = "/addmatch")
	
	public @ResponseBody
	
	JSONPObject newplayer(String callbackparam,String matchname,String matchteam,String cardsnum, String matchtime) throws Exception {
		
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
		
		Date matchbtime = new java.sql.Date(formatter.parse("2016-02-22").getTime());
		
		int team = Integer.parseInt(matchteam);
		
		int num = Integer.parseInt(cardsnum);
		
		Map<Object, Object> map = newgamemanagerservice.addmatch(matchname, team, num, matchbtime);
		
		return new JSONPObject(callbackparam, map);
	}

		
}
