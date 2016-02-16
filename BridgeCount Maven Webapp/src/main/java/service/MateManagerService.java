/**
 *
 * @Title:MateManagerService.java
 * 
 * @Package:service
 * 
 * @Description:teammate manager service
 * 
 * @auto shi sdiver
 * 
 * @date 2016年2月16日 下午3:39:31
 * 
 * @version V1.0
 *
 */
package service;

import java.util.Map;

public interface MateManagerService {
	
	//interface for add Team mate
	public void addTeammate(int team_id, String mate_name);
	
	//interface for search Team mate by team_id
	public Map<Object, Object> TeammateList(int team_id);
	
	//interface for search Team mate by mate_id
	public Map<Object, Object> TeammateById(int mate_id);
	
	//interface for delete Team mate
	public void deleteTeammate(int mate_id);
	
}
