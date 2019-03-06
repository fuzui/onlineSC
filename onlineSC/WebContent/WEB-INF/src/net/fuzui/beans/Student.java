package net.fuzui.beans;

public class Student implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sid;
	private String sname;
	private String sidcard;
	private String ssex;
	private String spassword;
	private String sage;
	private String classr;
	private String profession;
	private String college;
	
	
	public Student() {
		
	}
	
	
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSidcard() {
		return sidcard;
	}
	public void setSidcard(String sidcard) {
		this.sidcard = sidcard;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public String getSage() {
		return sage;
	}
	public void setSage(String sage) {
		this.sage = sage;
	}
	public String getClassr() {
		return classr;
	}
	public void setClassr(String classr) {
		this.classr = classr;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	
}
