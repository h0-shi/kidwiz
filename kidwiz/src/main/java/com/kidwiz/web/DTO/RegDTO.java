package com.kidwiz.web.DTO;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegDTO {
	
 private char code;
 private String name, major_name, teacher, reg_no, time, regno, memo, proName; 
 private String content, goal, summary, homework, opinion, contact, gender, birth_date;
 private int age, stuNum, proNum, times, totalTimes, sub_no;
 private LocalDate date;
public char getCode() {
	return code;
}
public void setCode(char code) {
	this.code = code;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMajor_name() {
	return major_name;
}
public void setMajor_name(String major_name) {
	this.major_name = major_name;
}
public String getTeacher() {
	return teacher;
}
public void setTeacher(String teacher) {
	this.teacher = teacher;
}
public String getReg_no() {
	return reg_no;
}
public void setReg_no(String reg_no) {
	this.reg_no = reg_no;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getRegno() {
	return regno;
}
public void setRegno(String regno) {
	this.regno = regno;
}
public String getMemo() {
	return memo;
}
public void setMemo(String memo) {
	this.memo = memo;
}
public String getProName() {
	return proName;
}
public void setProName(String proName) {
	this.proName = proName;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getGoal() {
	return goal;
}
public void setGoal(String goal) {
	this.goal = goal;
}
public String getSummary() {
	return summary;
}
public void setSummary(String summary) {
	this.summary = summary;
}
public String getHomework() {
	return homework;
}
public void setHomework(String homework) {
	this.homework = homework;
}
public String getOpinion() {
	return opinion;
}
public void setOpinion(String opinion) {
	this.opinion = opinion;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getBirth_date() {
	return birth_date;
}
public void setBirth_date(String birth_date) {
	this.birth_date = birth_date;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getStuNum() {
	return stuNum;
}
public void setStuNum(int stuNum) {
	this.stuNum = stuNum;
}
public int getProNum() {
	return proNum;
}
public void setProNum(int proNum) {
	this.proNum = proNum;
}
public int getTimes() {
	return times;
}
public void setTimes(int times) {
	this.times = times;
}
public int getTotalTimes() {
	return totalTimes;
}
public void setTotalTimes(int totalTimes) {
	this.totalTimes = totalTimes;
}
public int getSub_no() {
	return sub_no;
}
public void setSub_no(int sub_no) {
	this.sub_no = sub_no;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
}
