package domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String password;
	private Date regtime;
	private Integer islogin;
	private Set mesesesForGid = new HashSet(0);
	private Set mesesesForSid = new HashSet(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String name, String password, Date regtime, Integer islogin) {
		this.name = name;
		this.password = password;
		this.regtime = regtime;
		this.islogin = islogin;
	}

	/** full constructor */
	public Users(String name, String password, Date regtime, Integer islogin,
			Set mesesesForGid, Set mesesesForSid) {
		this.name = name;
		this.password = password;
		this.regtime = regtime;
		this.islogin = islogin;
		this.mesesesForGid = mesesesForGid;
		this.mesesesForSid = mesesesForSid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegtime() {
		return this.regtime;
	}

	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}

	public Integer getIslogin() {
		return this.islogin;
	}

	public void setIslogin(Integer islogin) {
		this.islogin = islogin;
	}

	public Set getMesesesForGid() {
		return this.mesesesForGid;
	}

	public void setMesesesForGid(Set mesesesForGid) {
		this.mesesesForGid = mesesesForGid;
	}

	public Set getMesesesForSid() {
		return this.mesesesForSid;
	}

	public void setMesesesForSid(Set mesesesForSid) {
		this.mesesesForSid = mesesesForSid;
	}

}