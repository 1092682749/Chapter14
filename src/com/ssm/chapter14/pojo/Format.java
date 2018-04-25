package com.ssm.chapter14.pojo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Format {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date1;

    @NumberFormat(pattern = "#,###.##")
    private BigDecimal amount1;

    public Date getDate() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public BigDecimal getAmount() {
        return amount1;
    }

    public void setAmount1(BigDecimal amount1) {
        this.amount1 = amount1;
    }

    @Override
    public String toString() {
        return "Format{" +
                "date=" + date1 +
                ", amount=" + amount1 +
                '}';
    }
}
