import util.createRadomNumber;

/**
 *
 * @Title:test.java
 *
 * @Package:
 *
 * @Description:TODO
 *
 * @author shi sdiver
 *
 * @date 2016年2月22日 上午8:55:57
 *
 * @version V1.0
 *
 */

public class test {

	public static void main(String args[]){
		createRadomNumber rando1m = new createRadomNumber();
		System.out.println(rando1m.nextInt(100000, 9999999));
	}
}
