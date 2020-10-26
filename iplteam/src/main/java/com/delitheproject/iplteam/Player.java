package com.delitheproject.iplteam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;


@Entity
public class Player {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer pid;
	
	@NotNull
	private String pname;
	
	@NotNull
	private String ptype;
	
	@NotNull
	private Integer pmatches;
	
	@NotNull
	private Integer pruns;
	
	@NotNull
	private Integer pwickets;
	
	public Player(Integer pid, String pname, String ptype, Integer pmatches, Integer pruns, Integer pwickets) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.ptype = ptype;
		this.pmatches = pmatches;
		this.pruns = pruns;
		this.pwickets = pwickets;
	}
	
	public Player() {
		super();
	}

	@Override
	public String toString() {
		return "Team [pid=" + pid + ", pname=" + pname + ", ptype=" + ptype + ", pmatches=" + pmatches + ", pruns="
				+ pruns + ", pwickets=" + pwickets + "]";
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public Integer getPmatches() {
		return pmatches;
	}

	public void setPmatches(Integer pmatches) {
		this.pmatches = pmatches;
	}

	public Integer getPruns() {
		return pruns;
	}

	public void setPruns(Integer pruns) {
		this.pruns = pruns;
	}

	public Integer getPwickets() {
		return pwickets;
	}

	public void setPwickets(Integer pwickets) {
		this.pwickets = pwickets;
	}
	
}













