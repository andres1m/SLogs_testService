package ru.andres1m.SLogs_testService.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.net.http.HttpTimeoutException;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Component
public class TestService {
    public void doTestGet() throws Exception {
        if(!checkIfSuccess(70))
            throw new Exception("Not successful");
    }

    public void doTestPost() throws Exception {
        if(!checkIfSuccess(50))
            throw new Exception("Not successful");
    }

    private boolean checkIfSuccess(int chance){
        return chance > getRandomValue(0, 100);
    }

    private int getRandomValue(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}