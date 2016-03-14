/**
 *
 * @Title:calculationController.java
 *
 * @Package:controller
 *
 * @Description:TODO
 *
 * @author shi sdiver
 *
 * @date 2016年3月2日 下午5:39:17
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

import service.calculationService;

@Controller

@RequestMapping("/calculation")

public class calculationController {
	
	private static Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	
	private calculationService calculationservice;
	
	@RequestMapping(value = "/score")
	
	public @ResponseBody
	
	JSONPObject score(String callbackparam, int count_declartionnumber, String count_declarationcard, 
			int count_solution, String direciton, int num, int count_ifx,int score_id, int desk_id, String firstcard) throws Exception {
		
		logger.debug("TEST");
		
		Map<Object, Object> map = calculationservice.calculation(count_declartionnumber, count_declarationcard, 
				count_solution, direciton, num, count_ifx, score_id, desk_id, firstcard);
				
		return new JSONPObject(callbackparam, map);
		
	}
	
	@RequestMapping(value = "/scorelist")
	
	public @ResponseBody
	
	JSONPObject scorelist(String callbackparam, int match_id, int desk_id) throws Exception {
		
		logger.debug("TEST");
		
		Map<Object, Object> map = calculationservice.scorelist(match_id, desk_id);
				
		return new JSONPObject(callbackparam, map);
		
	}
	
}
