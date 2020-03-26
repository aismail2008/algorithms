package com.code.test.designpatterns.circuitbreaker;

/**
 * Created by aliismail on 16/12/2017.
 */
public @interface IgnoreCallsWhen {
    public static final long TIMEOUT = 1000;
    public static final long MAX_FAILURES = 3;

    /**
     * 1s max execution time of any public method of the monitored class.
     *
     * @return The overridden maximal execution time. Slower calls will increase
     * the counter and eventually close the circuit.
     */
    long slowerThanMillis() default TIMEOUT;

    /**
     * The maximal number of failures (exception occurrences and timeouts)
     * before the circuit opens.
     *
     * @return the threshold which closes the circuit.
     */
    long failures() default MAX_FAILURES;
}
