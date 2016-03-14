/**
 *
 * @Title:matchManagerServiceImpl.java
 *
 * @Package:service.serviceImpl
 *
 * @Description:TODO
 *
 * @author shi sdiver
 *
 * @date 2016年2月26日 上午10:34:30
 *
 * @version V1.0
 *
 */
package service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mapper.matchManagerMapper;
import model.count_desk;
import model.count_deskcanchoose;
import model.count_match;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.MatchManagerService;

@Service("matchManagerServiceImpl")

public class matchManagerServiceImpl implements MatchManagerService{

	@Autowired
	
	private matchManagerMapper matchmanagermapper;
	/* (non-Javadoc)
	 * @see service.MatchManagerService#matchlist()
	 */
	public Map<Object, Object> matchlist(int playerid) {
		
		// TODO Auto-generated method stub
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		map.put("playerid",playerid);
		
		List<count_match> mlist = matchmanagermapper.matchlist(map);
		
		Map<Object, Object> result = new HashMap<Object, Object>();
		
		result.put("result", mlist);
		
		return result;
	}
	
	/* (non-Javadoc)
	 * @see service.MatchManagerService#wheretosit(int)
	 */
	
	public Map<Object, Object> wheretosit(int matchid) {
	
		// TODO Auto-generated method stub
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		map.put("matchid", matchid);
		
		List<count_deskcanchoose> canchoosedesk = matchmanagermapper.wheretosit(map);
		
		Map<Object, Object> result = new HashMap<Object, Object>();
		
		result.put("result", canchoosedesk);
		
		return result;
	}
	
	/* (non-Javadoc)
	 * @see service.MatchManagerService#sitdown(int, int, int, int, int, java.lang.String)
	 */
	public Map<Object, Object> sitdown(int matchid, int deskid, int playerid, int direction) {
		
		// TODO Auto-generated method stub
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		map.put("matchid", matchid);
		
		map.put("playerid", playerid);
		
		int i = matchmanagermapper.ingame(map);
		
		int j = matchmanagermapper.sitted(map);
		
		Map<Object, Object> result = new HashMap<Object, Object>();
		
		if(i != 0 & j == 0){
			
			Map<Object, Object> mapsit = new HashMap<Object, Object>();
			
			mapsit.put("matchid", matchid);
			
			mapsit.put("deskid", deskid);
			
			switch(direction){
			
			case 1: 
				
				mapsit.put("desknorth", playerid);
				
				int m1 = matchmanagermapper.ifsitted(mapsit);
				
				if(m1 == 0){
					
					matchmanagermapper.sitdown(mapsit);
					
					result.put("result", "success");
					
				}else{
					
					result.put("result", "issitted");
					
				}
				
				break;
				
			case 2:
				
				mapsit.put("desksouth", playerid);
				
				int m2 = matchmanagermapper.ifsitted(mapsit);
				
				if(m2 == 0){
					
					matchmanagermapper.sitdown(mapsit);
					
					result.put("result", "success");
					
				}else{
					
					result.put("result", "issitted");
					
				}
				
				break;
				
			case 3:
				
				mapsit.put("deskeast", playerid);
				
				int m3 = matchmanagermapper.ifsitted(mapsit);
				
				if(m3 == 0){
					
					matchmanagermapper.sitdown(mapsit);
					
					result.put("result", "success");
					
				}else{
					
					result.put("result", "issitted");
					
				}
				
				break;
				
			case 4:
				
				mapsit.put("deskwest", playerid);
				
				int m4 = matchmanagermapper.ifsitted(mapsit);
				
				if(m4 == 0){
					
					matchmanagermapper.sitdown(mapsit);
					
					result.put("result", "success");
					
				}else{
					
					result.put("result", "issitted");
					
				}
				
				break;
				
			default:
				
				result.put("result", "error");
				
				break;
				
			}
			
			
		}else{
			
			result.put("result", "yousitted");
			
		}
		
		
		
		return result;
	}

	/* (non-Javadoc)
	 * @see service.MatchManagerService#sitcanbechoose(int, int)
	 */
	
	public Map<Object, Object> getup(int matchid, int deskid, int playerid, int newplayerid) {
		
		// TODO Auto-generated method stub
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		map.put("matchid", matchid);
		
		map.put("deskid", deskid);
		
		map.put("newplayerid", newplayerid);
		
		Map<Object, Object> result = new HashMap<Object, Object>();
		
		count_desk desk = matchmanagermapper.selectownerdesk(map);
		
		if(desk.getDesk_lock() == 0){
			
			//
			
			if(desk.getDesk_north() == playerid){
				
				map.put("desknorth", newplayerid);
				
				matchmanagermapper.sitdown(map);
					
				result.put("result", "success");
					
			}
			
			//
			
			if(desk.getDesk_south() == playerid){
				
				map.put("desksouth", newplayerid);
				
				matchmanagermapper.sitdown(map);
					
				result.put("result", "success");
				
			}
			
			//
			
			if(desk.getDesk_east() == playerid){
				
				map.put("deskeast", newplayerid);
				
				matchmanagermapper.sitdown(map);
					
				result.put("result", "success");
			
			}
			
			//
			
			if(desk.getDesk_west() == playerid){
				
				map.put("deskwest", newplayerid);
				
				matchmanagermapper.sitdown(map);
					
				result.put("result", "success");
					
			}

		}else{
			
			result.put("result", "gamestarted");
			
		}
		
		return result;
	}

	
}
