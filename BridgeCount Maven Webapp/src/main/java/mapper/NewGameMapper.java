/**
 *
 * @Title:NewGameMapper.java
 *
 * @Package:mapper
 *
 * @Description:TODO
 *
 * @author shi sdiver
 *
 * @date 2016年2月23日 上午9:28:46
 *
 * @version V1.0
 *
 */
package mapper;

import java.util.List;
import java.util.Map;

import model.count_adddesk;
import model.count_listteammate;
import model.count_score;
import model.count_user;

public interface NewGameMapper {
	
	public int ifexist(Map<Object, Object> map);
	
	public void addmatch(Map<Object, Object> map);
	
	public int searchmatchid(Map<Object, Object> map);
	
	public void initdesk(List<count_adddesk> list);
	
	public List<Integer> listdeskid(Map<Object, Object> map);
	
	public count_user listmate();
	
	public count_listteammate listteammate(Map<Object, Object> map);
	
	public void addmate(Map<Object, Object> map);
	
	public void deletemate(Map<Object, Object> map);
	
	public void initscore(List<count_score> list);
	
}

