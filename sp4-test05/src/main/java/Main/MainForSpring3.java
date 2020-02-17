package Main;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import Spring.ChangePasswordService;
import Spring.MemberInfoPrinter;
import Spring.MemberListPrinter;
import Spring.MemberRegisterService;
import Spring.RegisterRequest;
import Spring.VersionPrinter;

public class MainForSpring3 {
	//GenericXmlApplicationContext는 xml 파일 가져오게 해주는거
			private static GenericXmlApplicationContext ctx;
			public static void main(String[] args) {
				// TODO Auto-generated method stub
				//String [] conf = {"classpath:appCtx1.xml","classpath:appCtx2.xml"};
				ctx = new GenericXmlApplicationContext("classpath:configImport.xml");
				Scanner sc = new Scanner(System.in);
				
				while(true) {
					
				
				System.out.println("명령어를 입력하세요.");
				
				String command = sc.nextLine();
				if(command.equalsIgnoreCase("exit")) {
					System.out.println("프로그램이 종료되었습니다.");
					System.exit(0);   //운영체제는 0을 받으면 정상적으로 종료됐다고 받아들임
				}else if(command.startsWith("new ")) {
					String [] arg = command.split(" ");
					if(arg.length != 5) {
						printHelp();
					}
					RegisterRequest req = new RegisterRequest();
					req.setEmail(arg[1]);
					req.setName(arg[2]);
					req.setPassword(arg[3]);
					req.setConfirmPassword(arg[4]);
					boolean b1 = req.isPasswordEqualToConfirmPassword();
					if(!b1) {
						System.out.println("비밀번호가 일치하지 않습니다.");
						continue;
					}
					//의존객체 주입
					MemberRegisterService mrs = ctx.getBean("memberRegisterService",MemberRegisterService.class);
					mrs.regist(req);
					
				}else if(command.equals("list")){
					MemberListPrinter listPrint = ctx.getBean("memberListPrinter",MemberListPrinter.class);
					
					listPrint.printAll();
				}else if(command.startsWith("change ")) {
					String [] arg = command.split(" ");
					if(arg.length!=4) {
						printHelp();
						continue;
					}
					ChangePasswordService changePwdSvc = ctx.getBean("changePasswordService",ChangePasswordService.class);
					
					changePwdSvc.changePassword(arg[1],arg[2],arg[3]);
				}else if(command.startsWith("info ")) {
					String [] arg = command.split(" ");
					if(arg.length!=2) {
						printHelp();
						continue;
					}
					MemberInfoPrinter infoPrinter = ctx.getBean("memberInfoPrinter",MemberInfoPrinter.class);
					
					infoPrinter.printMemberInfo(arg[1]);
				}else if(command.equals("version")) {
					VersionPrinter versionPrinter = ctx.getBean("versionPrinter",VersionPrinter.class);
					versionPrinter.print();
				}else {
					printHelp();
				}
			}
		}
			public static void printHelp() {
				System.out.println();
				System.out.println("명령어 사용법");
				System.out.println("new 이메일 이름 암호 암호확인");
				System.out.println("change 이메일 현재비번 변경비번");
				System.out.println("list");
				System.out.println("info 이메일");
				System.out.println("version");
				
			}
}
