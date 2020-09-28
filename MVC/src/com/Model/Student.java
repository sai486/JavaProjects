package com.Model;

import java.io.Serializable;

public class Student implements Serializable {
private int sno;
private String sname;
private String spass;
private String mobilenumber;
private String cname;
public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getSpass() {
	return spass;
}
public void setSpass(String spass) {
	this.spass = spass;
}
public String getMobilenumber() {
	return mobilenumber;
}
public void setMobilenumber(String mobilenumber) {
	this.mobilenumber = mobilenumber;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
@Override
public String toString() {
	return "Student [sno=" + sno + ", sname=" + sname + ", spass=" + spass + ", mobilenumber=" + mobilenumber
			+ ", cname=" + cname + "]";
}
public Student(){}
public Student(int sno,String sname, String spass, String mobilenumber, String cname) {
	this();
	this.sno = sno;
	this.sname = sname;
	this.spass = spass;
	this.mobilenumber = mobilenumber;
	this.cname = cname;
}


}
