package Spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Resource;

public class MemberListPrinter {
	
	@Autowired   // 변수마다 @Autowired 써주기
	@Resource(name="memberDao")
	private MemberDao memDao ;
	@Autowired
	private MemberPrinter printer;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memDao = memberDao;
	}

	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}

	public void printAll() {
		Collection<MemberDTO> lists = memDao.selectAll();
		System.out.println("총사용자의 수 :" + lists.size());
		
		for(MemberDTO dto : lists) {
			printer.print(dto);
		}
	}

}
