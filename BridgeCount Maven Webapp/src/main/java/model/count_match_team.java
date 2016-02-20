/*combine match with team model class
 * 
 * author shi
 * 
 * time 2016/2/14
 * 
 * */

package model;

public class count_match_team {
	
	private int match_id;
	
	private int team_id;
	
	private String team_name;
	
	private int mate_id;

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
	 * @return the team_name
	 */
	public String getTeam_name() {
		return team_name;
	}

	/**
	 * @param team_name the team_name to set
	 */
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

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
	
	
}
