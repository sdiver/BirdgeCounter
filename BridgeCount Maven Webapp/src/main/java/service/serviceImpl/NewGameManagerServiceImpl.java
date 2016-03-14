/**
 *
 * @Title:NewGameManagerServiceImpl.java
 *
 * @Package:service.serviceImpl
 *
 * @Description:TODO
 *
 * @author shi sdiver
 *
 * @date 2016年2月23日 上午8:53:41
 *
 * @version V1.0
 *
 */
package service.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mapper.NewGameMapper;
import model.count_adddesk;
import model.count_listteammate;
import model.count_score;
import model.count_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.NewGameManagerService;
import util.createRadomNumber;

@Service("NewGameManagerServiceImpl")
public class NewGameManagerServiceImpl implements NewGameManagerService {

	@Autowired
	
	private NewGameMapper newgamemapper; 
	
	createRadomNumber random = new createRadomNumber();
	
	/* (non-Javadoc)
	 * @see service.NewGameManagerService#addmatch(java.lang.String, int, int, java.sql.Date)
	 */
	
	@Transactional(rollbackFor=Exception.class)
	
	public Map<Object, Object> addmatch(String matchname, int matchteam,
			
			int cardsnum, Date matchtime) {
		
		// TODO Auto-generated method stub
		
		
		
		int randomNum = 0;
		
		int i = 0;
		
		while(i == 0){
		
			Map<Object, Object> codemap = new HashMap<Object, Object>();
			
			randomNum = random.nextInt(100000,999999);
			
			codemap.put("matchcode", randomNum);
			
			int ifexistcode = newgamemapper.ifexist(codemap);
			
			if(ifexistcode == 0){
				
				i ++;
				
			}
		
		}
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		map.put("matchcode", randomNum);
			
		map.put("matchname", matchname);
			
		map.put("matchteam", matchteam);
			
		map.put("cardsnum", cardsnum);
			
		map.put("matchtime", matchtime);
		
		//调用map
		
		newgamemapper.addmatch(map);
		
		Map<Object, Object> matchcode = new HashMap<Object, Object>();
		
		matchcode.put("matchcode", randomNum);
		
		int matchid = newgamemapper.searchmatchid(matchcode);
		
		int desk = matchteam/2 + 1;
		
		 List<count_adddesk> desklist = new ArrayList<count_adddesk>();
		
		for (int n = 1; n < desk; n++){
			
			int oposition = 0;
			
			int cposition = 1;
			
			count_adddesk count_desk1 = new count_adddesk();
			
			count_desk1.setMatch_id(matchid);
			
			count_desk1.setDesk_num(n);
			
			count_desk1.setDesk_ocposition(oposition);
			
			desklist.add(count_desk1);
			
			count_adddesk count_desk2 = new count_adddesk();
			
			count_desk2.setMatch_id(matchid);
			
			count_desk2.setDesk_num(n);
			
			count_desk2.setDesk_ocposition(cposition);
			
			desklist.add(count_desk2);
			
		}
		
		newgamemapper.initdesk(desklist);
		
		//get deskid
		
		Map<Object, Object> matchdeskid = new HashMap<Object, Object>();
		
		matchdeskid.put("matchid", matchid);
		
		List<Integer> listdeskid = newgamemapper.listdeskid(matchdeskid);
		
		List<count_score> scorelist = new ArrayList<count_score>();
		
		for(int a = 0;a < listdeskid.size(); a ++){
			
			for (int n = 1; n < cardsnum + 1; n++){
				
				count_score count_score = new count_score();
				
				count_score.setMatch_id(matchid);
				
				count_score.setDesk_id(listdeskid.get(a));
				
				count_score.setScore_cardid(n);
				
				scorelist.add(count_score);
				
			}
			
			
		}
		
		newgamemapper.initscore(scorelist);
		
		Map<Object, Object> result = new HashMap<Object, Object>();
		
		result.put("result", "success");
		
		result.put("matchid", matchid);
		
		return result;
		
	}

	/* (non-Javadoc)
	 * @see service.NewGameManagerService#listmate()
	 */
	
	public Map<Object, Object> listmate() {
		
		// TODO Auto-generated method stub
		
		List<count_user> listuser = newgamemapper.listmate();
		
		Map<Object, Object> result = new HashMap<Object, Object>();

		result.put("result", listuser);
		
		return result;
	}

	/* (non-Javadoc)
	 * @see service.NewGameManagerService#addmate(int, int, int)
	 */
	
	@Transactional(rollbackFor=Exception.class)
	
	public Map<Object, Object> addmate(int matchid, int teamid, int mateid) {
		
		// TODO Auto-generated method stub
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		map.put("matchid", matchid);
		
		map.put("teamid", teamid);
		
		map.put("mateid", mateid);
		
		int i = newgamemapper.checkmateid(map);
		
		Map<Object, Object> result = new HashMap<Object, Object>();
		
		if(i==0){
			
			newgamemapper.addmate(map);
			
			result.put("result", "success");
			
		}else{
			
			result.put("result", "false");
		
		}
		
		
		
		return result;
	}

	/* (non-Javadoc)
	 * @see service.NewGameManagerService#listteammate(int, int)
	 */
	public Map<Object, Object> listteammate(int matchid, int teamid) {
		
		// TODO Auto-generated method stub
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		map.put("matchid", matchid);
		
		map.put("teamid", teamid);
		
		List<count_listteammate> listplayer = newgamemapper.listteammate(map);
		
		Map<Object, Object> result = new HashMap<Object, Object>();

		result.put("result", listplayer);
		
		return result;
	}

	/* (non-Javadoc)
	 * @see service.NewGameManagerService#deletemate(int, int, int)
	 */
	
	@Transactional(rollbackFor=Exception.class)
	
	public Map<Object, Object> deletemate(int matchid, int teamid, int mateid) {
		
		// TODO Auto-generated method stub
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		map.put("matchid", matchid);
		
		map.put("teamid", teamid);
		
		map.put("mateid", mateid);
		
		newgamemapper.deletemate(map);
		
		Map<Object, Object> result = new HashMap<Object, Object>();
		
		result.put("result", "success");
		
		return result;
	}

}
