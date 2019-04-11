package edu.mum.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {

	public final static String[] configFiles = { 
			"/META-INF/spring/batch/applicationContext.xml",
			"/META-INF/spring/batch/batch-config.xml",
			"/META-INF/spring/batch/dailytransaction-job.xml"
			};

	public static void main(String[] args) throws Throwable {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configFiles, Main.class);
		applicationContext.getBean(Main.class).mainInternal(applicationContext);
	}

	private void mainInternal(ApplicationContext applicationContext) throws Exception {

	}
}