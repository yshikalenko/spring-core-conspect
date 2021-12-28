package guru.springframework.springbeanlifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanLifecycleApplication {

	public static void main(String[] args) {
		
		if (args.length < 1) {
			System.err.println("Parameter missed: contextResource");
			System.exit(1);
		}
		try (AbstractApplicationContext context1 = new ClassPathXmlApplicationContext(args[0])) {
			((AbstractApplicationContext) context1).registerShutdownHook();
		}

	}
}