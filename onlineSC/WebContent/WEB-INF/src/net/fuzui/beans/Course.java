package net.fuzui.beans;

public class Course implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cid;
	private String cname;
	private String cintroduction;
	private String type;
	private String belongcoll;
	private String belongpro;
	
	public Course() {
		
	}
	
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCintroduction() {
		return cintroduction;
	}
	public void setCintroduction(String cintroduction) {
		this.cintroduction = cintroduction;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBelongcoll() {
		return belongcoll;
	}
	public void setBelongcoll(String belongcoll) {
		this.belongcoll = belongcoll;
	}
	public String getBelongpro() {
		return belongpro;
	}
	public void setBelongpro(String belongpro) {
		this.belongpro = belongpro;
	}
	
	
}
