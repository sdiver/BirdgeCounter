/**
 *
 * @Title:MatchManagerService.java
 *
 * @Package:service
 *
 * @Description:TODO
 *
 * @auto shi sdiver
 *
 * @date 2016年2月16日 下午4:43:51
 *
 * @version V1.0
 *
 */
package service;

import java.util.Map;

/**

 * @ClassName: MatchManagerService

 * @Description: TODO

 * @author shi sdiver

 * @date 2016年2月16日 下午4:43:51

 *


 */
public interface MatchManagerService {

	public Map<Object, Object> matchlist();
	
	public Map<Object, Object> sitdown(int matchid, int deskid, int desknum, int ocpositon, int playerid, String direciton);
	
	public Map<Object, Object> sitcanbechoose(int matchid, int playerid);
}
