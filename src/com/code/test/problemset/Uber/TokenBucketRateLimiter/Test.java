package com.code.test.problemset.Uber.TokenBucketRateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * Created by aliismail on 30/11/2017.
 */
public class Test {
    public static void main(String[] args){
        TokenBucket bucket = TokenBuckets.newFixedIntervalRefill(10, 10, 1, TimeUnit.SECONDS);
    }
}
