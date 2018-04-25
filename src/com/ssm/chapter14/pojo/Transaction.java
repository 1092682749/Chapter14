package com.ssm.chapter14.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class Transaction {
    @NotNull
    private Long productId;

    @NotNull
    private Long userId;

    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date date;

    @NotNull
    @DecimalMin(value="0.1")
    private Double price;

    @Min(1)
    @Max(100)
    @NotNull
    private Integer quantity;

    @NotNull
    @DecimalMax("500000.00")
    @DecimalMin("1.00")
    private Double amount;

    @Pattern(regexp = "^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@"+"([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Z" +
            "a-z]{2})?$",message = "邮箱格式错误")
    @Size(min = 0,max = 256)
    private String email;

    @Override
    public String toString() {
        return "Transaction{" +
                "productId=" + productId +
                ", userId=" + userId +
                ", date=" + date +
                ", price=" + price +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", email='" + email + '\'' +
                '}';
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
