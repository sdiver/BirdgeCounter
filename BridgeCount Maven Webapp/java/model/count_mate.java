/*teammate name  infomation model class
 * 
 * author shi
 * 
 * time 2016/2/14
 * 
 * */

package model;

public class count_mate {
	
	private int mate_id;
	
	private int team_id;
	
	private String mate_name;

	/**
	 * @return the mate_id
	 */
	public int getMate_id() {
		return mate_id;
	}

	/**
	 * @param mate_id the mate_id to set
	 */
	public void setMate_id(int mate_id) {
		this.mate_id = mate_id;
	}

	/**
	 * @return the team_id
	 */
	public int getTeam_id() {
		return team_id;
	}

	/**
	 * @param team_id the team_id to set
	 */
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	/**
	 * @return the mate_name
	 */
	public String getMate_name() {
		return mate_name;
	}

	/**
	 * @param mate_name the mate_name to set
	 */
	public void setMate_name(String mate_name) {
		this.mate_name = mate_name;
	}
	
	
}
