/**
 *
 * @Title:calculationServiceImpl.java
 *
 * @Package:service.serviceImpl
 *
 * @Description:TODO
 *
 * @author shi sdiver
 *
 * @date 2016年3月2日 下午3:08:43
 *
 * @version V1.0
 *
 */
package service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mapper.calculationMapper;
import model.count_desk;
import model.count_score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.calculationService;

@Service("calculationServiceImpl")

public class calculationServiceImpl implements calculationService{

	@Autowired
	
	private calculationMapper calculationmapper;
	
	/* (non-Javadoc)
	 * @see service.calculationService#calculation(int, int, int, int, java.lang.String, int)
	 */
	@Transactional(rollbackFor=Exception.class)
	public Map<Object, Object> calculation(int count_declartionnumber, String count_declarationcard,
			int count_solution, String direciton, int num, int count_ifx,int score_id,int desk_id, String firstcard) {
		
		// TODO Auto-generated method stub
		Map<Object, Object> result = new HashMap<Object, Object>();
		
		int i = 0;
		
		int score = 0;
		
		switch(direciton){
		
			case "N":
				
			case "S":
				
				i = 1;
				
				break;
				
			case "E":
				
			case "W":
				
				i = 2;
				
				break;
				
			default:
			
		}
		
		if(count_solution >= 0){
		
			int card_num = num % 16;
			
			Map<Object, Object> map = new HashMap<Object, Object>();
			
			Map<Object, Object> map1 = new HashMap<Object, Object>();
			
			map1.put("card_num", card_num);
			
			String situation = calculationmapper.situation(map1);
			
			map.put("count_declartionnumber", count_declartionnumber);
			
			switch(count_declarationcard){
			
				case "C":
				
				case "D":
					
					map.put("count_declarationcard", 1);
					
					break;
					
				case "H":
					
				case "S":
					
					map.put("count_declarationcard", 2);
					
					break;
					
				case "NT":
					
					map.put("count_declarationcard", 0);
					
					break;
					
			}
			
			
			
			map.put("count_solution", count_solution);
			
			map.put("count_ifx", count_ifx);
			
			switch(situation){
				
				case "NONE":
					
					map.put("count_situation", 0);
					
					score = calculationmapper.calculation(map);
					
					break;
				
				case "BOTH":
					
					map.put("count_situation", 1);
					
					score = calculationmapper.calculation(map);
					
					break;
				
				case "SN":
					
					if(i == 1){
						
						map.put("count_situation", 1);
						
						score = calculationmapper.calculation(map);
						
					}else{
						
						map.put("count_situation", 0);
						
						score = calculationmapper.calculation(map);
						
					}
					
					break;
				
				case "EW":
					
					if(i == 2){
						
						map.put("count_situation", 1);
						
						score = calculationmapper.calculation(map);
						
					}else{
						
						map.put("count_situation", 0);
						
						score = calculationmapper.calculation(map);
						
					}
					
					break;
				
				default:break;
			}
			
			//insert win
			
			Map<Object, Object> userinfo = new HashMap<Object, Object>();
			
			Map<Object, Object> insertscore = new HashMap<Object, Object>();
			
			userinfo.put("desk_id", desk_id);
			
			count_desk user = calculationmapper.userinfo(userinfo);
			
			switch(direciton){
			
			case "N":
				
				insertscore.put("score_declarationman",user.getDesk_north());
				
				insertscore.put("score_nssolution", score);
				
				result.put("win_direction", "NS");
				
				break;
				
			case "S":
				
				insertscore.put("score_declarationman",user.getDesk_south());
				
				insertscore.put("score_nssolution", score);
				
				result.put("win_direction", "NS");
				
				break;
				
			case "E":
				
				insertscore.put("score_declarationman",user.getDesk_east());
				
				insertscore.put("score_ewsolution", score);
				
				result.put("win_direction", "EW");
				
				break;
				
			case "W":
				
				insertscore.put("score_declarationman",user.getDesk_west());
				
				insertscore.put("score_ewsolution", score);
				
				result.put("win_direction", "EW");
				
				break;
				
			default:
			
			}
			
			String score_declaration = count_declartionnumber+count_declarationcard ;
			
			insertscore.put("score_declaration", score_declaration);
			
			insertscore.put("firstcard", firstcard);
			
			insertscore.put("score_solution", count_solution);
			
			calculationmapper.updatescore(insertscore);
			
		}else{
			
			//pscore
			
			Map<Object, Object> map = new HashMap<Object, Object>();
			
			int solution = 0 - count_solution;
			
			map.put("count_punishnum", solution);
			
			map.put("count_ifx",count_ifx);
			
			Map<Object, Object> map1 = new HashMap<Object, Object>();
			
			int card_num = num % 16;
			
			map1.put("card_num", card_num);
			
			String situation = calculationmapper.situation(map1);
			
			switch(situation){
			
				case "NONE":
					
					map.put("count_situation", 0);
					
					score = calculationmapper.calculate(map);
					
					break;
				
				case "BOTH":
					
					map.put("count_situation", 1);
					
					score = calculationmapper.calculate(map);
					
					break;
				
				case "SN":
					
					if(i == 1){
						
						map.put("count_situation", 1);
						
						score = calculationmapper.calculate(map);
						
					}else{
						
						map.put("count_situation", 0);
						
						score = calculationmapper.calculate(map);
						
					}
					
					break;
				
				case "EW":
					
					if(i == 2){
						
						map.put("count_situation", 1);
						
						score = calculationmapper.calculate(map);
						
					}else{
						
						map.put("count_situation", 0);
						
						score = calculationmapper.calculate(map);
						
					}
					
					break;
				
				default:break;
			}
			
			Map<Object, Object> userinfo = new HashMap<Object, Object>();
			
			Map<Object, Object> insertscore = new HashMap<Object, Object>();
			
			userinfo.put("desk_id", desk_id);
			
			count_desk user = calculationmapper.userinfo(userinfo);
			
			switch(direciton){
			
			case "N":
				
				insertscore.put("score_declarationman",user.getDesk_north());
				
				insertscore.put("score_ewsolution", score);
				
				result.put("win_direction", "EW");
				
				break;
				
			case "S":
				
				insertscore.put("score_declarationman",user.getDesk_south());
				
				insertscore.put("score_ewsolution", score);
				
				result.put("win_direction", "EW");
				
				break;
				
			case "E":
				
				insertscore.put("score_declarationman",user.getDesk_east());
				
				insertscore.put("score_nssolution", score);
				
				result.put("win_direction", "NS");
				
				break;
				
			case "W":
				
				insertscore.put("score_declarationman",user.getDesk_west());
				
				insertscore.put("score_nssolution", score);
				
				result.put("win_direction", "NS");
				
				break;
				
			default:
			
			}
			
			String score_declaration = count_declartionnumber+count_declarationcard ;
			
			insertscore.put("score_declaration", score_declaration);
			
			insertscore.put("firstcard", firstcard);
			
			insertscore.put("score_solution", count_solution);
			
			calculationmapper.updatescore(insertscore);
			
		}
		
		result.put("result", score);
		
		return result;
	}
	
	
	public Map<Object, Object> scorelist(int match_id, int desk_id) {
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		map.put("match_id", match_id);
		
		map.put("desk_id", desk_id);
		
		List<count_score> scorelist = calculationmapper.scorelist(map);
		
		Map<Object, Object> result = new HashMap<Object, Object>();
		
		result.put("result", scorelist);
		
		return result; 
		
		
	}

	
}
