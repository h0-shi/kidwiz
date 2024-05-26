package com.kidwiz.web.DTO;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RsvDTO {

    private int rsvno;
    private int sid, state;
    private int proid;
    private String ctype, date;
    private String ctime;
    private LocalDate cdate;
    private LocalDate rsvdate;
    private String rsvmemo;
    private String major_head;
	public int getRsvno() {
		return rsvno;
	}
	public void setRsvno(int rsvno) {
		this.rsvno = rsvno;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public LocalDate getCdate() {
		return cdate;
	}
	public void setCdate(LocalDate cdate) {
		this.cdate = cdate;
	}
	public LocalDate getRsvdate() {
		return rsvdate;
	}
	public void setRsvdate(LocalDate rsvdate) {
		this.rsvdate = rsvdate;
	}
	public String getRsvmemo() {
		return rsvmemo;
	}
	public void setRsvmemo(String rsvmemo) {
		this.rsvmemo = rsvmemo;
	}
	public String getMajor_head() {
		return major_head;
	}
	public void setMajor_head(String major_head) {
		this.major_head = major_head;
	}
}
