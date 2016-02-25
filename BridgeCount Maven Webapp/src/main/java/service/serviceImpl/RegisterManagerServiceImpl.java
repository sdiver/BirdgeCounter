/**
 *
 * @Title:RegisterManagerServiceImpl.java
 *
 * @Package:service.serviceImpl
 *
 * @Description:TODO
 *
 * @author shi sdiver
 *
 * @date 2016年2月20日 下午3:29:56
 *
 * @version V1.0
 *
 */
package service.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mapper.RegisterMapper;
import model.count_user;
import service.RegisterManagerService;
import util.createRadomNumber;

@Service("RegisterManagerServiceImpl")
public class RegisterManagerServiceImpl implements RegisterManagerService{

	@Autowired
	private RegisterMapper registermapper;
	
	createRadomNumber random = new createRadomNumber();
	/* (non-Javadoc)
	 * @see service.RegisterManagerService#newplayer(java.lang.String, java.lang.String)
	 */
	
	@Transactional(rollbackFor=Exception.class)
	
	public Map<Object, Object> newplayer(String playername, String username,
			String password) {
		// TODO Auto-generated method stub
		
		Map<Object, Object> result = new HashMap<Object, Object>();
		
		if(playername != null && playername != ""){
			
			if(username != null && username != ""){
			
				if(password != null && password != ""){
				
					int i = 0;
					
					
					
					int randomNum = 0;
					
					while(i == 0){
					
						Map<Object, Object> codemap = new HashMap<Object, Object>();
						
						randomNum = random.nextInt(100000,999999);
						
						int ifexistcode = registermapper.ifexistcode(codemap);
						
						if(ifexistcode == 0){
							
							i ++;
							
						}
					
					}
					
					int ifmanager = 0;
					
					Map<Object, Object> namemap = new HashMap<Object, Object>();
					
					namemap.put("username", username);
					
					int ifexist = registermapper.ifexist(namemap);
					
					if(ifexist == 0){
					
						Map<Object, Object> map = new HashMap<Object, Object>();
					
						map.put("playercode", randomNum);
					
						map.put("username", username);
					
						map.put("userpassword", password);
					
						map.put("playername", playername);
						
						map.put("ifmanager", ifmanager);
					
						//insert newuser mapper class here
						registermapper.newplayer(map);
					
						result.put("result", "success");
					
					}else{
						result.put("result","username exist");
					}
					
				}else{
				
					result.put("result","password is null");
				
				}
				
			}else{
				
				result.put("result","username is null");
			
			}
		
		}else{
			
			result.put("result","playername is null");

		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see service.RegisterManagerService#playerlogin(java.lang.String, java.lang.String)
	 */
	
	public Map<Object, Object> playerlogin(String username, String password) {
		// TODO Auto-generated method stub
		
		Map<Object, Object> result = new HashMap<Object, Object>();
		
		if( username != null && username != "" ){
			
			if( password != null && password != "" ){
				
				Map<Object, Object> map = new HashMap<Object, Object>();
				
				map.put("username", username);
			
				map.put("userpassword", password);
				
				count_user player = registermapper.playerlogin(map);
				
				if( player.getUsername() != null){
					
					result.put("player", player);
					
					result.put("result", "login success");
				
				}else{
					
					result.put("result", "wrong username or password");
					
				}
			
			}else{
			
				result.put("result", "password is null");
				
			}
			
		}else{
			
			result.put("result", "username is null");
			
		}
		return result;
	}

}
