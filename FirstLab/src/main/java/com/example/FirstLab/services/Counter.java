package com.example.FirstLab.services;

import com.example.FirstLab.services.api.ICounter;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class Counter implements ICounter {

    private AtomicLong count = new AtomicLong();
    @Override
    public void increment() {
        count.getAndIncrement();
    }

    @Override
    public Long getCount() {
        return count.get();
    }
}
