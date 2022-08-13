package com.unipi.ipap.model;

public class Transfer {

    private String transactionId;
    private String sender;
    private Long amount;

    public Transfer(String transactionId, String sender, Long amount) {
        this.transactionId = transactionId;
        this.sender = sender;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "transactionId='" + transactionId + '\'' +
                ", sender='" + sender + '\'' +
                ", amount=" + amount +
                '}';
    }
}
