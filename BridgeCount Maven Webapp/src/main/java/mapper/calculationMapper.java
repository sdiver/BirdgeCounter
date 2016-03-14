/**
 *
 * @Title:calculationMapper.java
 *
 * @Package:mapper
 *
 * @Description:TODO
 *
 * @author shi sdiver
 *
 * @date 2016年3月2日 下午3:11:09
 *
 * @version V1.0
 *
 */
package mapper;

import java.util.List;
import java.util.Map;

import model.count_desk;
import model.count_score;

public interface calculationMapper {

	public String situation(Map<Object, Object> map);
	
	public int calculation(Map<Object, Object> map); 
	
	public int calculate(Map<Object, Object> map);
	
	public void updatescore(Map<Object, Object> map);
	
	public count_desk userinfo(Map<Object, Object> map);
	
	public List<count_score> scorelist(Map<Object, Object> map);
	
}
