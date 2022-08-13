package com.unipi.ipap.service;

public abstract class TransferService {

    public boolean transfer(long amount) {

        // Before
        beforeTransfer(amount);

        /**
         * Sample service transferring a given amount of money.
         * @return {@code true} when the transfer complete successfully, {@code false} otherwise.
         */
        try {
            Thread.sleep((long)(500 + Math.random() * 500)); // Emulate some work
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        // Emulate chance to fail
        boolean outcome = Math.random() > 0.25; // 25% change to fail

        // After
        afterTransfer(amount, outcome);
        return outcome;
    }

    abstract protected void beforeTransfer(long amount);

    abstract protected void afterTransfer(long amount, boolean outcome);

}
