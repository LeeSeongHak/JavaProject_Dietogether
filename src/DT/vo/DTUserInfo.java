package DT.vo;

public class DTUserInfo {
	private String id;
	private String password;
	private String name;
	private String phone;
	private String address;
	private String inputdate;
	
	public DTUserInfo() {
		
	}
	
	public DTUserInfo(String id) {
		this.id = id;
	}
	
	public DTUserInfo(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public DTUserInfo(String id, String password, String name, String phone, String address) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

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
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getinputdate() {
		return inputdate;
	}

	public void setinputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	@Override
	public String toString() {
		return "아이디 : " + id + " || 비밀번호 : " + password + " || 이름 : " + name + " || 연락처 : " + phone + " || 주소 : "
				+ address + " || 가입일 : " + inputdate;
	}
}
