package com.code.test.problemset.Uber.TokenBucketRateLimiter;

/**
 * Created by aliismail on 30/11/2017.
 */
public interface RefillStrategy {
    long refill();

    long getIntervalInMillis();
}