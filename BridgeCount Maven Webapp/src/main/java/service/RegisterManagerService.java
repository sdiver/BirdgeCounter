/**
 *
 * @Title:RegisterManagerService.java
 *
 * @Package:service
 *
 * @Description:TODO
 *
 * @author shi sdiver
 *
 * @date 2016年2月20日 下午3:10:05
 *
 * @version V1.0
 *
 */
package service;

import java.util.Map;

public interface RegisterManagerService {

	public Map<Object, Object> newplayer(String playername, String username, String password);
	
	public Map<Object, Object> playerlogin(String username, String password);
	
}
