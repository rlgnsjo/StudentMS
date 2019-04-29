package com.shs.dto;

import java.util.Date;

public class MemberDTO {
	private int sid;
	private String sname;
	private int sage;
	private String smajor;
	private String sphone;
	private Date regdate;

	public MemberDTO() {
		// 생성자 메서드
	}

	public MemberDTO(String sname, int sage, String smajor, String sphone) {
		super();
		this.sname = sname;
		this.sage = sage;
		this.smajor = smajor;
		this.sphone = sphone;
	}

	public MemberDTO(int sid, String sname, int sage, String smajor, String sphone) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
		this.smajor = smajor;
		this.sphone = sphone;
	}

// 변수(실제 값이 들어가는공간) / 기본 생성자 모든변수포함생성자 / getter(하나씩 꺼낼때) setter(하나씩 넣을때) / toString 
	public MemberDTO(int sid, String sname, int sage, String smajor, String sphone, Date regdate) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sage = sage;
		this.smajor = smajor;
		this.sphone = sphone;
		this.regdate = regdate;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getSage() {
		return sage;
	}

	public void setSage(int sage) {
		this.sage = sage;
	}

	public String getSmajor() {
		return smajor;
	}

	public void setSmajor(String smajor) {
		this.smajor = smajor;
	}

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "MemberDTO [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", smajor=" + smajor + ", sphone="
				+ sphone + ", regdate=" + regdate + "]";
	}

}
