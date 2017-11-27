package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Meses entity. @author MyEclipse Persistence Tools
 */

public class Meses implements java.io.Serializable {

	// Fields

	private Integer id;
	private Users usersByGid;
	private Users usersBySid;
	private String con;
	private Date stime;
	private Integer isget;

	// Constructors

	/** default constructor */
	public Meses() {
	}

	/** minimal constructor */
	public Meses(Users usersByGid, Users usersBySid, String con, Date stime) {
		this.usersByGid = usersByGid;
		this.usersBySid = usersBySid;
		this.con = con;
		this.stime = stime;
	}
	
	@Override
	public String toString() {
		
		return "{'id':'" + id + "', 'gName':'" + usersByGid.getName()
				+ "', 'sName':'" + usersBySid.getName() + "', 'con':'" + con + "', 'stime':'"
				+ stime.toLocaleString() + "'}";
	}

	/** full constructor */
	public Meses(Users usersByGid, Users usersBySid, String con, Date stime,
			Integer isget) {
		this.usersByGid = usersByGid;
		this.usersBySid = usersBySid;
		this.con = con;
		this.stime = stime;
		this.isget = isget;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Users getUsersByGid() {
		return this.usersByGid;
	}

	public void setUsersByGid(Users usersByGid) {
		this.usersByGid = usersByGid;
	}

	public Users getUsersBySid() {
		return this.usersBySid;
	}

	public void setUsersBySid(Users usersBySid) {
		this.usersBySid = usersBySid;
	}

	public String getCon() {
		return this.con;
	}

	public void setCon(String con) {
		this.con = con;
	}

	public Date getStime() {
		return this.stime;
	}

	public void setStime(Date stime) {
		this.stime = stime;
	}

	public Integer getIsget() {
		return this.isget;
	}

	public void setIsget(Integer isget) {
		this.isget = isget;
	}

}