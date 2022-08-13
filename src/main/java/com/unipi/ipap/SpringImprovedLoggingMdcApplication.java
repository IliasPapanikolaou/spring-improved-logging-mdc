package com.unipi.ipap;

import com.unipi.ipap.factory.TransactionFactory;
import com.unipi.ipap.model.Transfer;
import com.unipi.ipap.slf4jservice.Slf4JRunnable;
import com.unipi.ipap.slf4jservice.Slf4JTransferService;
import org.slf4j.MDC;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@SpringBootApplication
public class SpringImprovedLoggingMdcApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringImprovedLoggingMdcApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        TransactionFactory transactionFactory = new TransactionFactory();

        IntStream.rangeClosed(1,8).forEach(n -> {
            Transfer transfer = transactionFactory.newInstance();
            Runnable task = new Slf4JRunnable(transfer);
            executorService.submit(task);
        });

        executorService.shutdown();
    }
}
