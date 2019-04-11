package edu.mum.batch.Dao;

import java.util.List;

import edu.mum.batch.domain.DailyTransaction;
import edu.mum.dao.GenericDao;

public interface DailyTransactionDAO extends GenericDao<DailyTransaction>{

	List<DailyTransaction> fetchDailyTransactionsByOrder(String order);

	List<String> listTranOrderIds();

}
