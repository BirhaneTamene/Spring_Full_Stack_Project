package edu.mum.batch.service;

import java.util.List;

import edu.mum.batch.domain.DailyTransaction;
import edu.mum.batch.domain.Transaction;


public interface TransactionService {

	Transaction transferDailyToHistoricalTransaction(DailyTransaction dailyTransaction);

	Transaction createTransaction(Transaction tran);

	List<Transaction> fetchTransactionsByOrder(String orderNo);

}
