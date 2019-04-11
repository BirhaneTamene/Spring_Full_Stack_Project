package edu.mum.batch.daily;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.batch.domain.DailyTransaction;
import edu.mum.batch.domain.Transaction;
import edu.mum.batch.service.*;


@Component
public class DailyTransactionBatchReader implements ItemReader<Transaction> {

	@Autowired
	private DailyTransactionService dailyTransactionService;

	@Autowired
	private TransactionService transactionService;

	
	private List<DailyTransaction> dailyTransactions;
	private int currentIndex = 0;
	
	@PostConstruct
	private void init() {
		dailyTransactions = dailyTransactionService.fetchDailyTransactions();
	}
	
	@Override
	public Transaction read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		updateCurrentIndex();
		DailyTransaction dailyTransaction = this.dailyTransactions.get(currentIndex);
		Transaction transaction = transactionService.transferDailyToHistoricalTransaction(dailyTransaction);
		dailyTransactionService.archiveDailyTransaction(dailyTransaction);
		currentIndex++;
		return transaction;
	}
	
	private void updateCurrentIndex() {
		if (this.dailyTransactions == null || this.dailyTransactions.isEmpty())
			this.currentIndex = 0;
		if (currentIndex >= this.dailyTransactions.size())
			System.exit(0);
	}

}
