package com.unipi.ipap.slf4jservice;

import com.unipi.ipap.model.Transfer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

@Slf4j
public class Slf4JRunnable implements Runnable {

    private final Transfer transfer;

    public Slf4JRunnable(Transfer transfer) {
        this.transfer = transfer;
    }

    @Override
    public void run() {
        MDC.put("transaction.id", transfer.getTransactionId());
        MDC.put("transaction.owner", transfer.getSender());
        new Slf4JTransferService().transfer(transfer.getAmount());
        MDC.clear();  // We don't need this with MdcAwareThreadPoolExecutor
    }
}
