package Spring;

import java.util.Date;

public class MemberRegisterService {
	private MemberDao memberDao ;
	public MemberRegisterService(MemberDao memberDao) {
		super();
		this.memberDao = memberDao;
	}
	public void regist(RegisterRequest req) {
		
		MemberDTO dto = memberDao.selectByEmail(req.getEmail());
		if(dto == null) {
			dto = new MemberDTO();
			dto.setEmail(req.getEmail());
			dto.setName(req.getName());
			dto.setPassword(req.getPassword());
			dto.setRegisterdate(new Date());
			memberDao.insert(dto);
			System.out.println("사용자 등록이 완료되었습니다.");
		}else {
			System.out.println("중복사용자 입니다.");
		}
	}
}
