package cn.zjxu.exam.paper.domain;

public class Paper {
	private String pid;
	private String id;
	private int ownercode;
	private String paperhtml;
	@Override
	public String toString() {
		return "Paper [pid=" + pid + ", id=" + id + ", ownercode=" + ownercode
				+ ", paperhtml=" + paperhtml + "]";
	}
	public Paper() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Paper(String pid, String id, int ownercode, String paperhtml) {
		super();
		this.pid = pid;
		this.id = id;
		this.ownercode = ownercode;
		this.paperhtml = paperhtml;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getOwnercode() {
		return ownercode;
	}
	public void setOwnercode(int ownercode) {
		this.ownercode = ownercode;
	}
	public String getPaperhtml() {
		return paperhtml;
	}
	public void setPaperhtml(String paperhtml) {
		this.paperhtml = paperhtml;
	}
}
