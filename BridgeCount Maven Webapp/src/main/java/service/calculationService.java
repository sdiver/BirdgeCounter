/**
 *
 * @Title:calculationService.java
 *
 * @Package:service
 *
 * @Description:TODO
 *
 * @author shi sdiver
 *
 * @date 2016年3月2日 上午11:46:43
 *
 * @version V1.0
 *
 */
package service;

import java.util.Map;

public interface calculationService {

	public Map<Object, Object> calculation(int count_declartionnumber, String count_declarationcard, int count_solution, 
			
			String direciton, int num, int count_ifx,int score_id,int desk_id, String firstcard);

	public Map<Object, Object> scorelist(int match_id, int desk_id);
	
}
