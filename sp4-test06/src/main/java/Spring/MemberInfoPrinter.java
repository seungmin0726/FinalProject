package Spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {
	
	//변수위에  @Autowired 쓰는건 세터만 가능!   --> 생성자는 생성자 위에... 변수위에x
	private MemberDao memberDao ;
	private MemberPrinter printer ;
	
	@Autowired
	public MemberInfoPrinter(MemberDao memberDao, MemberPrinter printer) {
		
		this.memberDao = memberDao;
		this.printer = printer;
	}

	public void printMemberInfo(String email) {
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null) {
			System.out.println("회원정보가 존재하지 않습니다");
			return;
		}
		
		printer.print(dto);
	}
}
