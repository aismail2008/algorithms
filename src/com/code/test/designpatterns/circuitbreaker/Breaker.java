package com.code.test.designpatterns.circuitbreaker;

import java.util.concurrent.atomic.AtomicInteger;
//import javax.inject.Inject;
//import javax.interceptor.AroundInvoke;
//import javax.interceptor.InvocationContext;

/**
 * Created by aliismail on 16/12/2017.
 */

//https://dzone.com/articles/circuit-breaker-pattern
// https://howtodoinjava.com/spring-cloud/spring-hystrix-circuit-breaker-tutorial/
public class Breaker {
//    private AtomicInteger errorCount = new AtomicInteger(0);
//
//    @AroundInvoke
//    public Object guard(InvocationContext ic) throws Exception {
//        long maxFailures = IgnoreCallsWhen.MAX_FAILURES;
//        long maxDuration = IgnoreCallsWhen.TIMEOUT;
//        Method method = ic.getMethod();
//
//        boolean closeCircuit = method.isAnnotationPresent(CloseCircuit.class);//or in request header
//        if (closeCircuit) {
//            this.errorCount.set(0);
//        }
//
//        IgnoreCallsWhen configuration = method.
//                getAnnotation(IgnoreCallsWhen.class);
//        if (configuration != null) {
//            maxFailures = configuration.failures();
//            maxDuration = configuration.slowerThanMillis();
//        }
//        long start = System.currentTimeMillis();
//
//        try {
//            if (errorCount.get() >= maxFailures) {
//                return null;
//            }
//            return ic.proceed();
//        } catch (Exception ex) {
//            errorCount.incrementAndGet();
//            throw ex;
//        } finally {
//            long duration = System.currentTimeMillis() - start;
//            if (duration > maxDuration) {
//                errorCount.incrementAndGet();
//            }
//        }
//    }
}
