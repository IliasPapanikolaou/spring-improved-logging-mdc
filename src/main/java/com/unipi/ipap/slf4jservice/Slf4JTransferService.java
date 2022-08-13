package com.unipi.ipap.slf4jservice;

import com.unipi.ipap.service.TransferService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

@Slf4j
public class Slf4JTransferService extends TransferService {

    @Override
    protected void beforeTransfer(long amount) {
        log.info("Preparing to transfer ${}", amount
                + " - Transaction Id: " + MDC.get("transaction.id")
                + " transaction owner: " + MDC.get("transaction.owner"));
    }

    @Override
    protected void afterTransfer(long amount, boolean outcome) {
        log.info("Has the transaction {} of ${} completed successfully? {}",
                MDC.get("transaction.id"), amount, outcome);
    }
}
