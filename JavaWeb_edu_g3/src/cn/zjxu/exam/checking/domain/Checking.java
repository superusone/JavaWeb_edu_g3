package cn.zjxu.exam.checking.domain;

public class Checking {
	private String id;
	private String pid;
	private String paperhtml;
	@Override
	public String toString() {
		return "Checking [id=" + id + ", pid=" + pid + ", paperhtml="
				+ paperhtml + "]";
	}
	public Checking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Checking(String id, String pid, String paperhtml) {
		super();
		this.id = id;
		this.pid = pid;
		this.paperhtml = paperhtml;
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
	public String getPaperhtml() {
		return paperhtml;
	}
	public void setPaperhtml(String paperhtml) {
		this.paperhtml = paperhtml;
	}
}
