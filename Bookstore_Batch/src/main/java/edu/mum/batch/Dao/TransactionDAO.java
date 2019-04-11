package edu.mum.batch.Dao;

import java.util.List;

import edu.mum.batch.domain.Transaction;
import edu.mum.dao.GenericDao;

public interface TransactionDAO extends GenericDao<Transaction>{

	List<Transaction> fetchTransactionsByOredr(String orderNo);

}
