package Spring;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {
	
	//여기에 @Autowired 있어도됨 (자동주입 할 대상 부터)
	private MemberDao memberDao ;
	
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void changePassword(String email, String oldPw,String newPw) {
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null) {
			System.out.println("이메일이 존재하지 않습니다.");
			return;
		}
		dto.changePassword(oldPw, newPw);
		memberDao.update(dto);
	}
}
