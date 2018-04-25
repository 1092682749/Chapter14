package com.ssm.chapter14.validator;

import com.ssm.chapter14.pojo.Transaction;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TransactionValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Transaction.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Transaction transaction = (Transaction) target;
        double dis = transaction.getAmount() - (transaction.getPrice() * transaction.getQuantity());
        if(Math.abs(dis) > 0.01)
        {
            errors.rejectValue("amount",null,"交易金额与数量价格不匹配");
        }
    }
}
