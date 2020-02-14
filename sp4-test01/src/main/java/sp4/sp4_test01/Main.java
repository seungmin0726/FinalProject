package sp4.sp4_test01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
			Greeter gt = ctx.getBean("gr",Greeter.class);
			String msg = gt.greet("강승민");
			System.out.println("msg =" + msg);
			ctx.close();
	}

}
