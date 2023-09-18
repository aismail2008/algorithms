/**
 * CircuitBreaker
 * 	    You apply it on the consumed services to stop blocking other callers in case of timeout.
 * 	    Example is Envoy that is service mesh aware and call or wrap services.
 * 	    States :
 * 	      - Closed: All is good.
 * 	      - Open: when service exceeds timeout and failures
 * 	      - HalfOpen: when you try to close after open to test if things goes back to normal or not.
 *
 * Retries
 * 		You apply it on the Caller/Client side.
 * 		If you are calling a service that takes too much time to reply, don;t call again immediately but use any retry pattern with certain delays.
 */package com.code.test.designpatterns.circuitbreaker;