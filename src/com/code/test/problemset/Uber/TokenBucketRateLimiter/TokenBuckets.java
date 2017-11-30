package com.code.test.problemset.Uber.TokenBucketRateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * Created by aliismail on 30/11/2017.
 */
public final class TokenBuckets {

    private TokenBuckets() {}

    public static TokenBucket newFixedIntervalRefill(long capacityTokens, long refillTokens, long period, TimeUnit unit)
    {
        RefillStrategy strategy = new FixedIntervalRefillStrategy(refillTokens, period, unit);
        return new TokenBucket(capacityTokens, strategy);
    }
}