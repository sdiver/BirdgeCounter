/**
 *
 * @Title:count_userMapper.java
 *
 * @Package:mapper
 *
 * @Description:TODO
 *
 * @author shi sdiver
 *
 * @date 2016年2月20日 下午4:31:01
 *
 * @version V1.0
 *
 */
package mapper;

import java.util.Map;

import model.count_user;

public interface RegisterMapper {
	
	public void newplayer(Map<Object, Object> map);
	
	public count_user playerlogin(Map<Object, Object> map);
	
	public int ifexist(Map<Object, Object> map);
	
	public int ifexistcode(Map<Object, Object> map);
	
}
