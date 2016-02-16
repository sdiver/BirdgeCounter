package service;

import java.util.Map;

/**
*
* @Title:TeamManagerService
* @Package:
* @Description:team manager service for add and search team
* @auto shi sdiver
* @date ${date} ${time}
* @version V1.0
*
*/

public interface TeamManagerService {
	
	//new team
	public void addTeam(String Team_name);
	
	//search all team by team_id
	public Map<Object, Object> searchTeam(int Team_id);
	
}
