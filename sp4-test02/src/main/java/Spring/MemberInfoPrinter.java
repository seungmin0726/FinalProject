package Spring;

public class MemberInfoPrinter {
	private MemberDao memberDao =new MemberDao();
	private MemberPrinter printer = new MemberPrinter();
	public void printMemberInfo(String email) {
		MemberDTO dto = memberDao.selectByEmail(email);
		if(dto == null) {
			System.out.println("회원정보가 존재하지 않습니다");
			return;
		}
		
		printer.print(dto);
	}
}
