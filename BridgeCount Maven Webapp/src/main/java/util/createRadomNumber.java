/**
 *
 * @Title:createRadomNumber.java
 *
 * @Package:util
 *
 * @Description:TODO
 *
 * @author shi sdiver
 *
 * @date 2016年2月20日 下午3:34:09
 *
 * @version V1.0
 *
 */
package util;

import java.util.Random;

public class createRadomNumber {
	
	public int nextInt(final int min, final int max){

		Random rand= new Random();

		int tmp = Math.abs(rand.nextInt());

		return tmp % (max - min + 1) + min;
		
		

	}
}
