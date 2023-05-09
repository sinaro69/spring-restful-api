package com.istad.dataanalyticresfulapi.repository.provider;

import com.istad.dataanalyticresfulapi.model.Transaction;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class TransactionProvider {

    public String getTransactions(){
        return new SQL(){{
            SELECT("*");
            FROM("transaction_tb");

        }}.toString();

    }
    public String insertTransaction(Transaction transaction) {
        return new SQL() {{
            INSERT_INTO("transaction_tb");
            VALUES("sender_account_id", "#{sender_account_id}");
            VALUES("receiver_account", "#{receiver_account}");
            VALUES("amount", "#{amount}");
            VALUES("remark", "#{remark}");
            VALUES("transfer_at", "localtimestamp");
        }}.toString();
    }
    public String deleteTransaction(@Param("id") int id) {
        return new SQL() {{
            DELETE_FROM("transaction_tb");
            WHERE("id = #{id}");
        }}.toString();
    }

}
