package domain;

//** ~DTO 정의
//=> 멤버 변수: private, Table의 필드명과 동일하게...
//=> 외부 접근: getter/setter
//=> 자료 확인 편리성: toString 메서드 
//=> 자료초기화 편리성: 기본생성자, 모듬컬럼 초기화 생성자
public class MemberDTO {
	//** 맴버 변수
	private String id, password, name, info, birthday, rid;
	private int age, jno;
	private double point;
	
	//** 생성자
	public MemberDTO() {super();}
	public MemberDTO(String id, String password, String name, String info, String birthday, String rid, int age,
			int jno, double point) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.info = info;
		this.birthday = birthday;
		this.rid = rid;
		this.age = age;
		this.jno = jno;
		this.point = point;
	}
	//** getter/setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getJno() {
		return jno;
	}
	public void setJno(int jno) {
		this.jno = jno;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}

	//** toString
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", password=" + password + ", name=" + name + ", info=" + info + ", birthday="
				+ birthday + ", rid=" + rid + ", age=" + age + ", jno=" + jno + ", point=" + point + "]";
	}
	
	
	
	
}
