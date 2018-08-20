package com.water.example.concert;

import org.springframework.stereotype.Service;

@Service
public class PerformanceImpl implements  Performance {


    @Override
    public void perform() {
        System.out.println(" perform");
    }
}
