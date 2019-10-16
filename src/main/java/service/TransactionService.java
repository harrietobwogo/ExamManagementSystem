package service;

import javax.transaction.SystemException;

/**
 * Created by Harriet on 10/16/2019.
 */
public interface TransactionService {
    String create();
    void rollback(String transactionKey);
    void commit(String transactionKey);
    void set(String transactionKey);
    String free() throws SystemException;
}
