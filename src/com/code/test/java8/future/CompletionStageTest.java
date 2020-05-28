package com.code.test.java8.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CompletionStageTest {
    static Executor service = Executors.newFixedThreadPool(10);

    public static void main(String argv[]) throws InterruptedException {
        multipleChains();
        testCompletableFuture();
        nestedCompletionStages();
        combineAsync();
        handlingException();
    }

    //-------------Helper Methods---------//
    static Person findReceiver() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("findReceiver runs with thread name: " + Thread.currentThread().getName());
        return new Person("Ali", "MR");
    }

    static void printWithThreadName(int s) {
        printWithThreadName(String.valueOf(s));
    }

    static void printWithThreadName(String s) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(s + ": printWithThreadName runs with thread name: " + Thread.currentThread().getName());
    }

    static int getMessageLength(String s) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("getMessageLength runs with thread name: " + Thread.currentThread().getName());
        return s.length();
    }

    static String getMessageRepeat(String s) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("getMessageRepeat runs with thread name: " + Thread.currentThread().getName());
        return s.repeat(2);//JDK 11
    }

    static String getDummyString() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("getDummyString runs with thread name: " + Thread.currentThread().getName());
        return "abc";
    }

    static CompletableFuture<String> sendMessageAsynch(Person p) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("sendMessageAsynch runs with thread name: " + Thread.currentThread().getName());
        return CompletableFuture.supplyAsync(() -> CompletionStageTest.getMessageRepeat("I am done Async! "));
    }

    //-------------Tests---------//
    static void multipleChains() {
        //-----------------Chaining multiple callbacks-------------------//
        // thenApply will execute after and return all results together of supply and ThenApply (all in same thread)
        // With thenApplyAsync second part will run in future mode and future object returns (in different threads)
        CompletableFuture.supplyAsync(CompletionStageTest::getDummyString, service)
                .thenApply(CompletionStageTest::getMessageRepeat) // vs .thenApplyAsync(..)
                .thenAccept(CompletionStageTest::printWithThreadName)
                .join();//otherwise system will end without print values as main thread ends before other completionStages do

        System.out.println("vs Async");
        //VS
        CompletableFuture.supplyAsync(CompletionStageTest::getDummyString, service)
                .thenApplyAsync(CompletionStageTest::getMessageLength, service)
                .thenAcceptAsync(CompletionStageTest::printWithThreadName, service)
                .join();//otherwise system will end without print values as main thread ends before other completionStages do;

        System.out.println("Done multipleChains!");
    }

    static void testCompletableFuture() {
        //------------ The simplest asynchronous computation ---------------//
        // supplyAsync takes Supplier<T> and returns T
        // thenAccept takes Consumer<? super T> and returns Void
        CompletableFuture<Void> cf = CompletableFuture.supplyAsync(CompletionStageTest::getDummyString)
                .thenAccept(System.out::println);
        System.out.println("Before ABC printed");

        //---------------------Get vs Join---------------//
        // Difference: Join is return unchecked exception but get return checkedExceptions
        String result = CompletableFuture.supplyAsync(CompletionStageTest::getDummyString).join();
        try {
            result = CompletableFuture.supplyAsync(CompletionStageTest::getDummyString).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Done testCompletableFuture!");
    }

    static void nestedCompletionStages() {
        //If we kept using thenApply to compose the example above, we would end up with nested CompletionStages.
        // CompletableFuture.supplyAsync(CompletionStageTest::findReceiver)
        //         .thenApply(CompletionStageTest::sendMessageAsynch);

        //instead we use thenCompose like a flat map
        CompletableFuture.supplyAsync(CompletionStageTest::findReceiver)
                .thenCompose(CompletionStageTest::sendMessageAsynch)
                .thenAccept(System.out::print)
                .join();//otherwise system will end without print values as main thread ends before other completionStages do

        System.out.println("Done nestedCompletionStages!");
    }

    static public void combineAsync() {
        CompletableFuture<Integer> firstTask = CompletableFuture.supplyAsync(
                () -> ThreadLocalRandom.current().nextInt(1, 100));

        CompletableFuture<String> secondTask = CompletableFuture.supplyAsync(
                () -> "Hello");

        firstTask.thenCombineAsync(secondTask, (f, s) -> {
            return (f + s.length());
            },
                service).thenAccept(System.out::println).join();

       // CompletableFuture.anyOf(firstTask, secondTask);
        System.out.println("Done combineAsync!");
    }

    static void handlingException() {
        //-----------------
        // Handle exceptions using exceptionally() callback
        // The exceptionally() callback gives you a chance to recover from errors generated from the original Future.
        // You can log the exception here and return a default value.
        Integer age = -1;

        CompletableFuture.supplyAsync(() -> {
            if (age < 0) {
                throw new IllegalArgumentException("Age can not be negative => Exceptionally");
            }
            if (age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return "Unknown!";
        }).thenAccept(System.out::println).join();

        // Handle exceptions using the generic handle() method
        // The API also provides a more generic method - handle() to recover from exceptions.
        // ***** It is called whether or not an exception occurs.*****

        Integer oldAge = 3;

        CompletableFuture.supplyAsync(() -> {
            if (oldAge < 0) {
                throw new IllegalArgumentException("Age can not be negative => Handle");
            }
            if (oldAge > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).handle((res, ex) -> {
            if (ex != null) {
                System.out.println("Oops! We have an exception - " + ex.getMessage());
                return "Unknown!";
            }
            res = "changed_In_Handle";
            return res;
        }).thenAccept(System.out::println).join();
    }

    static void anyOfExample() {
        StringBuilder result = new StringBuilder();
        List<String> messages = Arrays.asList("a", "b", "c");
        List<CompletableFuture<String>> futures = messages.stream()
                .map(msg -> CompletableFuture.completedFuture(msg).thenApply(s -> s))
                .collect(Collectors.toList());
        CompletableFuture.anyOf(futures.toArray(new CompletableFuture[futures.size()])).whenComplete((res, th) -> {
            if(th == null) {
                result.append(res);
            }
        });
    }
}
