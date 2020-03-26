/**
 * CircuitBreaker
 * 	    You apply it on the consumed services to stop blocking other callers in case of timeout.
 * 	    Example is Envoy.
 * 	    States :
 * 	      - Closed: All is good.
 * 	      - Open: when service exeeds timeout and failures
 * 	      - HalfOpen: when you try to close after open to test if things goes back to normal or not.
 *
 * Retries
 * 		You apply it on the caller side.
 * 		If you are calling a service that takes too much time to reply, don;t call again immediately but use any retry pattern with certain delays.
 */package com.code.test.designpatterns.circuitbreaker;