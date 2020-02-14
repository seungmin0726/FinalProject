package Spring;

public class MemberInfoPrinter {
	private MemberDao memberDao ;
	private MemberPrinter printer ;
	
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
