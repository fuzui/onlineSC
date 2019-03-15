package net.fuzui.beans;

public class CoursePlan implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String courseclass;
	private String coursetime;
	private String courseweek;
	private String cid;
	private String tid;
	private String classroom;
	private String credits;
	private String period;
	private String totalnum;
	
	public CoursePlan() {
		
	}

	public String getCourseclass() {
		return courseclass;
	}

	public void setCourseclass(String courseclass) {
		this.courseclass = courseclass;
	}

	public String getCoursetime() {
		return coursetime;
	}

	public void setCoursetime(String coursetime) {
		this.coursetime = coursetime;
	}

	public String getCourseweek() {
		return courseweek;
	}

	public void setCourseweek(String courseweek) {
		this.courseweek = courseweek;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getCredits() {
		return credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getTotalnum() {
		return totalnum;
	}

	public void setTotalnum(String totalnum) {
		this.totalnum = totalnum;
	}
	
}
