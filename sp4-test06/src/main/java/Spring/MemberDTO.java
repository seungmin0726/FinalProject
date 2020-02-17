package Spring;

import java.util.Date;

public class MemberDTO {
	private Long id;
	private String email;
	private String password;
	private String name;
	private Date registerdate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Date getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}
	
	
	public void changePassword(String oldPw,String newPw) {
		if( password.equals(oldPw)) {
			password = newPw;
		}else {
			System.out.println("비밀번호를 잘못 입력하셨습니다.");
		}
	}
}
