/*match information model class
 * 
 * author shi
 * 
 * time 2016/2/14
 * 
 * */

package model;

import java.sql.Date;


public class count_match {

	private int match_id;
	
	private int match_code;
	
	private String match_name;
	
	private int match_cardnum;
	
	private int match_teamnum;
	
	private Date match_time;
	
	private int match_finish;

	/**
	 * @return the match_id
	 */
	public int getMatch_id() {
		return match_id;
	}

	/**
	 * @param match_id the match_id to set
	 */
	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}

	/**
	 * @return the match_name
	 */
	public String getMatch_name() {
		return match_name;
	}

	/**
	 * @param match_name the match_name to set
	 */
	public void setMatch_name(String match_name) {
		this.match_name = match_name;
	}

	/**
	 * @return the match_cardnum
	 */
	public int getMatch_cardnum() {
		return match_cardnum;
	}

	/**
	 * @param match_cardnum the match_cardnum to set
	 */
	public void setMatch_cardnum(int match_cardnum) {
		this.match_cardnum = match_cardnum;
	}

	/**
	 * @return the match_time
	 */
	public Date getMatch_time() {
		return match_time;
	}

	/**
	 * @param match_time the match_time to set
	 */
	public void setMatch_time(Date match_time) {
		this.match_time = match_time;
	}

	/**
	 * @return the match_finish
	 */
	public int getMatch_finish() {
		return match_finish;
	}

	/**
	 * @param match_finish the match_finish to set
	 */
	public void setMatch_finish(int match_finish) {
		this.match_finish = match_finish;
	}

	/**
	 * @return the match_teamnum
	 */
	public int getMatch_teamnum() {
		return match_teamnum;
	}

	/**
	 * @param match_teamnum the match_teamnum to set
	 */
	public void setMatch_teamnum(int match_teamnum) {
		this.match_teamnum = match_teamnum;
	}

	/**
	 * @return the match_code
	 */
	public int getMatch_code() {
		return match_code;
	}

	/**
	 * @param match_code the match_code to set
	 */
	public void setMatch_code(int match_code) {
		this.match_code = match_code;
	}
	
	
	
}
