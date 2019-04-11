package edu.mum.batch.service;

import java.util.List;

import edu.mum.batch.domain.DailyTransaction;

public interface DailyTransactionService {

	List<DailyTransaction> fetchDailyTransactions();
	
	List<DailyTransaction> fetchDailyTransactionsByOrder(String order);
	
	void createDailyTran(DailyTransaction dailyTransaction);
	
	void archiveDailyTransaction(DailyTransaction dailyTransaction);

	List<String> listTranOrderIds();


}
