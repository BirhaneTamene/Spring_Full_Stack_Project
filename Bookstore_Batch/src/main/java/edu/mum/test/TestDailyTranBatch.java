package edu.mum.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import edu.mum.batch.daily.DailyTransactionBatch;

@Component
public class TestDailyTranBatch {

	@Autowired
	private DailyTransactionBatch dailyTransactionBatch;

	public final static String[] configFiles = {  
			
			"/META-INF/spring/batch/batch-config.xml",
			"/META-INF/spring/batch/dailytransaction-job.xml"};

	public static void main(String[] args) throws Throwable {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configFiles, TestDailyTranBatch.class);
		applicationContext.getBean(TestDailyTranBatch.class).mainInternal(applicationContext);
	}

	private void mainInternal(ApplicationContext applicationContext) throws Exception {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println("Starting System " + dateFormat.format(date));

		dailyTransactionBatch.startjob();

	}
}