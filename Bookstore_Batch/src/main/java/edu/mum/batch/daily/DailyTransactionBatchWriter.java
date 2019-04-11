package edu.mum.batch.daily;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.batch.domain.Transaction;
import edu.mum.batch.service.*;

@Component
public class DailyTransactionBatchWriter implements ItemWriter<Transaction> {

	@Autowired
	private TransactionService transactionService;

	@Override
	public void write(List<? extends Transaction> transactions) throws Exception {
		for (Transaction tran : transactions) {
			if( tran.getPostingTime()!=null) {
				this.transactionService.createTransaction(tran);
			}
			
		}
	}
}
