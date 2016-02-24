/**
 *
 * @Title:NewGameManagerService.java
 *
 * @Package:service
 *
 * @Description:TODO
 *
 * @author shi sdiver
 *
 * @date 2016年2月20日 下午3:13:33
 *
 * @version V1.0
 *
 */
package service;

import java.sql.Date;
import java.util.Map;

public interface NewGameManagerService {

	public Map<Object, Object> addmatch(String matchname, int matchteam, int cardsnum, Date matchtime);
	
	public Map<Object, Object> listmate();
	
	public Map<Object, Object> addmate(int matchid, int teamid, int mateid);
	
	public Map<Object, Object> listteammate(int matchid, int teamid);
	
	public Map<Object, Object> deletemate(int matchid, int teamid, int mateid);
}
