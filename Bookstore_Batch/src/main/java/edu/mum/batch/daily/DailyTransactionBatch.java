package edu.mum.batch.daily;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class DailyTransactionBatch {

	@Autowired
	@Qualifier("dailyTransactionJob")
	private Job generateDailyTransaction;

	@Autowired
	private JobLauncher jobLauncher;
	
	
	@Scheduled(fixedDelay= 15000, initialDelay=2000)
	public void startjob() throws Exception {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println("Starting batch " + dateFormat.format(date));

		JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
		jobParametersBuilder.addDate("date", new Date());
		JobParameters jobParameters = jobParametersBuilder.toJobParameters();
		JobExecution jobExecution = jobLauncher.run(generateDailyTransaction, jobParameters);

		JobInstance jobInstance = jobExecution.getJobInstance();
		System.out.println("job instance Id: " + jobInstance.getId());
	}

}
