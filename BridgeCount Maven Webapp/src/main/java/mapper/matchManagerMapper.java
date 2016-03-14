/**
 *
 * @Title:matchManagerControlMapper.java
 *
 * @Package:mapper
 *
 * @Description:TODO
 *
 * @author shi sdiver
 *
 * @date 2016年2月26日 下午12:09:57
 *
 * @version V1.0
 *
 */
package mapper;

import java.util.List;
import java.util.Map;

import model.count_desk;
import model.count_deskcanchoose;
import model.count_match;

public interface matchManagerMapper {

	public List<count_match> matchlist(Map<Object, Object> map);
	
	public List<count_deskcanchoose> wheretosit(Map<Object, Object> map);
	
	public int ingame(Map<Object, Object> map);
	
	public int sitted(Map<Object, Object> map);
	
	public int ifsitted(Map<Object, Object> map);
	
	public void sitdown(Map<Object, Object> map);
	
	public count_desk selectownerdesk(Map<Object, Object> map);
	
}
