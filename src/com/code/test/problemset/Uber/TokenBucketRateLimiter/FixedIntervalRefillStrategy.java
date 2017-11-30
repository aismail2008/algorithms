package com.code.test.problemset.Uber.TokenBucketRateLimiter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by aliismail on 30/11/2017.
 */
public class FixedIntervalRefillStrategy implements RefillStrategy {
    private final long numTokens;
    private final long intervalInMillis;
    private AtomicLong nextRefillTime;

    public FixedIntervalRefillStrategy(long numTokens, long interval, TimeUnit unit) {
        this.numTokens = numTokens;
        this.intervalInMillis = unit.toMillis(interval);
        this.nextRefillTime = new AtomicLong(-1L);
    }

    public long refill() {
        final long now = System.currentTimeMillis();
        final long refillTime = nextRefillTime.get();
        if (now < refillTime) {
            return 0;
        }

        return nextRefillTime.compareAndSet(refillTime, now + intervalInMillis) ? numTokens : 0;
    }

    public long getIntervalInMillis() {
        return intervalInMillis;
    }
}