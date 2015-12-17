package cn.zjxu.exam.sp.domain;

public class SP {
	private String id;
	private String pid;
	private int grade;
	private boolean check;
	@Override
	public String toString() {
		return "SP [id=" + id + ", pid=" + pid + ", grade=" + grade
				+ ", check=" + check + "]";
	}
	public SP() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SP(String id, String pid, int grade, boolean check) {
		super();
		this.id = id;
		this.pid = pid;
		this.grade = grade;
		this.check = check;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
}
