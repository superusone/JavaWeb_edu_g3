package cn.zjxu.exam.user.domain;

public class User {
	private String id;
	private String name;
	private String password;
	private String sex;
	private int age;
	private int mark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public User(String id, String name, String password, String sex, int age,
			int mark) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.mark = mark;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ ", sex=" + sex + ", age=" + age + ", mark=" + mark + "]";
	}

}
